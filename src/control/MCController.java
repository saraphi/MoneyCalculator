package control;

import persistence.ExchangeRateLoader;
import model.*;

public class MCController {
    
    private static final ExchangeRateLoader exchangeRateLoader = new ExchangeRateLoader();
    
    public static void convert(Money money, Currency currencyTo) {
        exchangeRateLoader.setCurrencies(money.getCurrency(), currencyTo);
        ExchangeRate rate = exchangeRateLoader.load();
        
    }
}