package moneycalculator.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moneycalculator.model.Money;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Currency;
import moneycalculator.persistence.exchangerate.ExchangeRateLoader;
import moneycalculator.view.MCView;

public class MCController {
    
    MCView MCView;
    ExchangeRateLoader exchangeRateLoader;
    
    public MCController(ExchangeRateLoader exchangeRateLoader, MCView view) {
        this.exchangeRateLoader = exchangeRateLoader;
        this.MCView = view;
        this.MCView.addConvertListener(new ConvertListener());
    }

    private class ConvertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Money moneyFrom = MCView.getMoneyFrom();
            Currency currencyTo = MCView.getCurrencyTo();
            
            if (moneyFrom == null) return;
            
            ExchangeRate exchangeRate = exchangeRateLoader.load(moneyFrom.getCurrency(), currencyTo);
            MCView.refreshMoney(new Money(exchangeRate.convert(moneyFrom.getAmount()), currencyTo));
        }
    }
}