package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

import model.*;
import control.*;
import view.interfaces.*;

public class SwingMCView extends JFrame implements MCView {
    
    private final JComboBox<Currency> currencyFromComboBox = new JComboBox<>();
    private final JComboBox<Currency> currencyToComboBox = new JComboBox<>();
    private final JTextField inputTextField = new JTextField();
    private final JTextField outputTextField = new JTextField();
    private final JButton convertButton = new JButton("Convert");
    private final JLabel fromLabel = new JLabel("From:");
    private final JLabel toLabel = new JLabel("To:");
    private final JLabel inputLabel = new JLabel("Enter amount to convert:");
    private final JLabel outputLabel = new JLabel("Total:");
    
    private final MCController controller;
    private final List<Currency> currencies;
    
    private Money moneyTo;
    private Money moneyFrom;
    private Currency currencyTo;
    
    public SwingMCView(String title, List<Currency> currencies, MCController controller) {
        super(title);
        outputTextField.setEditable(false);
        convertButton.addActionListener(new ButtonActionListener(this));
        this.currencies = currencies;
        this.controller = controller;
        setUpGUI();
        
        for (Currency currency: currencies) {
            currencyFromComboBox.addItem(currency);
            currencyToComboBox.addItem(currency);
        }
    }

    @Override
    public void render() {
        if (moneyTo != null) outputTextField.setText(String.valueOf(moneyTo.getAmount()) + " " + moneyTo.getCurrency().getSymbol());
    }

    @Override
    public void setMoneyTo(Money m) {
        moneyTo = m;
    }

    @Override
    public Money getMoneyFrom() {
        return moneyFrom;
    }

    @Override
    public Currency getCurrencyTo() {
        return currencyTo;
    }

    private class ButtonActionListener implements ActionListener {
        
        private MCView view;
        
        public ButtonActionListener(MCView v) {
            this.view = v;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (inputTextField.getText().isEmpty() || currencyToComboBox.getSelectedIndex() < 0 || currencyFromComboBox.getSelectedIndex() < 0) return;
            moneyFrom = new Money(Double.parseDouble(inputTextField.getText()), (Currency) currencyFromComboBox.getSelectedItem());
            currencyTo = (Currency) currencyToComboBox.getSelectedItem();
            controller.notifyChanges(view);
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