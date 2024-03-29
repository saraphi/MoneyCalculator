package moneycalculator.view.ui;

import java.awt.event.ActionListener;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;

public interface MCView {
    
    void refreshMoney(Money m);
    Money getMoneyFrom();
    Currency getCurrencyTo();
    void addConvertListener(ActionListener listener);
}