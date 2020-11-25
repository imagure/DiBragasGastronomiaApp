package com.dibraga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JPanel mainPanel;
    private JButton newOrderButton;
    private JTabbedPane mainTabbedPanel;
    private JPanel OrdersTab;
    private JPanel MenuTab;
    static JFrame mainFrame = new JFrame("DiBragas");

    public App() {
        mainPanel.setPreferredSize(new Dimension(1024, 768));

        newOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                OrderForm orderForm = new OrderForm();
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
