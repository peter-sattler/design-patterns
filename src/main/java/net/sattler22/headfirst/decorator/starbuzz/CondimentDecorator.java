package net.sattler22.headfirst.decorator.starbuzz;

abstract class CondimentDecorator extends Beverage {

    protected final Beverage beverage;

    protected CondimentDecorator(Beverage beverage, String condimentDescription) {
        super(beverage.getDescription() + ", " + condimentDescription);
        this.beverage = beverage;
    }

    protected double cost(double condimentCost) {
        return beverage.cost() + condimentCost;
    }
}
