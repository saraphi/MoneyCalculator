package moneycalculator.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moneycalculator.model.Money;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Currency;
import moneycalculator.view.persistence.exchangerate.ExchangeRateLoader;
import moneycalculator.view.ui.MCView;

public class MCController {
    
    private MCView MCView;
    private ExchangeRateLoader exchangeRateLoader;
    
    public MCController(ExchangeRateLoader exchangeRateLoader, MCView view) {
        this.exchangeRateLoader = exchangeRateLoader;
        this.MCView = view;
        this.MCView.addConvertListener(createConvertListener());
    }
    
    private ActionListener createConvertListener() {
        return (ActionEvent ae) -> {
            Money moneyFrom = MCView.getMoneyFrom();
            Currency currencyTo = MCView.getCurrencyTo();
            
            if (moneyFrom == null) return;
            
            ExchangeRate exchangeRate = exchangeRateLoader.load(moneyFrom.getCurrency(), currencyTo);
            MCView.refreshMoney(new Money(exchangeRate.convert(moneyFrom.getAmount()), currencyTo));
        };
    }
}