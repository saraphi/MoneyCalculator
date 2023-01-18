package moneycalculator;

import view.*;
import model.*;
import persistence.*;
import control.*;

import java.util.List;
import persistence.interfaces.CurrencyLoader;
import persistence.interfaces.ExchangeRateLoader;
import view.interfaces.MCView;

public class MoneyCalculator {

    public static void main(String[] args) {
        CurrencyLoader currencyLoaderFromFile = new FileCurrencyLoader("currencies.txt");
        ExchangeRateLoader exchangeRateLoader = new WebExchangeRateLoader();
        List<Currency> currencies = currencyLoaderFromFile.load();
        
        MCController controller = new MCController(exchangeRateLoader);
        MCView view = new SwingMCView("Money Calculator", currencies, controller);
    }
}