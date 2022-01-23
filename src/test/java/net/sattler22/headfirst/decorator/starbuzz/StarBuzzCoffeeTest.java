package net.sattler22.headfirst.decorator.starbuzz;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
 * @version January 2022
 */
final class StarBuzzCoffeeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StarBuzzCoffeeTest.class);

    @Test
    void expressoNoCondiments() {
        final var beverage = new Expresso();
        logIt(beverage);
        assertTrue(true);  //SonarLint
    }

    @Test
    void darkRoastDoubleMochaWithWhip() {
        final var beverage = new Whip(new Mocha(new Mocha(new DarkRoast())));
        logIt(beverage);
        assertTrue(true);  //SonarLint
    }

    @Test
    void houseBlendWithSoyMochaAndWhip() {
        final var beverage = new Whip(new Mocha(new Soy(new HouseBlend())));
        logIt(beverage);
        assertTrue(true);  //SonarLint
    }

    private static void logIt(Beverage beverage) {
        LOGGER.info("{}: ${}", beverage.getDescription(), beverage.cost());
    }
}
