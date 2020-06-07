package net.sattler22.patterns.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jcip.annotations.Immutable;

@Immutable
final class Squeak implements QuackStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(Squeak.class);

    @Override
    public void quack() {
        LOGGER.info("Squeak");
    }
}
