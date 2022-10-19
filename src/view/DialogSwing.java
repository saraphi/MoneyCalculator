package view;

import javax.swing.*;
import model.Currency;
import model.Money;
import view.interfaces.Dialog;

public class DialogSwing extends JPanel implements Dialog {

    @Override
    public Money getMoney() {
        return null;
    }

    @Override
    public Currency getCurrencyTo() {
        return null;
    }

}
