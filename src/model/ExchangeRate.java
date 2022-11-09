package model;

import java.util.ArrayList;
import java.util.List;
import model.interfaces.ObserverNotifier;
import view.interfaces.Observer;

public class ExchangeRate implements ObserverNotifier {

    private final List<Observer> observers = new ArrayList<>();
    private final double rate;
    private Currency cFrom;
    private Currency cTo;
    
    public ExchangeRate(Currency cFrom, Currency cTo, double rate) {
        this.cFrom = cFrom;
        this.cTo = cTo;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
    
    public void setCurrencyFrom(Currency cFrom) {
        this.cFrom = cFrom;
    }
    
    public void setCurrencyTo(Currency cTo) {
        this.cTo = cTo;
    }

    public Currency[] getCurrencies() {
        return new Currency[] {cFrom, cTo};
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