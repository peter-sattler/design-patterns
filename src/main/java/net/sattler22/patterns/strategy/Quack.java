package net.sattler22.patterns.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jcip.annotations.Immutable;

@Immutable
public final class Quack implements QuackStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(Quack.class);

    @Override
    public void quack() {
        LOGGER.info("Quack");
    }
}
