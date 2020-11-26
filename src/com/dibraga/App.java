package com.dibraga;

import com.dibraga.order.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class App {
    private JPanel mainPanel;
    private JButton newOrderButton;
    private JTabbedPane mainTabbedPanel;
    private JPanel OrdersTab;
    private JPanel Summary;
    static JFrame mainFrame = new JFrame("DiBragas");

    private List<Order> orders = new ArrayList<Order>();

    public App() {
        mainPanel.setPreferredSize(new Dimension(1024, 768));

        newOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                OrderForm orderForm = new OrderForm(orders);
                orderForm.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        App.mainFrame.setContentPane( new App().mainPanel);
        App.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        App.mainFrame.pack();
        App.mainFrame.setVisible(true);
    }
}
