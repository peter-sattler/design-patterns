package net.sattler22.headfirst.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
final class CurrentConditionsDisplay extends BaseDisplay {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentConditionsDisplay.class);
    private volatile float temperature;
    private volatile float humidity;
    private final Object lockObject = new Object();

    CurrentConditionsDisplay(Observable observable) {
        super(observable);
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable) {
        if (observable instanceof WeatherData) {
            final WeatherData weatherData = (WeatherData) observable;
            synchronized (lockObject) {
                this.temperature = weatherData.getTemperature();
                this.humidity = weatherData.getHumidity();
                display();    //MVC would be better here!!!
            }
        }
    }

    @Override
    public void display() {
        LOGGER.info("Current Conditions: {}F degrees and humidity {}%", temperature, humidity);
    }
}
