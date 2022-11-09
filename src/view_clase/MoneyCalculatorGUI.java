package view_clase;

import java.awt.event.*;
import javax.swing.*;

public class MoneyCalculatorGUI extends JFrame {
    
    public MoneyCalculatorGUI(JPanel jpanel, String title) {
        super(title);
       
        getContentPane().add(jpanel);
        addWindowListener(new WindowCloseManager());
        pack();
        setVisible(true);
    }

    private static class WindowCloseManager extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}
