package view;

import java.awt.*;
import javax.swing.*;
import view.interfaces.Observer;

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
    
    public MoneyCalculatorFrame(String title) {
        super(title);
        setUpGUI();
    }

    @Override
    public void refresh() {
        
    }

    private void setUpGUI() {
        getContentPane().add(setMainPanel());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(450, 270));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    
        refresh();
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