package view_clase;

import javax.swing.*;
import model.Currency;
import model.Money;
import view_clase.interfaces.Dialog;

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
