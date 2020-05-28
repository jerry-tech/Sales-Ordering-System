/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderinginvoicingsystem;


//Import package
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class LogIn extends JFrame {

    JPanel panel;
    JLabel user_label, password_label, message;
    JTextField userName_text;
    JPasswordField password_text;
    JButton Login, cancel;

    LogIn() {
        //UserName Label
        user_label = new JLabel();
        user_label.setText("User name : ");
        userName_text = new JTextField();

        // Password Label
        password_label = new JLabel();
        password_label.setText("Password : ");
        password_text = new JPasswordField();

        // Login
        Login = new JButton("LOGIN");

        panel = new JPanel(new GridLayout(3, 1));
        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);

        message = new JLabel();
        panel.add(message);
        panel.add(Login);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(panel, BorderLayout.CENTER);
        setTitle("Numero Uno Interiors");
        setSize(450, 350);
        setVisible(true);
        setLocation(700, 300);
        setResizable(false);

        Login.addActionListener((ActionEvent ae) -> {
            validateLogin();
        });

    }

    public void validateLogin() {

        String userName = userName_text.getText();
        String password = password_text.getText();

        if (userName.trim().equals("Admin") && password.trim().equals("12345")) {
            message.setText(" Hello " + userName + "");
            SalesOrderCreation s = new SalesOrderCreation();
            s.Creation();
            s.readFile();
            s.addComponent();
            s.click();
        } else {
            message.setText(" Invalid user...");
        }

    }

    public static void main(String[] args) {
        // new LogIn();
        new LogIn();
    }

}
