package net.sattler22.headfirst.decorator.starbuzz;

import net.jcip.annotations.Immutable;

@Immutable
final class DarkRoast extends Beverage {

    public DarkRoast() {
        super("Dark Roast");
    }

    @Override
    double cost() {
        return .99;
    }
}
