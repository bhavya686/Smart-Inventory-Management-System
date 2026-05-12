package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame
                implements ActionListener {

        private JTextField usernameField;
        private JPasswordField passwordField;
        private JButton loginButton;

        public LoginFrame() {

                setTitle(
                                "Smart Inventory Management System");

                ImageIcon icon = new ImageIcon(
                                "assets/icon.png");

                setIconImage(icon.getImage());

                setSize(400, 300);

                setLocationRelativeTo(null);

                setDefaultCloseOperation(
                                JFrame.EXIT_ON_CLOSE);

                setLayout(new GridLayout(4, 2, 10, 10));

                JLabel title = new JLabel(
                                "LOGIN SYSTEM");

                title.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                20));

                title.setHorizontalAlignment(
                                JLabel.CENTER);

                JLabel usernameLabel = new JLabel("Username:");

                JLabel passwordLabel = new JLabel("Password:");

                usernameField = new JTextField();

                passwordField = new JPasswordField();

                loginButton = new JButton("Login");

                loginButton.addActionListener(this);

                add(title);

                add(new JLabel(""));

                add(usernameLabel);

                add(usernameField);

                add(passwordLabel);

                add(passwordField);

                add(new JLabel(""));

                add(loginButton);

                setVisible(true);
        }

        @Override
        public void actionPerformed(
                        ActionEvent e) {

                String username = usernameField.getText();

                String password = String.valueOf(
                                passwordField.getPassword());

                // Hardcoded login
                if (username.equals("admin")
                                &&
                                password.equals("admin123")) {

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Login Successful");

                        dispose();

                        new DashboardFrame();

                }

                else {

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Invalid Username or Password");
                }
        }
}