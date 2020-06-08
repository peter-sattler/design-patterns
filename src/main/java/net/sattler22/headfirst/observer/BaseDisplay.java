package net.sattler22.headfirst.observer;

abstract class BaseDisplay implements Observer, DisplayElement {

    protected final Observable observable;

    protected BaseDisplay(Observable observable) {
        this.observable = observable;
    }

    void remove() {
        observable.removeObserver(this);
    }
}
