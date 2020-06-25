package net.sattler22.headfirst.decorator.starbuzz;

import net.jcip.annotations.Immutable;

@Immutable
final class Expresso extends Beverage {

    Expresso() {
        super("Expresso");
    }

    @Override
    double cost() {
        return 1.99;
    }
}
