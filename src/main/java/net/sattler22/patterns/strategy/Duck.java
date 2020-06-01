package net.sattler22.patterns.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class Duck {

    private static final Logger LOGGER = LoggerFactory.getLogger(Duck.class);

    protected final QuackStrategy quackStrategy;
    protected final FlyStrategy flyStrategy;

    protected Duck(QuackStrategy quackStrategy, FlyStrategy flyStrategy) {
        this.quackStrategy = quackStrategy;
        this.flyStrategy = flyStrategy;
    }

    protected Duck(Duck source, FlyStrategy flyStrategy) {
        this(source.quackStrategy, flyStrategy);
    }

    public void performFly() {
        flyStrategy.fly();
    }

    public void performQuack() {
        quackStrategy.quack();
    }

    public void swim() {
        LOGGER.info("All ducks float, even decoys!!!");
    }

    public abstract void display();
}
