package net.sattler22.patterns.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jcip.annotations.Immutable;

@Immutable
public final class ModelDuck extends Duck {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModelDuck.class);

    public ModelDuck() {
        super(new Quack(), new FlyNoWay());
    }

    public ModelDuck(Duck duck, FlyStrategy flyStrategy) {
        super(duck, flyStrategy);
    }

    @Override
    public void display() {
        LOGGER.info("I'm a model duck");
    }
}
