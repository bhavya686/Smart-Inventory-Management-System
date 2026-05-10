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
                JFrame.DISPOSE_ON_CLOSE);

        String[] columns = {
                "ID",
                "Name",
                "Category",
                "Price",
                "Quantity",
                "Extra Info"
        };

        tableModel = new DefaultTableModel(
                columns,
                0);

        productTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(productTable);

        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel
        JPanel buttonPanel = new JPanel();

        JButton updateButton = new JButton("Update Quantity");

        JButton deleteButton = new JButton("Delete Product");

        buttonPanel.add(updateButton);

        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Update Quantity
        updateButton.addActionListener(e -> {

            int selectedRow = productTable.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Select a product first.");

                return;
            }

            int productId = (int) tableModel.getValueAt(
                    selectedRow,
                    0);

            String newQuantityInput = JOptionPane.showInputDialog(
                    this,
                    "Enter New Quantity:");

            try {

                int newQuantity = Integer.parseInt(
                        newQuantityInput);

                AppSession.inventoryService
                        .updateProductQuantity(
                                productId,
                                newQuantity);

                loadProductsIntoTable();

                JOptionPane.showMessageDialog(
                        this,
                        "Quantity Updated Successfully");
            }

            catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Quantity");
            }
        });

        // Delete Product
        deleteButton.addActionListener(e -> {

            int selectedRow = productTable.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Select a product first.");

                return;
            }

            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to delete?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                int productId = (int) tableModel.getValueAt(
                        selectedRow,
                        0);

                AppSession.inventoryService
                        .deleteProduct(productId);

                loadProductsIntoTable();

                JOptionPane.showMessageDialog(
                        this,
                        "Product Deleted Successfully");
            }
        });

        loadProductsIntoTable();

        setVisible(true);
    }

    // Load products into JTable
    private void loadProductsIntoTable() {

        tableModel.setRowCount(0);

        for (Product p : AppSession.inventoryService
                .getProducts()) {

            String extraInfo = "";

            if (p instanceof Electronics e) {

                extraInfo = e.getWarrantyPeriod()
                        + " Months";
            }

            else if (p instanceof Grocery g) {

                extraInfo = g.getExpiryDate();
            }

            else if (p instanceof Clothing c) {

                extraInfo = c.getSize();
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