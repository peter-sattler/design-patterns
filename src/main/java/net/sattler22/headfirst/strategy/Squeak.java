package net.sattler22.headfirst.strategy;

import net.jcip.annotations.Immutable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Immutable
final class Squeak implements QuackStrategy {

    private static final Logger logger = LoggerFactory.getLogger(Squeak.class);

    @Override
    public void quack() {
        logger.info("Squeak");
    }
}
