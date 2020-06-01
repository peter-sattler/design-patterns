package net.sattler22.patterns.strategy;

import org.junit.jupiter.api.Test;

/**
 * Heads First Design Patterns - Chapter 1
 * <p>
 * Strategy Pattern: Defines a family of algorithms (behaviors), encapsulating each one and makes them interchangeable. Strategy
 *                   lets the algorithm vary independently from the clients that use it
 * <p>
 * Lessons learned:
 * <ol>
 * <li>The one constant in software development is CHANGE.</li>
 * <li>Design Principle #1: Identify the aspects of your application that vary and separate them from what stays the same. In other
 *                          words, take what varies and encapsulate it so it won't affect the rest of your code.</li>
 * <li>Design Principle #2: Program to an interface, not an implementation.</li>
 * </ol>
 *
 * @author Pete Sattler
 * @version June 2020
 *
 */
final class MiniDuckSimulator {

    @Test
    void testDuck() {
        final Duck duck = new MallardDuck();
        duck.display();
        duck.swim();
        duck.performQuack();
        duck.performFly();
    }
}
