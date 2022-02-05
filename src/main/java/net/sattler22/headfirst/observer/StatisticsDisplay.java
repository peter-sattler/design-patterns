package net.sattler22.headfirst.observer;

import static java.lang.Float.MAX_VALUE;
import static java.lang.Float.MIN_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
final class StatisticsDisplay extends BaseDisplay {

    private static final Logger logger = LoggerFactory.getLogger(StatisticsDisplay.class);
    private volatile float maxTemp = MIN_VALUE;
    private volatile float minTemp = MAX_VALUE;
    private volatile float tempSum = 0f;
    private volatile int numReadings = 0;
    private final Object lockObject = new Object();

    StatisticsDisplay(Observable observable) {
        super(observable);
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable) {
        if (observable instanceof final WeatherData weatherData) {
            final var temperature = weatherData.getTemperature();
            synchronized (lockObject) {
                tempSum += temperature;
                numReadings++;
                if (temperature > maxTemp)
                    maxTemp = temperature;
                if (temperature < minTemp)
                    minTemp = temperature;
                display();    //MVC would be better here!!!
            }
        }
    }

    @Override
    public void display() {
        logger.info("Avg/Max/Min temperature: {} / {} / {}", (tempSum / numReadings), maxTemp, minTemp);
    }
}
