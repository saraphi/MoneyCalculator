package moneycalculator;

import view.*;
import model.*;
import persistence.*;
import java.util.List;
import view.interfaces.Observer;

public class MoneyCalculator {

    public static void main(String[] args) {
        CurrencyLoader currencyLoaderFromFile = new CurrencyLoader("currencies.txt");
        List<Currency> currencies = currencyLoaderFromFile.load();
        
        Observer moneyCalculator = new MoneyCalculatorFrame("MoneyCalculator", currencies);
        
    }
}