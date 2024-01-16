package net.sattler22.headfirst.observer;

import net.jcip.annotations.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ThreadSafe
final class CurrentConditionsDisplay extends BaseDisplay {

    private static final Logger logger = LoggerFactory.getLogger(CurrentConditionsDisplay.class);
    private volatile float temperature;
    private volatile float humidity;
    private final Object lockObject = new Object();

    CurrentConditionsDisplay(Observable observable) {
        super(observable);
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable) {
        if (observable instanceof final WeatherData weatherData)
            synchronized (lockObject) {
                this.temperature = weatherData.getTemperature();
                this.humidity = weatherData.getHumidity();
                display();    //MVC would be better here!!!
            }
    }

    @Override
    public void display() {
        logger.info("Current Conditions: {}F degrees and humidity {}%", temperature, humidity);
    }
}
