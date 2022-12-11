import java.util.*;

public abstract class Subject {
    protected List<Observer> observers;

    public Subject() {
        this.observers = new ArrayList<>();
    }

    public Subject(List<Observer> observers) {
        this.observers = observers;
    }

    protected void attach(Observer observer) {
        observers.add(observer);
    }

    protected void detach(Observer observer) {
        observers.remove(observer);
    }

    protected void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
