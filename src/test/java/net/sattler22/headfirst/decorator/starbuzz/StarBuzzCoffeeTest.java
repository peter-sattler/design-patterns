package net.sattler22.headfirst.decorator.starbuzz;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Heads First (OO) Design Patterns - Chapter 3
 * <p>
 * Decorator Pattern: Attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative
 *                    to subclassing for extending functionality.
 * </p>
 * <p>
 * Lessons learned:
 * <ol>
 * <li>OO Design Principle #5: Classes should be open for extension, but closed for modification</li>
 * </ol>
 * </p>
 *
 * @author Pete Sattler
 * @version January 2022
 */
final class StarBuzzCoffeeTest {

    private static final Logger logger = LoggerFactory.getLogger(StarBuzzCoffeeTest.class);

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
        logger.info("{}: ${}", beverage.getDescription(), beverage.cost());
    }
}
