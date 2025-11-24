package net.sattler22.headfirst.observer;

import net.jcip.annotations.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ThreadSafe
final class StatisticsDisplay extends BaseDisplay {

    private static final Logger logger = LoggerFactory.getLogger(StatisticsDisplay.class);
    private volatile float maxTemp = Float.MIN_VALUE;
    private volatile float minTemp = Float.MAX_VALUE;
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
            final float temperature = weatherData.getTemperature();
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
