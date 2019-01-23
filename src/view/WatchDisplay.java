package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import javax.swing.JPanel;

public class WatchDisplay extends JPanel {
    private final Image background;
    private Point[] points = new Point[0];

    public WatchDisplay(Image background) {
        this.background = background;
    }
    
    public void paint(Point[] points) {
        this.points = points;
        repaint();
    }
    
    public void paint(Graphics g) {
        int width = 1;
        g.drawImage(background, 0, 0, this);
        for (Point point : points)
            paint((Graphics2D) g, point, width++);
    }

    private void paint(Graphics2D g, Point point, int width) {
        int ox = getWidth() / 2;
        int oy = getHeight() / 2;
        g.setColor(Color.white);
        g.setStroke(new BasicStroke(width));
        g.drawLine(ox, oy, ox + point.x, oy - point.y);
    }
    
}
