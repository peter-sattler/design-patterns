package net.sattler22.headfirst.decorator.starbuzz;

import net.jcip.annotations.Immutable;

@Immutable
final class Mocha extends CondimentDecorator {

    Mocha(Beverage beverage) {
        super(beverage, "Mocha");
    }

    @Override
    double cost() {
        return super.cost(.20);
    }
}
