package model;

public class ExchangeRate {

    private final double rate;
    private Currency cFrom;
    private Currency cTo;
    
    public ExchangeRate(Currency cFrom, Currency cTo, double rate) {
        this.cFrom = cFrom;
        this.cTo = cTo;
        this.rate = rate;
    }

    public double convert(double value) {
        return Math.round((value*rate)*100.0)/100.0;
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
}