package net.sattler22.headfirst.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jcip.annotations.Immutable;

@Immutable
final class FlyRocketPowered implements FlyStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlyRocketPowered.class);

    @Override
    public void fly() {
        LOGGER.info("I'm flying with a rocket!!!");
    }
}
