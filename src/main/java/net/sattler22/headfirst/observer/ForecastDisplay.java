package net.sattler22.headfirst.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
final class ForecastDisplay extends BaseDisplay {

    private static final Logger LOGGER = LoggerFactory.getLogger(ForecastDisplay.class);
    private static final String DISPLAY_TYPE = "Forecast";
    private volatile float currentPressure;
    private volatile float lastPressure;
    private final Object lockObject = new Object();

    ForecastDisplay(Observable observable) {
        super(observable);
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable) {
        if (observable instanceof final WeatherData weatherData)
            synchronized (lockObject) {
                lastPressure = currentPressure;
                currentPressure = weatherData.getPressure();
                display();      //MVC would be better here!!!
            }
    }

    @Override
    public void display() {
        if (currentPressure > lastPressure)
            LOGGER.info("{}: Improving weather on the way!", DISPLAY_TYPE);
        else if (currentPressure == lastPressure)
            LOGGER.info("{}: More of the same", DISPLAY_TYPE);
        else if (currentPressure < lastPressure)
            LOGGER.info("{}: Watch out for cooler, rainy weather", DISPLAY_TYPE);
    }
}
