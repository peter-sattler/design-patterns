package net.sattler22.headfirst.decorator.starbuzz;

import net.jcip.annotations.Immutable;

@Immutable
final class Soy extends CondimentDecorator {

    Soy(Beverage beverage) {
        super(beverage, "Soy");
    }

    @Override
    double cost() {
        return super.cost(.15);
    }
}
