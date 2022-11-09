package model;

import java.util.ArrayList;
import java.util.List;
import model.interfaces.ObserverNotifier;
import view.interfaces.Observer;

public class Currency implements ObserverNotifier {

    private final List<Observer> observers = new ArrayList<>();
    private final String symbol;
    private final String code;
    private final String name;

    public Currency(String code, String name, String symbol) {
        this.symbol = symbol;
        this.code = code;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observers) o.refresh();
    }
    
    @Override
    public String toString() {
        return code + " - " + name;
    }
}