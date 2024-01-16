package net.sattler22.headfirst.strategy;

import net.jcip.annotations.Immutable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Immutable
final class FlyNoWay implements FlyStrategy {

    private static final Logger logger = LoggerFactory.getLogger(FlyNoWay.class);

    @Override
    public void fly() {
        logger.info("I can't fly");
    }
}
