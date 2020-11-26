package com.dibraga;

import com.dibraga.delivery.DeliveryOptions;
import com.dibraga.order.Order;
import com.dibraga.payment.Payments;
import com.dibraga.sheets.Drinks;
import com.dibraga.utils.ComboBoxOption;
import com.dibraga.sheets.Dishes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
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
    private JComboBox deliveryComboBox;
    private JLabel deliveryLabel;
    private JTextArea observationsTextArea;
    private JLabel observationsLabel;
    private JComboBox drinksComboBox;
    private JLabel drinksLabel;
    private JList drinksList;

    private Vector selectedSideDishes = new Vector<>();
    private Vector selectedFinalDishes = new Vector<>();
    private Vector selectedDrinks = new Vector<>();
    private ComboBoxOption selectedDish;
    private float Total = 0;

    public OrderForm(JTable ordersTable){

        Dishes sheetDishes = new Dishes();
        Drinks sheetDrinks = new Drinks();

        Payments paymentMethods = new Payments();
        DeliveryOptions deliveryOptions = new DeliveryOptions();

        dishesComboBox.addItem(null);
        for(int i=0; i<sheetDishes.getDishes().size(); i++) {
            dishesComboBox.addItem(sheetDishes.getDishes().get(i));
        }

        drinksComboBox.addItem(null);
        for(int i=0; i<sheetDrinks.getDrinks().size(); i++) {
            drinksComboBox.addItem(sheetDrinks.getDrinks().get(i));
        }

        paymentComboBox.addItem(null);
        for(int i=0; i<paymentMethods.getPaymentMethods().size(); i++) {
            paymentComboBox.addItem(paymentMethods.getPaymentMethods().get(i));
        }

        deliveryComboBox.addItem(null);
        for(int i=0; i<deliveryOptions.getDeliveryOptions().size(); i++) {
            deliveryComboBox.addItem(deliveryOptions.getDeliveryOptions().get(i));
        }

        selectedDishesList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    Total = Total - ((ComboBoxOption)selectedFinalDishes.get(index)).getPrice();
                    totalTextField.setText(Float.toString(Total));
                    selectedFinalDishes.remove(index);
                    selectedDishesList.setListData(selectedFinalDishes);
                }
            }
        });

        drinksList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    Total = Total - ((ComboBoxOption)selectedDrinks.get(index)).getPrice();
                    totalTextField.setText(Float.toString(Total));
                    selectedDrinks.remove(index);
                    drinksList.setListData(selectedDrinks);
                }
            }
        });

        sideDishesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Integer selectedItemIndex = sideDishesComboBox.getSelectedIndex() - 1;

                if(selectedItemIndex >= 0) {
                    ComboBoxOption selectedDish = sheetDishes.getSideDishes().get(selectedItemIndex);
                    selectedSideDishes.add(selectedDish);
                    sideDishesList.setListData(selectedSideDishes);
                }
            }
        });

        dishesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Integer selectedItemIndex = dishesComboBox.getSelectedIndex() - 1;
                if(selectedItemIndex>=0) {
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
            }
        });

        drinksComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Integer selectedItemIndex = drinksComboBox.getSelectedIndex() - 1;
                if(selectedItemIndex>=0){
                    ComboBoxOption selectedDrink = sheetDrinks.getDrinks().get(selectedItemIndex);
                    selectedDrinks.add(selectedDrink);
                    drinksList.setListData(selectedDrinks);
                    Total += selectedDrink.getPrice();
                    totalTextField.setText(Float.toString(Total));
                }
            }
        });

        AddDish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Float finalPrice = selectedDish.getPrice();
                for(int i=0; i<selectedSideDishes.size(); i++) {
                    finalPrice += ((ComboBoxOption) selectedSideDishes.get(i)).getPrice();
                }
                Total += finalPrice;
                totalTextField.setText(Float.toString(Total));

                String finalDishString = selectedDish.toString()+ " + " + selectedSideDishes.toString();
                ComboBoxOption finalDish = new ComboBoxOption(finalDishString, finalDishString, finalPrice);

                selectedFinalDishes.add(finalDish);
                selectedDishesList.setListData(selectedFinalDishes);

                selectedSideDishes.removeAllElements();
                sideDishesList.setListData(selectedSideDishes);
            }
        });

        submitOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                List<String> dishes = new ArrayList<String>();
                List<String> drinks = new ArrayList<String>();
                String payment = paymentComboBox.getSelectedItem().toString();
                String delivery = deliveryComboBox.getSelectedItem().toString();
                String observations = observationsTextArea.getText();

                for(int i = 0; i< selectedDishesList.getModel().getSize();i++) {
                    dishes.add(((ComboBoxOption)selectedDishesList.getModel().getElementAt(i)).getValue());
                }
                for(int i = 0; i< drinksList.getModel().getSize();i++) {
                    drinks.add(((ComboBoxOption)drinksList.getModel().getElementAt(i)).getValue());
                }

//                Order order = new Order(dishes, drinks, Total, payment, delivery, observations);
                ((DefaultTableModel)ordersTable.getModel()).addRow(new Object[]{dishes, drinks,payment,delivery,observations,Total});

                OrderForm.this.setVisible(false);
            }
        });

        setTitle("Novo Pedido");
        getContentPane().add(newOrderPanel);
        newOrderPanel.setPreferredSize(new Dimension(560, 800));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}