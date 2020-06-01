package com.test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class testComboEditForm extends JFrame {

    public testComboEditForm() {
        super("testComboEditForm");
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

        JPanel greenPanel = new JPanel();
        greenPanel.setBounds(40,150,220,70);
        greenPanel.setLayout(new BorderLayout());
        greenPanel.setBackground(Color.GREEN);
        add(greenPanel);

        JButton bAdd = new JButton("ADD");
        JButton bRemove = new JButton("REMOVE");
        bAdd.setBounds(50,70,100,30);
        bRemove.setBounds(150,70,100,30);
        add(bAdd);
        add(bRemove);

        String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
        JComboBox petList = new JComboBox(petStrings);
        petList.setEditable(true);
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
        //Updates petLabel to show the currently selected petList item (press return to change)
        petList.addActionListener(e -> {
            String selectText = "You selected: ";
            String animal = (String) petList.getSelectedItem();
            if (animal != null && animal.trim().length() > 0) {
                selectText += String.format("%s", animal);
            }
            petLabel.setText(selectText);
        });
        //Adds current content of the combo box to the list of combo box options
        bAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add item "One" at the beginning of the list.
                petList.insertItemAt((String) petList.getSelectedItem(), petList.getItemCount());
            }
        });

        //Remove currently selected item from petList
        bRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (petList.getItemCount() >= 0 && petList.getSelectedIndex() >= 0) {
                    petList.removeItemAt(petList.getSelectedIndex());
                }
            }
        });
    }



    public static void main(final String[] args) {
        new testComboEditForm();
    }
}