package net.sattler22.headfirst.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jcip.annotations.Immutable;

@Immutable
final class MuteQuack implements QuackStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(MuteQuack.class);

    @Override
    public void quack() {
        LOGGER.info("<<Silence>>");
    }
}
