package net.sattler22.headfirst.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jcip.annotations.Immutable;

@Immutable
final class MallardDuck extends Duck {

    private static final Logger LOGGER = LoggerFactory.getLogger(MallardDuck.class);

    public MallardDuck() {
        super(new Quack(), new FlyWithWings());
    }

    @Override
    public void display() {
        LOGGER.info("I'm a real Mallard duck");
    }
}
