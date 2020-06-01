package net.sattler22.patterns.strategy;

import org.junit.jupiter.api.Test;

/**
 * Heads First (OO) Design Patterns - Chapter 1
 * <p>
 * Strategy Pattern: Defines a family of algorithms (behaviors), encapsulating each one and makes them interchangeable. Strategy
 *                   lets the algorithm vary independently from the clients that use it
 * <p>
 * Lessons learned:
 * <ol>
 * <li>The one constant in software development is CHANGE.</li>
 * <li>OO Design Principle #1: Identify the aspects of your application that vary and separate them from what stays the same. In other
 *                          words, take what varies and encapsulate it so it won't affect the rest of your code.</li>
 * <li>OO Design Principle #2: Program to an interface, not an implementation.</li>
 * <li>OO Design Principle #3: Favor composition over inheritance.</li>
 * </ol>
 *
 * @author Pete Sattler
 * @version June 2020
 *
 */
final class MiniDuckSimulator {

    @Test
    void testMallardDuck() {
        final Duck duck = new MallardDuck();
        duck.display();
        duck.swim();
        duck.performQuack();
        duck.performFly();
    }

    @Test
    void testModelDuck() {
        final Duck duck1 = new ModelDuck();
        duck1.display();
        duck1.swim();
        duck1.performQuack();
        duck1.performFly();
        //NOTE: Use Copy CTOR since classes are immutable!!!
        final Duck duck2 = new ModelDuck(duck1, new FlyRocketPowered());
        duck2.display();
        duck2.swim();
        duck2.performQuack();
        duck2.performFly();
    }
}
