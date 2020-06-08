package net.sattler22.headfirst.observer;

/**
 * Observer Interface
 * <p>
 * This observer uses the PULL notification model.
 * <p>
 * NOTE: The <code>java.util.Observer`</code> interface has been deprecated since Java 9.
 *
 * @author Pete Sattler
 * @version June 2020
 */
interface Observer {
    void update(Observable observable);
}
