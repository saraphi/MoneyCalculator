package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import model.Currency;
import view.interfaces.Observer;
import control.*;
import model.Money;

public class MoneyCalculatorFrame extends JFrame implements Observer {
    
    JComboBox currencyFromComboBox = new JComboBox();
    JComboBox currencyToComboBox = new JComboBox();
    JTextField inputTextField = new JTextField();
    JTextField outputTextField = new JTextField();
    JButton convertButton = new JButton("Convert");
    JLabel fromLabel = new JLabel("From:");
    JLabel toLabel = new JLabel("To:");
    JLabel inputLabel = new JLabel("Enter amount to convert:");
    JLabel outputLabel = new JLabel("Total:");
    
    List<Currency> currencies;
    
    public MoneyCalculatorFrame(String title, List<Currency> currencies) {
        super(title);
        outputTextField.setEditable(false);
        convertButton.addActionListener(new ButtonActionListener());
        
        this.currencies = currencies; 
        setUpGUI();
        
        for (Currency currency: currencies) {
            currencyFromComboBox.addItem(currency);
            currencyToComboBox.addItem(currency);
        }
    }

    @Override
    public void refresh() {
        
    }

    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (inputTextField.getText().isEmpty()) return;
            
            Currency currencyFrom = null;
            Currency currencyTo = null;
            
            for (Currency currency: currencies) {
                if (currencyFromComboBox.getSelectedItem().equals(currency.toString())) currencyFrom = currency;
                if (currencyToComboBox.getSelectedItem().equals(currency.toString())) currencyTo = currency;
            }
            
            MCController.convert(new Money(Double.parseDouble(inputTextField.getText()), currencyFrom), currencyTo);
        }
    }
    
    private void setUpGUI() {
        getContentPane().add(setMainPanel());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(450, 270));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    private JPanel setMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(setTopPanel());
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(setDataPanel(inputLabel, inputTextField));
        mainPanel.add(setDataPanel(outputLabel, outputTextField));
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(setButtonPanel());
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        
        return mainPanel;
    }
         
    private JPanel setTopPanel() {
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(setFixedPanel(fromLabel, currencyFromComboBox));
        topPanel.add(Box.createRigidArea(new Dimension(100, 0)));
        topPanel.add(setFixedPanel(toLabel, currencyToComboBox));
        return topPanel;
    }

    private JPanel setDataPanel(JLabel label, JTextField textField) {
        JPanel dataPanel = new JPanel(new FlowLayout());
        dataPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        dataPanel.add(setFixedPanel(label, textField));
        dataPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        return dataPanel;
    }
    
    private JPanel setButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(convertButton);
        return panel;
    }
    
    private JPanel setFixedPanel(JLabel label, JComponent component) {
        JPanel labelPanel = new JPanel(new BorderLayout());
        labelPanel.add(label, BorderLayout.CENTER);
        
        JPanel componentPanel = new JPanel(new BorderLayout());
        componentPanel.setPreferredSize(new Dimension(120, 20));
        componentPanel.add(component, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(labelPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(componentPanel);

        return panel;
    }
}