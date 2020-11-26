package com.dibraga;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App {
    private JPanel mainPanel;
    private JButton newOrderButton;
    private JTabbedPane mainTabbedPanel;
    private JPanel OrdersTab;
    private JPanel Summary;
    private JTable ordersTable;
    private JScrollPane ongoingOrdersTableScroll;
    private JTextField dailyTotalTextField;
    private JLabel dailyTotalLabel;
    private JLabel ongoingOrders;
    private JScrollPane completedOrdersTableScroll;
    private JTable completedOrdersTable;
    private JLabel completedOrdersLabel;
    static JFrame mainFrame = new JFrame("DiBragas");

    private Float dailyTotal;
    private String [] result = new String[6];
    private Integer popupSelectedRow;
    JPopupMenu ordersTablePopup = new JPopupMenu();
    JPopupMenu completedOrdersTablePopup = new JPopupMenu();

    public App() {
        mainPanel.setPreferredSize(new Dimension(1024, 768));

        String column_names[]= {"Pedido","Bebidas","Pagamento", "Entrega", "Observações", "Total"};
        DefaultTableModel ongoingOrdersTableModel = new DefaultTableModel(column_names, 0);
        ordersTable.setModel(ongoingOrdersTableModel);

        DefaultTableModel completedOrdersTableModel = new DefaultTableModel(column_names, 0);
        completedOrdersTable.setModel(completedOrdersTableModel);

        newOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                OrderForm orderForm = new OrderForm(ordersTable);
                orderForm.setVisible(true);
            }
        });

        JMenuItem completeOrderItem = new JMenuItem("Completar Pedido");
        completeOrderItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ((DefaultTableModel)completedOrdersTable.getModel()).addRow(new Object [] {result[0], result[1],
                                    result[2], result[3], result[4], result[5]});
                ((DefaultTableModel)ordersTable.getModel()).removeRow(popupSelectedRow);
            }
        });
        JMenuItem rollbackOrderItem = new JMenuItem("Voltar Pedido");
        rollbackOrderItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ((DefaultTableModel)ordersTable.getModel()).addRow(new Object [] {result[0], result[1],
                        result[2], result[3], result[4], result[5]});
                ((DefaultTableModel)completedOrdersTable.getModel()).removeRow(popupSelectedRow);
            }
        });
        JMenuItem removeOrderItem = new JMenuItem("Apagar");
        removeOrderItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ((DefaultTableModel)ordersTable.getModel()).removeRow(popupSelectedRow);
            }
        });
        JMenuItem removeCompletedOrderItem = new JMenuItem("Apagar");
        removeCompletedOrderItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ((DefaultTableModel)completedOrdersTable.getModel()).removeRow(popupSelectedRow);
            }
        });
        ordersTablePopup.add(completeOrderItem);
        ordersTablePopup.add(removeOrderItem);
        completedOrdersTablePopup.add(rollbackOrderItem);
        completedOrdersTablePopup.add(removeCompletedOrderItem);

        ordersTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                popupSelectedRow = table.rowAtPoint(point);
                if (mouseEvent.isPopupTrigger() && table.getSelectedRow() != -1) {
                    for (int i = 0; i < 6; i++) {
                        result[i] = (((DefaultTableModel)ordersTable.getModel()).getValueAt(popupSelectedRow,i).toString());
                    }
                    ordersTablePopup.show(mouseEvent.getComponent(), mouseEvent.getX(), mouseEvent.getY());
                }
            }
        });

        completedOrdersTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                popupSelectedRow = table.rowAtPoint(point);
                if (mouseEvent.isPopupTrigger() && table.getSelectedRow() != -1) {
                    for (int i = 0; i < 6; i++) {
                        result[i] = (((DefaultTableModel)completedOrdersTable.getModel()).getValueAt(popupSelectedRow,i).toString());
                    }
                    completedOrdersTablePopup.show(mouseEvent.getComponent(), mouseEvent.getX(), mouseEvent.getY());
                }
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
