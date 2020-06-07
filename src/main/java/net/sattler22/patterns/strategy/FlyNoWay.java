package net.sattler22.patterns.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jcip.annotations.Immutable;

@Immutable
final class FlyNoWay implements FlyStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlyNoWay.class);

    @Override
    public void fly() {
        LOGGER.info("I can't fly");
    }
}
