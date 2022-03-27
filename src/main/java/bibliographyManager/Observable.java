package main.java.bibliographyManager;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Observable {
    private ArrayList<Observer> observers;

    public Observable() {
        observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(){
        for (Iterator<Observer> iterator = observers.iterator(); iterator.hasNext();) {
            ((Observer) iterator.next()).update(this);
        }
    }
}
