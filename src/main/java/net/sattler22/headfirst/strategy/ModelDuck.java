package net.sattler22.headfirst.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jcip.annotations.Immutable;

@Immutable
final class ModelDuck extends Duck {

    private static final Logger logger = LoggerFactory.getLogger(ModelDuck.class);

    public ModelDuck() {
        super(new Quack(), new FlyNoWay());
    }

    public ModelDuck(Duck duck, FlyStrategy flyStrategy) {
        super(duck, flyStrategy);
    }

    @Override
    public void display() {
        logger.info("I'm a model duck");
    }
}
