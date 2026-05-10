package ui;

import model.Clothing;
import model.Electronics;
import model.Grocery;
import model.Product;

import util.AppSession;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewProductsFrame extends JFrame {

    private JTable productTable;

    private DefaultTableModel tableModel;

    public ViewProductsFrame() {

        setTitle("View Products");

        setSize(900, 400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        String[] columns = {
                "ID",
                "Name",
                "Category",
                "Price",
                "Quantity",
                "Extra Info"
        };

        tableModel =
                new DefaultTableModel(
                        columns,
                        0
                );

        productTable =
                new JTable(tableModel);

        JScrollPane scrollPane =
                new JScrollPane(productTable);

        add(scrollPane, BorderLayout.CENTER);

        loadProductsIntoTable();

        setVisible(true);
    }

    // Load products into JTable
    private void loadProductsIntoTable() {

        tableModel.setRowCount(0);

        for(Product p :
                AppSession
                        .inventoryService
                        .getProducts()) {

            String extraInfo = "";

            if(p instanceof Electronics e) {

                extraInfo =
                        e.getWarrantyPeriod()
                                + " Months";
            }

            else if(p instanceof Grocery g) {

                extraInfo =
                        g.getExpiryDate();
            }

            else if(p instanceof Clothing c) {

                extraInfo =
                        c.getSize();
            }

            Object[] rowData = {

                    p.getId(),

                    p.getName(),

                    p.getCategory(),

                    p.getPrice(),

                    p.getQuantity(),

                    extraInfo
            };

            tableModel.addRow(rowData);
        }
    }
}