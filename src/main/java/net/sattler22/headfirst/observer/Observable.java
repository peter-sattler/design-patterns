package net.sattler22.headfirst.observer;

/**
 * Observable (Subject) Interface
 * <p>
 * NOTE: The <code>java.util.Observable</code> class has been deprecated since Java 9.
 *
 * @author Pete Sattler
 * @version June 2020
 */
interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
