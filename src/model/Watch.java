package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Watch {
    private static final double StepSeconds = Math.PI * 2 / 60;
    private static final double StepMinutes = StepSeconds / 60;
    private static final double StepHours = StepMinutes / 12;
    private final List<Observer> observers = new ArrayList<>();
    private double hours = Math.PI / 2;
    private double minutes = Math.PI / 2;
    private double seconds = Math.PI / 2;

    public Watch() {
        Timer timer = new Timer();
        timer.schedule(timerTask(), 0, 1000);
    }

    public double getHours() {
        return hours;
    }

    public double getMinutes() {
        return minutes;
    }

    public double getSeconds() {
        return seconds;
    }
    
    public void add(Observer observer) {
        observers.add(observer);
    }

    private TimerTask timerTask() {
        return new TimerTask() {
            @Override
            public void run() {
                step();
                updateObserver();
            }
        };
    }
    
    private void updateObserver() {
        for (Observer observer : observers) 
            observer.update();
    }
    
    private void step() {
        seconds = normalize(seconds - StepSeconds);
        minutes = normalize(minutes - StepMinutes);
        hours = normalize(hours - StepHours);
    }

    private double normalize(double angle) {
        return (angle + Math.PI * 2) % (Math.PI*2);
    }
    
    public interface Observer {
        public void update();        
    }
    
}
