package net.sattler22.headfirst.strategy;

import net.jcip.annotations.Immutable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Immutable
final class MallardDuck extends Duck {

    private static final Logger logger = LoggerFactory.getLogger(MallardDuck.class);

    public MallardDuck() {
        super(new Quack(), new FlyWithWings());
    }

    @Override
    public void display() {
        logger.info("I'm a real Mallard duck");
    }
}
