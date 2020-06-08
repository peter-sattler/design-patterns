package net.sattler22.headfirst.observer;

import java.util.ArrayList;
import java.util.List;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
final class WeatherData implements Observable {

    private final List<Observer> observers = new ArrayList<>();
    private volatile float temperature;
    private volatile float humidity;
    private volatile float pressure;
    private final Object lockObject = new Object();

    @Override
    public void addObserver(Observer observer) {
        synchronized (lockObject) {
            if (!observers.contains(observer))
                observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        synchronized (lockObject) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        synchronized (lockObject) {
            for (final Observer observer : observers)
                observer.update(this);
        }
    }

    void setMeasurements(float temperature, float humidity, float pressure) {
        synchronized (lockObject) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
            notifyObservers();
        }
    }

    float getTemperature() {
        return temperature;
    }

    float getHumidity() {
        return humidity;
    }

    float getPressure() {
        return pressure;
    }
}
