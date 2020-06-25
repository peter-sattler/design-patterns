package net.sattler22.headfirst.decorator.starbuzz;

import net.jcip.annotations.Immutable;

@Immutable
final class Decaf extends Beverage {

    public Decaf() {
        super("Decaf");
    }

    @Override
    double cost() {
        return 1.05;
    }
}
