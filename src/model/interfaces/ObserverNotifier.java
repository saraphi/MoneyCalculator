package model.interfaces;

import view.interfaces.Observer;

public interface ObserverNotifier {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
