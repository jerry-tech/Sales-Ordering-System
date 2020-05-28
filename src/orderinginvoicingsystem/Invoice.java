/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderinginvoicingsystem;

//Import package
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;

public class Invoice extends JFrame {

    JFrame Frame;
    JPanel Panel, Panel2;
    JLabel Invoice, labelTot, Numero_uno_Interiors, A_67_Redmond_Road, firstFloor, Redline, Code;
    JLabel Sales_id, Order_Date, Billing_Address, Shipping_Address, Contact_Number, Total, Taxes, Grand_Total, Advance_Paid, Pending_Payment, Order_TermsAndConditions;
    JTextField SalesId_text, OrderDate_text, ContactNumber_text, fieldTax, labelField, fieldGrand;
    JTextArea ClientAddress_text, BillingAddress_text, ShippingAddress_text;
    JSeparator br1;
    DefaultTableModel model;
    JButton Print, printBtn;
    JTable Table;
    TableColumn testcolumn;
    JComboBox<String> comboBox;
    String id6 = null, id7 = null, id8 = null, id9 = null, id10 = null, id11 = null, id12 = null, id13 = null;

    Invoice(String salesid, String orderDate, String Phone) throws IOException {

        Invoice = new JLabel("INVOICE");
        Invoice.setBounds(440, 10, 300, 40);

        Numero_uno_Interiors = new JLabel("NUMERO UNO INTERIOR");
        Numero_uno_Interiors.setBounds(15, 80, 300, 45);

        A_67_Redmond_Road = new JLabel("A-67, Redmond Road");
        A_67_Redmond_Road.setBounds(15, 130, 190, 30);

        firstFloor = new JLabel("1st Floor, McKinsey Buildings");
        firstFloor.setBounds(15, 160, 250, 30);

        Redline = new JLabel("Redline Boulevard");
        Redline.setBounds(15, 190, 250, 30);

        Code = new JLabel("CA95064");
        Code.setBounds(15, 220, 250, 30);

        br1 = new JSeparator();
        br1.setBounds(0, 290, 900, 60);

        Sales_id = new JLabel("SalesId");
        Sales_id.setBounds(15, 310, 250, 30);
        SalesId_text = new JTextField(salesid);
        SalesId_text.setBounds(120, 310, 180, 30);
        SalesId_text.setEnabled(false);

        Order_Date = new JLabel("Order Date");
        Order_Date.setBounds(480, 310, 250, 30);
        OrderDate_text = new JTextField(orderDate);
        OrderDate_text.setBounds(600, 310, 200, 30);
        OrderDate_text.setEnabled(false);

        Billing_Address = new JLabel("Billing Address: ");
        Billing_Address.setBounds(15, 360, 200, 30);
        BillingAddress_text = new JTextArea();
        BillingAddress_text.setBounds(120, 350, 200, 80);

        Shipping_Address = new JLabel("Shipping Address: ");
        Shipping_Address.setBounds(480, 360, 200, 30);
        ShippingAddress_text = new JTextArea();
        ShippingAddress_text.setLineWrap(true);
        ShippingAddress_text.setBounds(600, 350, 200, 80);

        Contact_Number = new JLabel("Contact Number: ");
        Contact_Number.setBounds(15, 460, 200, 30);
        ContactNumber_text = new JTextField(Phone);
        ContactNumber_text.setBounds(120, 460, 150, 30);
        ContactNumber_text.setEnabled(false);

        try {

            //change accordingly path of text file
            String sales = "C:\\Users\\HP\\Documents\\NetBeansProjects\\OrderingInvoicingSystem\\src\\orderinginvoicingsystem\\Order.txt";
            File f = new File(sales);
            BufferedReader freader = new BufferedReader(new FileReader(f));
            String firstLine = freader.readLine().trim();
            
            //an array for the headers of the table
            String[] columnName = {"ItemId", "Item Name", "Item Description", "Quantity", "Rate", "Price", "Total"};

            //creating a JTable
            Table = new JTable();
            Font font = new Font("Verdana", Font.PLAIN, 12);
            Table.setFont(font);
            Table.setBackground(Color.black);

            //used to set the column headers
            model = (DefaultTableModel) Table.getModel();
            model.setColumnIdentifiers(columnName);

            String s;
            //looping the text file
            while (null != (s = freader.readLine())) {

                //used to split the text file values
                String[] dataRow = s.split(",");
                String id = dataRow[0];

                //checking if the id in the txt file equals the one from the text field
                if (id.equals(SalesId_text.getText())) {

                    id6 = dataRow[1];
                    id7 = dataRow[2];
                    id8 = dataRow[3];
                    id9 = dataRow[4];
                    id10 = dataRow[5];
                    id11 = dataRow[6];
                    id12 = dataRow[7];

                    String records = id6 + "," + id7 + "," + id8 + "," + id9 + "," + id10 + "," + id11 + "," + id12;
//                    System.out.println(records);
                    String[] itemstable = records.split(",");
                    //adding value to table row
                    model.addRow(itemstable);
                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewSalesOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

        //setting the table text to white
        Table.setForeground(Color.white);
        JScrollPane scrollpane = new JScrollPane(Table);
        //adding table to a JScrollpane
        scrollpane.setBounds(10, 500, 900, 100);
//------------------------------------------------------------------------------


        labelTot = new JLabel();
        labelTot.setText("Total :");
        labelTot.setBounds(10, 600, 200, 30);

        labelField = new JTextField();//can space as u want
        labelField.setBounds(90, 600, 200, 30);

        JLabel labelTax = new JLabel();
        labelTax.setText("Taxes :");
        labelTax.setBounds(10, 625, 200, 30);

        fieldTax = new JTextField();
        fieldTax.setBounds(90, 625, 200, 30);

        JLabel labelGrand = new JLabel();
        labelGrand.setText("Grand Total :");
        labelGrand.setBounds(10, 650, 200, 30);

        fieldGrand = new JTextField();
        fieldGrand.setBounds(90, 650, 200, 30);

        JLabel labelAd = new JLabel();
        labelAd.setText("Advance Paid :    Service Not Available");
        labelAd.setBounds(10, 675, 290, 30);

        JLabel labelPay = new JLabel();
        labelPay.setText("Pending Payment :   There cannot be Pending Payment");
        labelPay.setBounds(10, 700, 350, 30);

        printBtn = new JButton();
        printBtn.setText("Print");
        printBtn.setBounds(500, 700, 100, 30);

        Panel = new JPanel();
        Panel.setBounds(0, 0, 900, 1000);
        Panel.setLayout(null);

        Panel2 = new JPanel();
        Panel2.setBounds(15, 600, 700, 800);
        Panel2.setLocation(25, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel.add(Invoice);
        Panel.add(Numero_uno_Interiors);
        Panel.add(A_67_Redmond_Road);
        Panel.add(firstFloor);
        Panel.add(Redline);
        Panel.add(Code);
        Panel.add(br1);
        Panel.add(Sales_id);
        Panel.add(SalesId_text);
        Panel.add(Order_Date);
        Panel.add(OrderDate_text);
        Panel.add(Billing_Address);
        Panel.add(BillingAddress_text);
        Panel.add(Shipping_Address);
        Panel.add(ShippingAddress_text);
        Panel.add(Contact_Number);
        Panel.add(ContactNumber_text);
        Panel.add(labelTot);
        Panel.add(labelTax);
        Panel.add(printBtn);
        Panel.add(labelGrand);
        Panel.add(labelAd);
        Panel.add(labelPay);
        Panel.add(scrollpane);
        Panel.add(labelField);
        Panel.add(fieldTax);
        Panel.add(fieldGrand);

        Panel.add(printBtn);

        add(Panel, BorderLayout.CENTER);
        setTitle("Numero Uno Interiors");
        setSize(900, 900);
        setVisible(true);
        setLocation(500, 100);

        //action event  for printing file
        printBtn.addActionListener((ActionEvent l) -> {
            printFile();
        });

        //method used for adding columns in a JTable
        getSum();
    }

    //method used for printing file
    private void printFile() {
        PrintableDocument.printComponent(this);
    }

    //method used for adding column values in  JTable
    private void getSum() {
        double sum = 0;
        
        for (int i = 0; i < Table.getRowCount(); i++) {
            sum += Double.parseDouble(Table.getValueAt(i, 6).toString());
            
        }

        labelField.setText(Double.toString(sum));
        

        //adding a key event for calculation of grand total
        fieldTax.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                    double total = Double.parseDouble(labelField.getText());
                double tax = Double.parseDouble(fieldTax.getText());
                
                double taxPerTotal = total * (tax / 100);
                
                double summation = total + taxPerTotal;
                
                StringBuilder sb = new StringBuilder();
                fieldGrand.setText(sb.append(summation).toString());
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
    }


}
