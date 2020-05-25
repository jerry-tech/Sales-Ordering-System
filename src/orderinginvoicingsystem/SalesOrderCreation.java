/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderinginvoicingsystem;

/**
 *
 * @author OLUWASEGUN JOSHUA
 */
//Import package
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javafx.geometry.Orientation;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SalesOrderCreation extends JFrame {

    JPanel frame;
    JButton Reload;
    JLabel Sales_Order_Creation, Sales_Id, Client_Name, Client_Address, Client_Phone, Order_Details, ItemId, ItemName, ItemDescription, Rate, Quantity, Price, Total;
    JTextField SalesId_text, ClientName_text, ClientPhone_text;
    JTextArea ClientAddress_text, ItemDescription_text, Rate_text, Price_text, Total_text;
    JSeparator Br, BrU, BrU2, BrD, Br0, Br1, Br2, Br3, Br4, Br5, Br6, BrE, BrD2;
    //JTable Table;
    JComboBox Combo, Combo1, Combo2;
    JButton Add_Item, Save_Order;
    JInternalFrame orderFrame;
    JTable table;
    DefaultTableModel model;
    JScrollPane scrollpane;
    int countClick = 0;

    public void Creation() {

        frame = new JPanel();
        //Sales Order Creation
        Sales_Order_Creation = new JLabel();
        Sales_Order_Creation.setBounds(500, 10, 250, 10);
        Sales_Order_Creation.setText("Sales Order Creation");

        //Sales Id
        Sales_Id = new JLabel();
        Sales_Id.setBounds(15, 70, 350, 30);
        Sales_Id.setText("Sales Id : ");

        //generating random nummber for the salesid column-----------------------------------
        Random rnd = new Random();
        int SalesID = rnd.nextInt(100);
        StringBuilder sb = new StringBuilder();
        sb.append(SalesID);

        SalesId_text = new JTextField();
        SalesId_text.setBounds(150, 70, 50, 35);
        //Disabling the text field 
        SalesId_text.setEnabled(false);
        SalesId_text.setForeground(new java.awt.Color(0, 0, 0));
        SalesId_text.setText(sb.toString());
        //--------------------------------------------------------------------------------------

        //Client Name
        Client_Name = new JLabel();
        Client_Name.setBounds(15, 120, 350, 30);
        Client_Name.setText("Client Name : ");
        ClientName_text = new JTextField();
        ClientName_text.setBounds(150, 120, 350, 35);

        //Client Address
        Client_Address = new JLabel();
        Client_Address.setBounds(15, 170, 350, 30);
        Client_Address.setText("Client Address : ");
        ClientAddress_text = new JTextArea();
        ClientAddress_text.setBounds(150, 170, 350, 100);
        ClientAddress_text.setLineWrap(true);

        //Client Phone
        Client_Phone = new JLabel();
        Client_Phone.setBounds(620, 70, 350, 30);
        Client_Phone.setText("Client Phone Number : ");
        ClientPhone_text = new JTextField();
        ClientPhone_text.setBounds(780, 70, 350, 35);
        /*Logic to read item id and itemname from text file */
        try {

            String reader = "C:\\Users\\HP\\Documents\\NetBeansProjects\\OrderingInvoicingSystem\\src\\orderinginvoicingsystem\\Item.txt";//change part appropriately
            File file = new File(reader);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String firstLine = br.readLine().trim();
            String[] columnName = firstLine.split(",");
            Combo = new JComboBox();
            Combo.addItem("Select");
            for (String itemId : columnName) {
                Combo.addItem(itemId);
            }
            Combo.setBounds(60, 400, 130, 50);

            Object[] tableLines = br.lines().toArray();
            Combo1 = new JComboBox();
            Combo1.addItem("Select");
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split("/");

                for (String itemName : dataRow) {
                    Combo1.addItem(itemName);
                }
                Combo1.setBounds(220, 400, 145, 50);
            }

        } catch (IOException e) {
            System.out.println("Cannot find specified file");
        }
//------------------------------------------------------------------------              
        // combobox

        Combo2 = new JComboBox();
        Combo2.addItem("Select");
        Combo2.addItem("20.0");
        Combo2.addItem("40.0");
        Combo2.addItem("60.0");
        Combo2.setBounds(820, 400, 145, 50);

        //Create a New Separator
        Br = new JSeparator();
        Br.setBounds(50, 300, 1210, 50);

        //Sales Order Creation
        Order_Details = new JLabel();
        Order_Details.setBounds(600, 300, 250, 50);
        Order_Details.setFont(new Font("Serif", Font.BOLD, 20));
        Order_Details.setText("Order Details");

        //Create a New Separator
        BrU = new JSeparator();
        BrU.setBounds(50, 350, 1090, 80);

        BrU2 = new JSeparator();
        BrU2.setBounds(50, 380, 1090, 80);

        BrD = new JSeparator();
        BrD.setBounds(50, 570, 1090, 80);

        BrD2 = new JSeparator();
        BrD2.setBounds(50, 513, 1090, 80);

        BrE = new JSeparator();
        BrE.setBounds(1140, 350, 10, 220);
        BrE.setOrientation(SwingConstants.VERTICAL);

        Br0 = new JSeparator();
        Br0.setBounds(50, 350, 10, 220);
        Br0.setOrientation(SwingConstants.VERTICAL);

        ItemId = new JLabel("ItemId");
        ItemId.setBounds(60, 358, 250, 20);

        Br1 = new JSeparator();
        Br1.setBounds(190, 350, 10, 165);
        Br1.setOrientation(SwingConstants.VERTICAL);

        ItemName = new JLabel("ItemName");
        ItemName.setBounds(200, 358, 250, 20);

        Br2 = new JSeparator();
        Br2.setBounds(390, 350, 10, 165);
        Br2.setOrientation(SwingConstants.VERTICAL);

        ItemDescription = new JLabel("ItemDescription");
        ItemDescription.setBounds(400, 358, 250, 20);

        ItemDescription_text = new JTextArea();
        ItemDescription_text.setBounds(392, 392, 197, 118);

        Br3 = new JSeparator();
        Br3.setBounds(590, 350, 10, 165);
        Br3.setOrientation(SwingConstants.VERTICAL);

        Rate = new JLabel("Rate");
        Rate.setBounds(600, 358, 250, 20);
        Rate_text = new JTextArea();
        Rate_text.setBounds(592, 392, 197, 118);

        Br4 = new JSeparator();
        Br4.setBounds(790, 350, 10, 165);
        Br4.setOrientation(SwingConstants.VERTICAL);

        Quantity = new JLabel("Quantity");
        Quantity.setBounds(800, 358, 250, 20);

        Br5 = new JSeparator();
        Br5.setBounds(990, 350, 10, 165);
        Br5.setOrientation(SwingConstants.VERTICAL);

        Price = new JLabel("Price");
        Price.setBounds(1000, 358, 250, 20);

        Price_text = new JTextArea();
        Price_text.setBounds(992, 392, 127, 118);

        Total = new JLabel("Total: ");
        Total.setBounds(60, 523, 280, 30);
        Total_text = new JTextArea();
        Total_text.setBounds(140, 517, 450, 45);
        Total_text.setEnabled(false);

        //Add Item
        Add_Item = new JButton("Add Item");
        Add_Item.setBounds(500, 610, 150, 50);

        //Save Order
        Save_Order = new JButton("Save Order");
        Save_Order.setBounds(500, 680, 150, 50);

    }

    public void action() {

        SalesLogic jj = new SalesLogic();

        if (!validateOrder()) {
            Rate_text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            Combo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            Combo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            Combo2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            Price_text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            Total_text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            ItemDescription_text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            JOptionPane.showMessageDialog(this, "Wrong Information Inserted Check For Correction Or Empty Fields.", "Error Message", JOptionPane.ERROR_MESSAGE);

        } else {
            String ratenum = Rate_text.getText();
            Double rate = Double.parseDouble(ratenum);

            String quantitynum = Combo2.getSelectedItem().toString();
            Double quantity = Double.parseDouble(quantitynum);

            String pricenum = Price_text.getText();
            Double price = Double.parseDouble(pricenum);

            Double Total = (rate * quantity * price) / 100;
            Total_text.setText(Total.toString());

            jj.addOrderDetails(frame, SalesId_text.getText(), Combo.getSelectedItem().toString(), Combo1.getSelectedItem().toString(), ItemDescription_text.getText(), rate, quantity, price, Total);
        }

    }

    public boolean totalAction() {
        boolean valid = false;
        SalesLogic salesLogic = new SalesLogic();

        if (validateTotalOrder()) {

            String ratenum = Rate_text.getText();
            Double rate = Double.parseDouble(ratenum);

            String quantitynum = Combo2.getSelectedItem().toString();
            Double quantity = Double.parseDouble(quantitynum);

            String pricenum = Price_text.getText();
            Double price = Double.parseDouble(pricenum);

            Double Total = (rate * quantity * price) / 100;
            Total_text.setText(Total.toString());

            //calling method from the sales logic class
            if (salesLogic.saveOrder(frame, SalesId_text.getText(), ClientName_text.getText(), ClientPhone_text.getText(), ClientAddress_text.getText(), Combo.getSelectedItem().toString(), Combo1.getSelectedItem().toString(), ItemDescription_text.getText(), rate, quantity, price, Total)) {
                valid = true;
            }

        } else {
            ClientPhone_text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            ClientAddress_text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            ClientName_text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            Rate_text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            Combo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            Combo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            Combo2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            Price_text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            Total_text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            ItemDescription_text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            JOptionPane.showMessageDialog(this, "Wrong Information Inserted Check For Correction Or Empty Fields.", "Error Message", JOptionPane.ERROR_MESSAGE);

        }

        return valid;
    }

    //method using for validating total sales order 
    public boolean validateTotalOrder() {

        if (SalesId_text.getText().isEmpty()) {
            return false;
        } else if (ClientName_text.getText().isEmpty()) {
            return false;
        } else if (ClientPhone_text.getText().isEmpty() || !ClientPhone_text.getText().matches("[+]{1}[1-4]{3}[0-9]{10}")) {
            return false;
        } else if (ClientAddress_text.getText().isEmpty()) {
            return false;
        } else if (Combo.getSelectedItem().toString().equalsIgnoreCase("select") || Combo.getSelectedItem().toString().equalsIgnoreCase("")) {
            return false;
        } else if (Combo1.getSelectedItem().toString().equalsIgnoreCase("select") || Combo1.getSelectedItem().toString().equalsIgnoreCase("select")) {
            return false;
        } else if (ItemDescription_text.getText().isEmpty() || ItemDescription_text.getText().trim().length() < 5) {
            return false;
        } else if (Rate_text.getText().isEmpty()) {
            return false;
        } else if (Combo2.getSelectedItem().toString().equalsIgnoreCase("select") || Combo.getSelectedItem().toString().equalsIgnoreCase("")) {
            return false;
        } else if (Price_text.getText().isEmpty()) {
            return false;
        }

        return true;

    }

    //method using for validating items addition
    public boolean validateOrder() {

        boolean valid = true;
        if (Combo.getSelectedItem().toString().equalsIgnoreCase("select") || Combo.getSelectedItem().toString().equalsIgnoreCase("")) {
            valid = false;
        } else if (Combo1.getSelectedItem().toString().equalsIgnoreCase("select") || Combo1.getSelectedItem().toString().equalsIgnoreCase("select")) {
            valid = false;
        } else if (ItemDescription_text.getText().isEmpty() || ItemDescription_text.getText().trim().length() < 5) {
            valid = false;
        } else if (Rate_text.getText().isEmpty()) {
            valid = false;
        } else if (Combo2.getSelectedItem().toString().equalsIgnoreCase("select") || Combo.getSelectedItem().toString().equalsIgnoreCase("")) {
            valid = false;
        } else if (Price_text.getText().isEmpty()) {
            valid = false;
        }

        return valid;
    }

    public void readFile() {
        
        //creating jinternal frame for showing records
        orderFrame = new JInternalFrame("Records Of Orders", true, false, true, false);
        orderFrame.setBounds(55, 501, 1300, 120);
        orderFrame.setLocation(10, 200);
        orderFrame.setVisible(true);
        orderFrame.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        try {

            String reader = "C:\\Users\\HP\\Documents\\NetBeansProjects\\OrderingInvoicingSystem\\src\\orderinginvoicingsystem\\Order.txt";//change part appropriately
            File file = new File(reader);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String firstLine = br.readLine().trim();
            String[] columnName = firstLine.split(",");

            //creating jtable
            table = new JTable();
            //setting  table headers
            model = (DefaultTableModel) table.getModel();
            model.setColumnIdentifiers(columnName);

            Object[] tableLines = br.lines().toArray();

            //looping data from txt file using objects
            for (Object tableLine : tableLines) {
                String line = tableLine.toString().trim();
                String[] dataRow = line.split(",");
                model.addRow(dataRow);
            }

            //adding table to scrollpane
            scrollpane = new JScrollPane(table);
            scrollpane.setBounds(10, 0, 150, 50);
            
        } catch (IOException e) {
            System.out.println("Unable to read file");
        }

    }

    public void addComponent() {

        orderFrame.setLayout(new BorderLayout());
        orderFrame.add(scrollpane);
        // Adding the listeners to components..
        frame.add(orderFrame);

        frame.add(Sales_Order_Creation);
        frame.add(Sales_Id);
        frame.add(SalesId_text);
        frame.add(Client_Name);
        frame.add(ClientName_text);
        frame.add(Client_Address);
        frame.add(ClientAddress_text);
        frame.add(Client_Name);
        frame.add(ClientName_text);
        frame.add(Client_Phone);
        frame.add(ClientPhone_text);
        frame.add(Br);
        frame.add(Order_Details);
        frame.add(BrU);
        frame.add(Br0);
        frame.add(BrU2);
        frame.add(BrD);
        frame.add(Br1);
        frame.add(Br2);
        frame.add(Br3);
        frame.add(Br4);
        frame.add(Br5);
        frame.add(BrE);
        frame.add(BrD2);

        // add(Table);
        frame.add(ItemId);
        frame.add(ItemName);
        frame.add(ItemDescription);
        frame.add(Rate);
        frame.add(Quantity);
        frame.add(Price);
        frame.add(Add_Item);
        frame.add(Save_Order);
        frame.add(Combo);
        frame.add(Combo1);
        frame.add(Combo2);
        frame.add(ItemDescription_text);
        frame.add(Rate_text);
        frame.add(Price_text);
        frame.add(Total);
        frame.add(Total_text);
        frame.add(Add_Item);
        frame.add(Save_Order);

        frame.setLayout(null);

        setTitle("Numero Uno Interiors");
        setSize(1400, 1500);
        setVisible(true);
        setResizable(false);
//        setLocation(400, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(frame);
    }

    public void click() {

        //for adding items
        Add_Item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ea) {
                action();

            }

        });
//        used to add sales order and removing the button after successfully addition
        Save_Order.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ea) {
                if(countClick == 0){
                    if (totalAction() == true) {
                        Save_Order.setVisible(false);
                        countClick += 1;
                    } 
                }
        
            }

        });
        //adding key listeners for limit alphabetic text
        Rate_text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ea) {
                char caracter = ea.getKeyChar();
                if (((caracter > '0') && (caracter > '9'))
                        && (caracter != '\b')) {
                    ea.consume();
                }
            }
        });
        //adding key listeners for limit alphabetic text
        Price_text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ea) {
                char caracter = ea.getKeyChar();
                if (((caracter > '0') && (caracter > '9'))
                        && (caracter != '\b')) {
                    ea.consume();
                }
            }
        });
        //adding key listeners for limit alphabetic text
        ClientPhone_text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ea) {
                char caracter = ea.getKeyChar();
                if (((caracter > '0') && (caracter > '9'))
                        && (caracter != '\b')) {
                    ea.consume();
                }
            }
        });
    }

    public static void main(String... args) {
        SalesOrderCreation s = new SalesOrderCreation();
        s.Creation();
        s.readFile();
        s.addComponent();

        s.click();

    }

}
