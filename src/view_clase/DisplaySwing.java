package view_clase;

import java.awt.BorderLayout;
import view_clase.interfaces.Display;
import javax.swing.*;
import model.*;

public class DisplaySwing extends JPanel implements Display {

    private Money money;
    
    private JTextArea display;
    
    public DisplaySwing(Money money) {
        this.money = money;
        setupGUI();
    }

    @Override
    public void refreshMoney(Money money) {
        this.display.setText(money.getCurrency().getSymbol());
    }
    
    public final void setupGUI() {
        display = new JTextArea(10, 40);
        display.setEditable(false);
       
        setLayout(new BorderLayout());
        JScrollPane scrollDisplay = new JScrollPane(display);  
        add(scrollDisplay, BorderLayout.CENTER);
        
        refreshMoney(money);
    }
}