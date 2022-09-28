package model;

public class ExchangeRate {

    private Currency cFrom;
    private Currency cTo;
    private double rate;
    
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
}