package moneycalculator;

import model.*;
import java.util.List;
import persistence.CurrencyLoaderFromFile;

public class MoneyCalculator {

    public static void main(String[] args) {
        CurrencyLoaderFromFile currencyLoaderFromFile = new CurrencyLoaderFromFile("currencies.txt");
        List<Currency> list = currencyLoaderFromFile.loadCurrencies();
        for (Currency currency : list) {
            System.out.println(currency.getCode() + " - " + currency.getName() + " - " + currency.getSymbol());
        }
    }
}