package com.test;
import javax.swing.*;
import java.awt.*;

class testComboForm extends JFrame {

    public testComboForm() {
        super("testComboForm");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        initComponents();

        setLayout(null); // sets absolute positioning of components
        setVisible(true);
    }

    private void initComponents() {
        JLabel nameLabel = new JLabel("Select an animal:");
        nameLabel.setBounds(20,20, 140,30);
        add(nameLabel);

        //JTextField nameTextField = new JTextField();
        //nameTextField.setBounds(140,20, 120,30);
        //add(nameTextField);

        JPanel greenPanel = new JPanel();
        greenPanel.setBounds(40,150,220,70);
        greenPanel.setLayout(new BorderLayout());
        greenPanel.setBackground(Color.GREEN);
        add(greenPanel);

        String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
        JComboBox petList = new JComboBox(petStrings);
        petList.setBounds(140,20, 120,30);
        petList.setSelectedIndex(4);
        //petList.addActionListener(this);
        add(petList);
        String pet;
        pet = (String) petList.getSelectedItem();

        JLabel petLabel = new JLabel("You selected: " + pet);
        petLabel.setBounds(50,20, 100,30);
        petLabel.setHorizontalAlignment(SwingConstants.CENTER);
        petLabel.setVerticalAlignment(SwingConstants.CENTER);

        Font font = new Font("Courier", Font.BOLD,12);
        petLabel.setFont(font);
        petLabel.setFont(petLabel.getFont().deriveFont(16f));

        greenPanel.add(petLabel);

        petList.addActionListener(e -> {
            String selectText = "You selected: ";
            String animal = (String) petList.getSelectedItem();
            if (animal != null && animal.trim().length() > 0) {
                selectText += String.format("%s", animal);
            }
            petLabel.setText(selectText);
        });

    }

    public static void main(final String[] args) {
        new testComboForm();
    }
}