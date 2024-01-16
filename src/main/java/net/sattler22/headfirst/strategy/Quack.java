package net.sattler22.headfirst.strategy;

import net.jcip.annotations.Immutable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Immutable
final class Quack implements QuackStrategy {

    private static final Logger logger = LoggerFactory.getLogger(Quack.class);

    @Override
    public void quack() {
        logger.info("Quack");
    }
}
