package moneycalculator;

import view.*;
// import control.MCController;
import model.*;
import persistence.*;
import java.util.List;

public class MoneyCalculator {

    public static void main(String[] args) {
        CurrencyLoader currencyLoaderFromFile = new CurrencyLoader("currencies.txt");
        List<Currency> currencies = currencyLoaderFromFile.load();
        //ExchangeRateLoader exchangeRateLoader = new ExchangeRateLoader();
        
        // vista
        new MoneyCalculatorFrame("MoneyCalculator");

        //DisplaySwing displaySwing = new DisplaySwing(new Money(0.0, currencies.get(0)));
        //DialogSwing dialogSwing = new DialogSwing();
        
        // control
        //new MCController(dialogSwing, displaySwing, exchangeRateLoader);
        
        // 
        //new MoneyCalculatorGUI(dialogSwing, "Dialog Money Calculator...");
        //new MoneyCalculatorGUI(displaySwing, "Display Money Calculator...");
    }
}