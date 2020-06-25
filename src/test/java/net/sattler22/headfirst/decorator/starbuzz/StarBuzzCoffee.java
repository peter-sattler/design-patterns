package net.sattler22.headfirst.decorator.starbuzz;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Heads First (OO) Design Patterns - Chapter 3
 * <p>
 * Decorator Pattern: Attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative
 *                    to subclassing for extending functionality.
 * <p>
 * Lessons learned:
 * <ol>
 * <li>OO Design Principle #5: Classes should be open for extension, but closed for modification</li>
 * </ol>
 *
 * @author Pete Sattler
 * @version June 2020
 */
final class StarBuzzCoffee {

    private static final Logger LOGGER = LoggerFactory.getLogger(StarBuzzCoffee.class);

    @Test
    void expressoNoCondiments() {
        final Beverage beverage = new Expresso();
        logIt(beverage);
    }

    @Test
    void darkRoastDoubleMochaWithWhip() {
        final Beverage beverage = new Whip(new Mocha(new Mocha(new DarkRoast())));
        logIt(beverage);
    }

    @Test
    void houseBlendWithSoyMochaAndWhip() {
        final Beverage beverage = new Whip(new Mocha(new Soy(new HouseBlend())));
        logIt(beverage);
    }

    private static void logIt(Beverage beverage) {
        LOGGER.info("{}: ${}", beverage.getDescription(), beverage.cost());
    }
}
