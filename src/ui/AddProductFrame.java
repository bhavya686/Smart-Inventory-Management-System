package ui;

import model.Clothing;
import model.Electronics;
import model.Grocery;

import util.AppSession;

import javax.swing.*;
import java.awt.*;

public class AddProductFrame extends JFrame {

        private JTextField idField;
        private JTextField nameField;
        private JTextField priceField;
        private JTextField quantityField;
        private JTextField extraField;
        private JLabel extraLabel;

        private JComboBox<String> categoryBox;

        public AddProductFrame() {

                setTitle("Add Product");

                setSize(450, 450);

                setLocationRelativeTo(null);

                setLayout(new GridLayout(8, 2, 10, 10));

                JLabel idLabel = new JLabel("Product ID:");

                JLabel nameLabel = new JLabel("Product Name:");

                JLabel categoryLabel = new JLabel("Category:");

                JLabel priceLabel = new JLabel("Price:");

                JLabel quantityLabel = new JLabel("Quantity:");

                extraLabel = new JLabel("Warranty Months:");

                idField = new JTextField();

                nameField = new JTextField();

                priceField = new JTextField();

                quantityField = new JTextField();

                extraField = new JTextField();

                String[] categories = {
                                "Electronics",
                                "Grocery",
                                "Clothing"
                };

                categoryBox = new JComboBox<>(categories);

                categoryBox.addActionListener(e -> {

                        String selectedCategory = categoryBox
                                        .getSelectedItem()
                                        .toString();

                        switch (selectedCategory) {

                                case "Electronics":

                                        extraLabel.setText(
                                                        "Warranty Months:");

                                        break;

                                case "Grocery":

                                        extraLabel.setText(
                                                        "Expiry Date:");

                                        break;

                                case "Clothing":

                                        extraLabel.setText(
                                                        "Size:");

                                        break;
                        }
                });

                JButton addButton = new JButton("Add Product");

                add(idLabel);
                add(idField);

                add(nameLabel);
                add(nameField);

                add(categoryLabel);
                add(categoryBox);

                add(priceLabel);
                add(priceField);

                add(quantityLabel);
                add(quantityField);

                add(extraLabel);
                add(extraField);

                add(new JLabel(""));
                add(addButton);

                addButton.addActionListener(e -> {

                        try {

                                int id = Integer.parseInt(
                                                idField.getText());

                                String name = nameField.getText();

                                String category = categoryBox
                                                .getSelectedItem()
                                                .toString();

                                double price = Double.parseDouble(
                                                priceField.getText());

                                int quantity = Integer.parseInt(
                                                quantityField.getText());

                                // Value Validation
                                if (price <= 0 || quantity < 0) {

                                        JOptionPane.showMessageDialog(
                                                        this,
                                                        "Invalid price or quantity.");

                                        return;
                                }

                                String extra = extraField.getText();

                                // Empty Field Validation
                                if (name.isEmpty()
                                                ||
                                                extra.isEmpty()) {

                                        JOptionPane.showMessageDialog(
                                                        this,
                                                        "Please fill all fields.");

                                        return;
                                }

                                switch (category) {

                                        case "Electronics":

                                                Electronics eProduct = new Electronics(
                                                                id,
                                                                name,
                                                                category,
                                                                price,
                                                                quantity,
                                                                Integer.parseInt(extra));

                                                AppSession.inventoryService
                                                                .addProduct(eProduct);

                                                break;

                                        case "Grocery":

                                                Grocery gProduct = new Grocery(
                                                                id,
                                                                name,
                                                                category,
                                                                price,
                                                                quantity,
                                                                extra);

                                                AppSession.inventoryService
                                                                .addProduct(gProduct);

                                                break;

                                        case "Clothing":

                                                Clothing cProduct = new Clothing(
                                                                id,
                                                                name,
                                                                category,
                                                                price,
                                                                quantity,
                                                                extra);

                                                AppSession.inventoryService
                                                                .addProduct(cProduct);

                                                break;
                                }

                                JOptionPane.showMessageDialog(
                                                this,
                                                "Product Added Successfully");

                                // Clear Fields
                                idField.setText("");

                                nameField.setText("");

                                priceField.setText("");

                                quantityField.setText("");

                                extraField.setText("");
                        }

                        catch (Exception ex) {

                                JOptionPane.showMessageDialog(
                                                this,
                                                ex.getMessage());
                        }
                });

                setVisible(true);
        }
}