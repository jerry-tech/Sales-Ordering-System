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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;

public class SearchForSalesOrderDetails extends JFrame {

    JFrame Frame;
    JPanel Panel;
    JLabel Search_For_Sales_Order, Sales_Id, Result_For_Sales_Id;
    JTextField SalesId_text, Result_text, SalesId2_text;
    //JTextArea Result_text;
    JButton Search, Generate, View;
    JSeparator BrV1, BrV2, BrV3, BrV4, BrV5, BrH1, BrH2;
    String getSearchId = "";
    String salesId = "";
    String sales = "C:\\Users\\HP\\Documents\\NetBeansProjects\\OrderingInvoicingSystem\\src\\orderinginvoicingsystem\\Salesorder.txt";

    SearchForSalesOrderDetails() {

        // Search For Sales Order Details
        Search_For_Sales_Order = new JLabel("Search For Sales Order");
        Search_For_Sales_Order.setBounds(365, 30, 300, 50);

        // Sales ID
        Sales_Id = new JLabel("Sales Id: ");
        Sales_Id.setBounds(400, 100, 200, 35);

        // Sales Id Text Field
        SalesId_text = new JTextField();
        SalesId_text.setBounds(500, 100, 300, 45);

        // Search Button
        Search = new JButton("Search");
        Search.setBounds(565, 160, 150, 55);

        // Result For Sales Id
        Result_For_Sales_Id = new JLabel("Result For Sales Id: ");
        Result_For_Sales_Id.setBounds(300, 310, 250, 35);

        // Result Text Field
        Result_text = new JTextField();
        Result_text.setBounds(420, 310, 270, 30);

        // Creating Table with Separator
        BrH1 = new JSeparator();
        BrH1.setBounds(75, 350, 700, 10);

        BrV1 = new JSeparator();
        BrV1.setBounds(75, 349, 10, 60);
        BrV1.setOrientation(SwingConstants.VERTICAL);

        //BrV2 = new JSeparator();
        //BrV2.setBounds(250, 349, 10, 60);
        //BrV2.setOrientation(SwingConstants.VERTICAL);
        BrV3 = new JSeparator();
        BrV3.setBounds(370, 349, 10, 60);
        BrV3.setOrientation(SwingConstants.VERTICAL);

        BrV4 = new JSeparator();
        BrV4.setBounds(570, 349, 10, 60);
        BrV4.setOrientation(SwingConstants.VERTICAL);

        BrV5 = new JSeparator();
        BrV5.setBounds(775, 349, 10, 60);
        BrV5.setOrientation(SwingConstants.VERTICAL);

        BrH2 = new JSeparator();
        BrH2.setBounds(75, 409, 700, 10);

        SalesId2_text = new JTextField();
        SalesId2_text.setBounds(76, 352, 294, 57);

        View = new JButton("View");
        View.setBounds(415, 355, 110, 55);

        Generate = new JButton("Generate InVoice");
        Generate.setBounds(590, 355, 170, 55);
      
        Panel = new JPanel();
        Panel.setBounds(0, 0, 900, 500);
        Panel.setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(Search_For_Sales_Order);
        add(Sales_Id);
        add(SalesId_text);
        add(Search);
        add(Result_For_Sales_Id);
        add(Result_text);
        add(BrH1);
        add(BrV1);
        //add(BrV2);
        add(BrV3);
        add(BrV4);
        add(BrV5);
        add(BrH2);
        add(SalesId2_text);
        add(View);
        add(Generate);

        add(Panel, BorderLayout.CENTER);
        setTitle("Numero Uno Interiors");
        setSize(900, 500);
        setVisible(true);
        setResizable(false);
        setLocation(200, 200);

        //calling the salesLogic class
        SalesLogic logic = new SalesLogic();

        //search button
        Search.addActionListener((ActionEvent ae) -> {
            getSearchId = SalesId_text.getText();
            //checking if search(salesId) is null
            if (getSearchId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error in getting order details", "Empty Text Field", JOptionPane.ERROR_MESSAGE);
            } else if (!getSearchId.isEmpty()) {
                try {
//                    calling the readsingle File method from the logic class
                    boolean checkExist = logic.readsingleFile(getSearchId);
                    
                    if(checkExist){
                        //executes this if its value True
                        Result_text.setText(getSearchId);
                        SalesId2_text.setText(getSearchId);
                        JOptionPane.showMessageDialog(this, "Record Exists");
                    }else {
                        JOptionPane.showMessageDialog(this,"Sales Id not Found", "Error in getting salesId", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (IOException ex) {
                    
                    //setting the errors in loggers
                    Logger.getLogger(SearchForSalesOrderDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            //getting the result text
            Result_text.getText();
        });

        //mouse listener for view sales order 
        View.addActionListener((ActionEvent ae) -> {
            String word = Result_text.getText();
            try {
                //calling the countTimes parameterized method
                countTimes(word,"salesorder");
            } catch (IOException ex) {
                Logger.getLogger(SearchForSalesOrderDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //mouse listener for generate invoice
        Generate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ea) {
                String word = Result_text.getText();
                try {
                    countTimes(word,"invoice");
                } catch (IOException ex) {
                    Logger.getLogger(SearchForSalesOrderDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }
    
    //method used for putting data into the Viewsales order and invoice constructor of their classes
    public void countTimes(String word, String btnControl) throws FileNotFoundException, IOException {
        File f = new File(sales);
        
        //instanciating the bufferedReader class
        BufferedReader freader = new BufferedReader(new FileReader(f));
        String s;
        
        //checking if word is not equals to null
        if (word != null) {
            while ((s = freader.readLine()) != null) {

                //used to split the text file values
                String[] st = s.split(",");

                String salesid = st[0];

                //checking if the id in the txt file
                if (salesid.equalsIgnoreCase(word)) {

                    String clientName = st[1];
                    String Phone = st[2];
                    String Address = st[3];
                    String itemId = st[4];
                    String itemName = st[5];
                    String description = st[6];
                    String Rate = st[7];
                    String quantity = st[8];
                    String price = st[9];
                    String Total = st[10];
                    String orderDate = st[11];
                    
                    if (clientName != null && Phone != null && Address != null && itemId != null && itemName != null && description != null && Rate != null && quantity != null && price != null && Total != null && orderDate != null) {
                        if (btnControl.equalsIgnoreCase("salesOrder")) {
                            //calling the ViewSalesOrder Class and passing paremeters to its constructor
                            new ViewSalesOrder(salesid, clientName, Phone, Address, orderDate).setVisible(true);
                           
                        } else if(btnControl.equalsIgnoreCase("invoice")){
                            
                            //calling the Invoice Class and passing paremeters to its constructor
                            new Invoice(salesid, orderDate, Phone).setVisible(true);
                        }

                        System.out.println(salesid + clientName + Phone + Address + itemId + itemName + description + Rate + quantity + price + Total + orderDate);
                    } else {
                        //JOption pane to show dialog options for user experience
                        JOptionPane.showMessageDialog(this, "Error in getting order details", "No Sales Order", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        }else{
            //JOption pane to show dialog options for user experience
            JOptionPane.showMessageDialog(this, "Field Cannot Be Empty", "No Sales Order", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void main(String... args) {
        SearchForSalesOrderDetails se = new SearchForSalesOrderDetails();
    }
}
