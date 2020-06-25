package net.sattler22.headfirst.decorator.starbuzz;

import net.jcip.annotations.Immutable;

@Immutable
final class HouseBlend extends Beverage {

    public HouseBlend() {
        super("House Blend");
    }

    @Override
    double cost() {
        return .89;
    }
}
