package com.dibraga;

import com.dibraga.sheets.Dish;
import com.dibraga.sheets.Dishes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

class OrderForm extends JFrame {

    private JButton submitOrderButton;
    private JPanel newOrderPanel;
    private JComboBox dishesComboBox;
    private JList selectedDishesList;
    private JLabel ListLabel;
    private JLabel ComboBoxLabel;
    private JComboBox sideDishesComboBox;
    private JLabel sideDishesLabel;
    private Vector selectedDishes = new Vector<>();

    public OrderForm(){

        Dishes sheetDishes = new Dishes();

        for(int i=0; i<sheetDishes.dishes.size(); i++) {
            dishesComboBox.addItem(sheetDishes.dishes.get(i));
        }

        dishesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Integer selectedItemIndex = dishesComboBox.getSelectedIndex();
                Dish selectedDish = sheetDishes.dishes.get(selectedItemIndex);

                ArrayList sideDishes = (ArrayList) selectedDish.getSideDishes();
                System.out.println("Side dishes: " + sideDishes);

                if(sideDishes!=null) {
                    for(int i=0; i<sideDishes.size(); i++) {
                        sideDishesComboBox.addItem(sideDishes.get(i));
                    }
                } else {
                    selectedDishes.add(selectedDish);
                    selectedDishesList.setListData(selectedDishes);
                }
            }
        });

        submitOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                OrderForm.this.setVisible(false);
            }
        });
        setTitle("Novo Pedido");
        getContentPane().add(newOrderPanel);
        newOrderPanel.setPreferredSize(new Dimension(480, 650));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}