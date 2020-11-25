package com.dibraga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class OrderForm extends JFrame {

    private JButton submitOrderButton;
    private JPanel newOrderPanel;

    public OrderForm(){

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