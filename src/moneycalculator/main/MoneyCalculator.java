package moneycalculator.main;

import moneycalculator.view.MCViewFrame;
import moneycalculator.persistence.WebExchangeRateLoader;
import moneycalculator.persistence.interfaces.CurrencyLoader;
import moneycalculator.persistence.FileCurrencyLoader;
import moneycalculator.persistence.interfaces.ExchangeRateLoader;
import moneycalculator.model.Currency;
import moneycalculator.control.MCController;

import java.util.List;
import moneycalculator.view.interfaces.MCView;

public class MoneyCalculator {

    public static void main(String[] args) {
        CurrencyLoader currencyLoader = new FileCurrencyLoader("currencies.txt");
        ExchangeRateLoader exchangeRateLoader = new WebExchangeRateLoader();
        List<Currency> currencies = currencyLoader.load();
        
        
        MCView view = new MCViewFrame("Money Calculator", currencies);
        MCController controller = new MCController(exchangeRateLoader, view);
    }
}