package net.sattler22.headfirst.decorator.starbuzz;

abstract class Beverage {

    protected final String description;

    protected Beverage(String description) {
        this.description = description;
    }

    String getDescription() {
        return description;
    }

    abstract double cost();
}
