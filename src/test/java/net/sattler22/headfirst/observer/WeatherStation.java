package net.sattler22.headfirst.observer;

import org.junit.jupiter.api.Test;

/**
 * Heads First (OO) Design Patterns - Chapter 2
 * <p>
 * Observer Pattern: Defines a one-to-many dependency between objects so that when one object changes state, all its
 *                   dependents are notified and updated automatically.
 * <p>
 * Lessons learned:
 * <ol>
 * <li>OO Design Principle #4: Strive for loosely coupled designs between objects that interact.</li>
 * </ol>
 *
 * @author Pete Sattler
 * @version June 2020
 */
final class WeatherStation {

    @Test
    void testAllDisplays() {
        final WeatherData weatherData = new WeatherData();
        final CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        final StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        final ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        final HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82,  70,  29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
        currentConditionsDisplay.remove();
        statisticsDisplay.remove();
        forecastDisplay.remove();
        heatIndexDisplay.remove();
    }
}
