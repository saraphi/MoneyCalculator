package moneycalculator.view.ui;

import moneycalculator.view.ui.MCView;
import moneycalculator.model.Money;
import moneycalculator.model.Currency;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;


public class MCViewFrame extends JFrame implements MCView {
    
    private final JComboBox<Currency> currencyFromComboBox = new JComboBox<>();
    private final JComboBox<Currency> currencyToComboBox = new JComboBox<>();
    private final JTextField inputTextField = new JTextField();
    private final JTextField outputTextField = new JTextField();
    private final JButton convertButton = new JButton("Convert");
    private final JLabel fromLabel = new JLabel("From:");
    private final JLabel toLabel = new JLabel("To:");
    private final JLabel inputLabel = new JLabel("Enter amount to convert:");
    private final JLabel outputLabel = new JLabel("Total:");
    
    private final List<Currency> currencies;
    
    public MCViewFrame(String title, List<Currency> currencies) {
        super(title);
        outputTextField.setEditable(false);
        this.currencies = currencies;
        setUpGUI();
        setUpInfo();
    }

    @Override
    public void refreshMoney(Money money) {
        outputTextField.setText(String.valueOf(money.getAmount()) + " " + money.getCurrency().getSymbol());
    }

    @Override
    public Money getMoneyFrom() {
        if (inputTextField.getText().isEmpty()) return null;
        return new Money(Double.parseDouble(inputTextField.getText()), (Currency) currencyFromComboBox.getSelectedItem());
    }

    @Override
    public Currency getCurrencyTo() {
        return (Currency) currencyToComboBox.getSelectedItem();
    }
    
    @Override
    public void addConvertListener(ActionListener listener) {
        convertButton.addActionListener(listener);
    }
    
    private void setUpInfo() {
        for (Currency currency: currencies) {
            currencyFromComboBox.addItem(currency);
            currencyToComboBox.addItem(currency);
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