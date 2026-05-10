package ui;

import javax.swing.*;
import java.awt.*;

import ui.AddProductFrame;
import ui.ViewProductsFrame;

public class DashboardFrame extends JFrame {

        public DashboardFrame() {

                setTitle("Dashboard");

                setSize(500, 400);

                setLocationRelativeTo(null);

                setDefaultCloseOperation(
                                JFrame.EXIT_ON_CLOSE);

                setLayout(
                                new GridLayout(5, 1, 10, 10));

                JButton addProductButton = new JButton("Add Product");

                addProductButton.addActionListener(e -> {
                        new AddProductFrame();
                });

                JButton viewProductsButton = new JButton("View Products");

                viewProductsButton.addActionListener(e -> {
                        new ViewProductsFrame();
                });

                JButton reportsButton = new JButton("Reports");

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