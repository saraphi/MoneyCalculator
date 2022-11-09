package model;

import java.util.ArrayList;
import java.util.List;
import model.interfaces.ObserverNotifier;
import view.interfaces.Observer;

public class Money implements ObserverNotifier {

    private final List<Observer> observers = new ArrayList<>();
    private double value;
    private Currency currency;
    
    public Money(double value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }
    
    public double getAmount() {
        return value;
    }
    
    public Currency getCurrency() {
        return currency;
    }
    
    public void setValue(double value) {
        this.value = value;
    }
    
    public void setCurrency(Currency currency) {
        this.currency = currency;
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
}