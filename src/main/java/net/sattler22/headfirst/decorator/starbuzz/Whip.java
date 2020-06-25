package net.sattler22.headfirst.decorator.starbuzz;

import net.jcip.annotations.Immutable;

@Immutable
final class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        super(beverage, "Whip");
    }

    @Override
    double cost() {
        return super.cost(.10);
    }
}
