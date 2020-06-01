package net.sattler22.patterns.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FlyWithWings implements FlyStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlyWithWings.class);

    @Override
    public void fly() {
        LOGGER.info("I'm flying!!!");
    }
}