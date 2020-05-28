/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderinginvoicingsystem;

//Import package
import java.awt.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.table.*;
import javax.swing.*;

public class ViewSalesOrder extends JFrame {

    JFrame Frame;
    JPanel Panel;
    JLabel View_Sales_Order, Sales_Id, Order_Date, Sales_Person, Client_Name, Client_Address, Client_Phone;
    JLabel ItemId, ItemName, ItemDescription, Rate, Quantity, Price, Total;
    JTextField SalesId_text, OrderDate_text, SalesPerson_text, ClientName_text, ClientPhone_text;
    JTextArea ClientAddress_text;
    JTable Table;
    TableColumn testcolumn;
    JComboBox<String> comboBox;
    SearchForSalesOrderDetails orderDetails;
    DefaultTableModel model;
    JScrollPane scrollpane;
    String id6 = null, id7 = null, id8 = null, id9 = null, id10 = null, id11 = null, id12 = null, id13 = null;
    String records;

    ViewSalesOrder() {

    }

    ViewSalesOrder(String salesid, String clientName, String Phone, String Address, String orderDate) throws IOException {

        View_Sales_Order = new JLabel("View Sales Order");
        View_Sales_Order.setBounds(450, 15, 300, 30);

        Sales_Id = new JLabel("SalesId: ");
        Sales_Id.setBounds(40, 55, 250, 25);
        SalesId_text = new JTextField(salesid);
        SalesId_text.setBounds(100, 55, 150, 35);
        SalesId_text.setEnabled(false);

        Order_Date = new JLabel("Order Date : ");
        Order_Date.setBounds(540, 55, 300, 25);
        OrderDate_text = new JTextField(orderDate);
        OrderDate_text.setEnabled(false);
        OrderDate_text.setBounds(620, 55, 150, 35);

        Sales_Person = new JLabel("Sales Person: ");
        Sales_Person.setBounds(40, 200, 240, 30);
        SalesPerson_text = new JTextField();
        SalesPerson_text.setBounds(130, 200, 200, 35);

        Client_Name = new JLabel("Client Name: ");
        Client_Name.setBounds(40, 250, 250, 30);
        ClientName_text = new JTextField(clientName);
        ClientName_text.setBounds(130, 250, 200, 35);
        ClientName_text.setEnabled(false);

        Client_Address = new JLabel("Client Address: ");
        Client_Address.setBounds(530, 250, 250, 30);
        ClientAddress_text = new JTextArea(Address);
        ClientAddress_text.setEnabled(false);
        ClientAddress_text.setBounds(620, 250, 260, 50);

        Client_Phone = new JLabel("Client Phone: ");
        Client_Phone.setBounds(40, 300, 250, 30);
        ClientPhone_text = new JTextField(Phone);
        ClientPhone_text.setBounds(130, 300, 220, 35);

        try {

            String sales = "C:\\Users\\HP\\Documents\\NetBeansProjects\\OrderingInvoicingSystem\\src\\orderinginvoicingsystem\\order.txt";
            File f = new File(sales);
            BufferedReader freader = new BufferedReader(new FileReader(f));
            String firstLine = freader.readLine().trim();
             //an array for the headers of the table
            String[] columnName = {"ItemId", "Item Name", "Item Description", "Quantity", "Rate", "Price","Total"};

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
            while ((s = freader.readLine()) != null) {

                 //used to split the text file values
                String[] dataRow = s.split(",");
                String id = dataRow[0];

                //checking if the id in the txt file equals the one from the text field
                if (id.equals(salesid)) {
                    id6 = dataRow[1];
                    id7 = dataRow[2];
                    id8 = dataRow[3];
                    id9 = dataRow[4];
                    id10 = dataRow[5];
                    id11 = dataRow[6];
                    id12 = dataRow[7];
                  
                    
                    records = id6 + "," + id7 + "," + id8 + "," + id9 + "," + id10 + "," + id11 + "," + id12 ;
                    System.out.println(records);
                    String[] itemstable = records.split(",");
                    
                    //adding value to table row
                    model.addRow(itemstable);
                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewSalesOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

        Table.setForeground(Color.white);
//        Table.setBounds(0, 350, 900, 200);

    //  adding table to scrollpane
        scrollpane = new JScrollPane(Table);
        scrollpane.setBounds(0, 350, 900, 200);

        Panel = new JPanel();
        Panel.setBounds(0, 0, 900, 900);
        Panel.setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Add all the Contents
        add(View_Sales_Order);
        add(Sales_Id);
        add(SalesId_text);
        add(Order_Date);
        add(OrderDate_text);
        add(Sales_Person);
        add(SalesPerson_text);
        add(Client_Name);
        add(ClientName_text);
        add(Client_Address);
        add(ClientAddress_text);
        add(Client_Phone);
        add(ClientPhone_text);

        add(scrollpane);

//        add(Panel, BorderLayout.CENTER);
        setTitle("Numero Uno Interiors");
        setSize(900, 900);
        setVisible(true);
        setResizable(false);
        setLocation(400, 100);

    }

}
