package model;

public class ExchangeRate {

    private Currency cFrom;
    private Currency cTo;
    private double rate;
    
    public ExchangeRate(Currency cFrom, Currency cTo) {
        this.cFrom = cFrom;
        this.cTo = cTo;
        this.rate = 0.0;
    }
    
    private void calculateRate() {
        rate = 0.0;     // ...
    }
    
    public double getRate() {
        calculateRate();
        return rate;
    }
    
    public void setCurrencyFrom(Currency cFrom) {
        this.cFrom = cFrom;
    }
    
    public void setCurrencyTo(Currency cTo) {
        this.cTo = cTo;
    }
}