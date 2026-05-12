package ui;

import model.Product;
import service.ReportService;
import util.AppSession;

import javax.swing.*;
import java.awt.*;

public class ReportsFrame extends JFrame {

        private JTextArea reportArea;

        public ReportsFrame() {

                setTitle("Smart Inventory Management System - Inventory Reports");

                ImageIcon icon = new ImageIcon(
                                "assets/icon.png");

                setIconImage(icon.getImage());

                setSize(600, 500);

                setLocationRelativeTo(null);

                setDefaultCloseOperation(
                                JFrame.DISPOSE_ON_CLOSE);

                setLayout(new BorderLayout());

                reportArea = new JTextArea();

                reportArea.setEditable(false);

                reportArea.setFont(
                                new Font(
                                                "Monospaced",
                                                Font.PLAIN,
                                                14));

                JScrollPane scrollPane = new JScrollPane(reportArea);

                add(scrollPane, BorderLayout.CENTER);

                generateReports();

                setVisible(true);
        }

        // Generate Reports
        private void generateReports() {

                ReportService reports = new ReportService(
                                AppSession.inventoryService
                                                .getProducts());

                StringBuilder builder = new StringBuilder();

                builder.append(
                                "===== INVENTORY REPORT =====\n\n");

                // Total Value
                builder.append(
                                "TOTAL INVENTORY VALUE:\n");

                builder.append(
                                reports
                                                .calculateTotalInventoryValue());

                builder.append("\n\n");

                // Product Count
                builder.append(
                                "TOTAL PRODUCT COUNT:\n");

                builder.append(
                                reports
                                                .getTotalProductCount());

                builder.append("\n\n");

                // Low Stock
                builder.append(
                                "LOW STOCK PRODUCTS:\n");

                boolean found = false;

                for (Product p : AppSession.inventoryService
                                .getProducts()) {

                        if (p.getQuantity() < 10) {

                                builder.append(
                                                p.getName());

                                builder.append(
                                                " (Qty: ");

                                builder.append(
                                                p.getQuantity());

                                builder.append(")\n");

                                found = true;
                        }
                }

                if (!found) {

                        builder.append(
                                        "No low stock products.\n");
                }

                builder.append("\n");

                // Category Summary
                int electronics = 0;
                int grocery = 0;
                int clothing = 0;

                for (Product p : AppSession.inventoryService
                                .getProducts()) {

                        switch (p.getCategory()) {

                                case "Electronics":
                                        electronics++;
                                        break;

                                case "Grocery":
                                        grocery++;
                                        break;

                                case "Clothing":
                                        clothing++;
                                        break;
                        }
                }

                builder.append(
                                "CATEGORY SUMMARY:\n");

                builder.append(
                                "Electronics: "
                                                + electronics
                                                + "\n");

                builder.append(
                                "Grocery: "
                                                + grocery
                                                + "\n");

                builder.append(
                                "Clothing: "
                                                + clothing
                                                + "\n");

                reportArea.setText(
                                builder.toString());
        }
}