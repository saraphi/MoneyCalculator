package moneycalculator.control;

import moneycalculator.view.MCViewFrame;
import moneycalculator.persistence.exchangerate.WebExchangeRateLoader;
import moneycalculator.persistence.currency.CurrencyLoader;
import moneycalculator.persistence.currency.FileCurrencyLoader;
import moneycalculator.persistence.exchangerate.ExchangeRateLoader;
import moneycalculator.model.Currency;
import moneycalculator.control.MCController;

import java.util.List;
import moneycalculator.view.MCView;

public class MoneyCalculator {

    public static void main(String[] args) {
        CurrencyLoader currencyLoader = new FileCurrencyLoader("currencies.txt");
        ExchangeRateLoader exchangeRateLoader = new WebExchangeRateLoader();
        List<Currency> currencies = currencyLoader.load();
        
        
        MCView view = new MCViewFrame("Money Calculator", currencies);
        MCController controller = new MCController(exchangeRateLoader, view);
    }
}