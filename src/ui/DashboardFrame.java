package ui;

import javax.swing.*;
import java.awt.*;

import ui.AddProductFrame;
import ui.ViewProductsFrame;
import ui.ReportsFrame;

public class DashboardFrame extends JFrame {

        public DashboardFrame() {

                setTitle("Smart Inventory Management System - Dashboard");

                ImageIcon icon = new ImageIcon(
                                "assets/icon.png");

                setIconImage(icon.getImage());

                setSize(500, 400);

                setLocationRelativeTo(null);

                setDefaultCloseOperation(
                                JFrame.EXIT_ON_CLOSE);

                setLayout(
                                new GridLayout(6, 1, 10, 10));

                JLabel welcomeLabel = new JLabel(
                                "SMART INVENTORY MANAGEMENT SYSTEM",
                                JLabel.CENTER);

                welcomeLabel.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                18));

                add(welcomeLabel);

                JButton addProductButton = new JButton("Add Product");

                addProductButton.addActionListener(e -> {
                        new AddProductFrame();
                });

                JButton viewProductsButton = new JButton("View Products");

                viewProductsButton.addActionListener(e -> {
                        new ViewProductsFrame();
                });

                JButton reportsButton = new JButton("Reports");

                reportsButton.addActionListener(e -> {
                        new ReportsFrame();
                });

                JButton exitButton = new JButton("Exit");

                add(addProductButton);

                add(viewProductsButton);

                add(reportsButton);

                add(exitButton);

                // Exit action
                exitButton.addActionListener(e -> {

                        System.exit(0);
                });

                setVisible(true);
        }
}