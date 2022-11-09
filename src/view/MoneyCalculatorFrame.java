package view;

import java.awt.*;
import javax.swing.*;
import view.interfaces.Observer;

public class MoneyCalculatorFrame extends JFrame implements Observer {
    
    JComboBox comboBoxCurrencyFrom = new JComboBox();
    JComboBox comboBoxCurrencyTo = new JComboBox();
    
    JTextField textFieldCurrencyFrom = new JTextField("", 20);
    JTextField textFieldCurrencyTo = new JTextField("", 20);
    
    JButton buttonCalculate = new JButton("Calculate");
    
    public MoneyCalculatorFrame(String title) {
        super(title);
        setUpGUI();
    }

    private JPanel setLeftPanel() {
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(comboBoxCurrencyFrom);
        panel.setBorder(BorderFactory.createEmptyBorder(120,10,10,10));
        leftPanel.add(panel); 
        
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(textFieldCurrencyFrom);
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,90,10));
        leftPanel.add(panel); 
        leftPanel.setSize(new Dimension(250, 200));
        return leftPanel;
    }
    
    private JPanel setRightPanel() {
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(comboBoxCurrencyTo);
        panel.setBorder(BorderFactory.createEmptyBorder(120,10,10,10));
        rightPanel.add(panel); 
        
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(textFieldCurrencyTo);
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,90,10));
        rightPanel.add(panel); 
        rightPanel.setSize(new Dimension(250, 200));
        return rightPanel;
    }
    
    private void setUpGUI() {
        /*
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        
        mainPanel.add(setLeftPanel());
        mainPanel.add(setRightPanel());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        */
        getContentPane().add(setLeftPanel(), BorderLayout.WEST);    
        getContentPane().add(setRightPanel(), BorderLayout.EAST);
        
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.setBorder(BorderFactory.createEmptyBorder(10,400,10,10));
        getContentPane().add(panel.add(buttonCalculate), BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 400));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    
        refresh();
    }

    @Override
    public void refresh() {
        
    }
}