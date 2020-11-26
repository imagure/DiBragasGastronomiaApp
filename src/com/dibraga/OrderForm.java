package com.dibraga;

import com.dibraga.payment.Payments;
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
    private JComboBox sideDishesComboBox;
    private JList sideDishesList;
    private JButton AddDish;
    private JTextField totalTextField;
    private JComboBox paymentComboBox;
    private JLabel ComboBoxLabel;
    private JLabel sideDishesLabel;
    private JLabel totalLabel;
    private JLabel paymentLabel;

    private Vector selectedSideDishes = new Vector<>();
    private Vector selectedFinalDishes = new Vector<>();
    private Dish selectedDish;
    private float Total = 0;

    public OrderForm(){

        Dishes sheetDishes = new Dishes();
        Payments paymentMethods = new Payments();

        dishesComboBox.addItem(null);
        for(int i=0; i<sheetDishes.getDishes().size(); i++) {
            dishesComboBox.addItem(sheetDishes.getDishes().get(i));
        }

        paymentComboBox.addItem(null);
        for(int i=0; i<paymentMethods.getPaymentMethods().size(); i++) {
            paymentComboBox.addItem(paymentMethods.getPaymentMethods().get(i));
        }

        sideDishesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Integer selectedItemIndex = sideDishesComboBox.getSelectedIndex() - 1;
                System.out.println("Selected Item index: " + selectedItemIndex);

                if(selectedItemIndex >= 0) {
                    Dish selectedDish = sheetDishes.getSideDishes().get(selectedItemIndex);
                    selectedSideDishes.add(selectedDish);
                    sideDishesList.setListData(selectedSideDishes);
                }
            }
        });

        dishesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Integer selectedItemIndex = dishesComboBox.getSelectedIndex() - 1;
                selectedDish = sheetDishes.getDishes().get(selectedItemIndex);
                ArrayList sideDishes = (ArrayList) selectedDish.getSideDishes();

                DefaultComboBoxModel comboBoxModel=(DefaultComboBoxModel) sideDishesComboBox.getModel();
                comboBoxModel.removeAllElements();

                DefaultListModel listModel=new DefaultListModel();
                listModel.clear();
                sideDishesList.setModel(listModel);
                selectedSideDishes.removeAllElements();

                if(sideDishes!=null) {
                    sideDishesComboBox.addItem(null);
                    for(int i=0; i<sideDishes.size(); i++) {
                        sideDishesComboBox.addItem(sideDishes.get(i));
                    }
                }
            }
        });

        AddDish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Float finalPrice = selectedDish.getPrice();
                for(int i=0; i<selectedSideDishes.size(); i++) {
                    finalPrice += ((Dish) selectedSideDishes.get(i)).getPrice();
                }
                Total += finalPrice;
                totalTextField.setText(Float.toString(Total));

                String finalDishString = selectedDish.toString()+ " + " + selectedSideDishes.toString();
                Dish finalDish = new Dish(finalDishString, finalDishString, finalPrice);

                selectedFinalDishes.add(finalDish);
                selectedDishesList.setListData(selectedFinalDishes);
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
        newOrderPanel.setPreferredSize(new Dimension(600, 800));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}