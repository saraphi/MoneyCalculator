package control;

import model.*;
import persistence.interfaces.ExchangeRateLoader;
import view.interfaces.MCView;

public class MCController {
    
    ExchangeRateLoader exchangeRateLoader;
    
    public MCController(ExchangeRateLoader exchangeRateLoader) {
        this.exchangeRateLoader = exchangeRateLoader;
    }
    
    public void notifyChanges(MCView v) {
        Money moneyFrom = v.getMoneyFrom();
        Currency currencyTo = v.getCurrencyTo();
        
        Money moneyTo;
        if (! moneyFrom.getCurrency().getName().equals(currencyTo.getName())) {
            ExchangeRate exchangeRate = exchangeRateLoader.load(moneyFrom.getCurrency(), currencyTo);
            moneyTo = new Money(exchangeRate.convert(moneyFrom.getAmount()), currencyTo);
        } else moneyTo = moneyFrom;
        
        v.setMoneyTo(moneyTo);
        v.render();
    } 
}