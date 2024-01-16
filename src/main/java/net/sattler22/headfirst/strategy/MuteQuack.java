package net.sattler22.headfirst.strategy;

import net.jcip.annotations.Immutable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Immutable
final class MuteQuack implements QuackStrategy {

    private static final Logger logger = LoggerFactory.getLogger(MuteQuack.class);

    @Override
    public void quack() {
        logger.info("<<Silence>>");
    }
}
