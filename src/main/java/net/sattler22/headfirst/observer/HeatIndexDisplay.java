package net.sattler22.headfirst.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
final class HeatIndexDisplay extends BaseDisplay {

    private static final Logger logger = LoggerFactory.getLogger(HeatIndexDisplay.class);
    private volatile float heatIndex = 0.0f;
    private final Object lockObject = new Object();

    HeatIndexDisplay(Observable observable) {
        super(observable);
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable) {
        if (observable instanceof final WeatherData weatherData) {
            final var temperature = weatherData.getTemperature();
            final var humidity = weatherData.getHumidity();
            synchronized (lockObject) {
                heatIndex = (float)
                        (
                        (16.923 + (0.185212 * temperature)) +
                        (5.37941 * humidity) -
                        (0.100254 * temperature * humidity) +
                        (0.00941695 * (temperature * temperature)) +
                        (0.00728898 * (humidity * humidity)) +
                        (0.000345372 * (temperature * temperature * humidity)) -
                        (0.000814971 * (temperature * humidity * humidity)) +
                        (0.0000102102 * (temperature * temperature * humidity * humidity)) -
                        (0.000038646 * (temperature * temperature * temperature)) +
                        (0.0000291583 * (humidity * humidity * humidity)) +
                        (0.00000142721 * (temperature * temperature * temperature * humidity)) +
                        (0.000000197483 * (temperature * humidity * humidity * humidity)) -
                        (0.0000000218429 * (temperature * temperature * temperature * humidity * humidity)) +
                        (0.000000000843296 * (temperature * temperature * humidity * humidity * humidity)) -
                        (0.0000000000481975 * (temperature * temperature * temperature * humidity * humidity * humidity)));
                display();  //MVC would be better here!!!
            }
        }
    }

    @Override
    public void display() {
        logger.info("Heat index: {}", heatIndex);
    }
}
