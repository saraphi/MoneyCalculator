package view.interfaces;

import model.Currency;
import model.Money;

public interface MCView extends View {
    
    void setMoneyTo(Money m);
    Money getMoneyFrom();
    Currency getCurrencyTo();
}