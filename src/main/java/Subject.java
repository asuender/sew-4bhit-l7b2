import java.util.*;

/**
 * This class acts as a base subject class to be used by every subject as required by the observer pattern.
 * It contains the methods to attach and detach observers and to notify them.
 * @author asuender
 * @version 0.2
 */
public abstract class Subject {
    private List<Observer> observers;

    public Subject() {
        this.observers = new ArrayList<>();
    }

    public Subject(List<Observer> observers) {
        this.observers = observers;
    }

    public List<Observer> getObservers() {
        return this.observers;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
