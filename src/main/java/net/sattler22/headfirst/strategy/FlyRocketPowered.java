package net.sattler22.headfirst.strategy;

import net.jcip.annotations.Immutable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Immutable
final class FlyRocketPowered implements FlyStrategy {

    private static final Logger logger = LoggerFactory.getLogger(FlyRocketPowered.class);

    @Override
    public void fly() {
        logger.info("I'm flying with a rocket!!!");
    }
}
