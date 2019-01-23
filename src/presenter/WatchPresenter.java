package presenter;

import view.WatchDisplay;
import model.Watch;
import java.awt.Point;

public class WatchPresenter implements Watch.Observer {
    private final Watch watch;
    private final WatchDisplay watchDisplay;

    public WatchPresenter(Watch watch, WatchDisplay watchDisplay) {
        this.watch = watch;
        this.watch.add(this);
        this.watchDisplay = watchDisplay;
    }
    
    @Override
    public void update() {
        refresh();
    }

    private void refresh() {
        watchDisplay.paint(pointsOf(watch));
    }

    private Point[] pointsOf(Watch watch) {
        Point[] points = new Point[3];
        points[0] = pointOf(watch.getSeconds(), 120);
        points[1] = pointOf(watch.getMinutes(), 90);
        points[2] = pointOf(watch.getHours(), 60);
        return points;
    }

    private Point pointOf(double angle, int length) {
        return new Point(toInt(length*Math.cos(angle)), toInt(length*Math.sin(angle)));
    }
    
    private int toInt(double value) {
        return (int) value;
    }
    
}
