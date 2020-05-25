/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderinginvoicingsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class SalesLogic {

    String id = null, id2 = null, id3 = null, id4 = null, id5 = null, id6 = null, id7 = null, id8 = null, id9 = null, id10 = null, id11 = null, id12 = null, id13 = null;
    
    // final variables (meaning it cannot be changed)
   final String READER = "C:\\Users\\HP\\Documents\\NetBeansProjects\\OrderingInvoicingSystem\\src\\orderinginvoicingsystem\\Order.txt";
   final String SALES = "C:\\Users\\HP\\Documents\\NetBeansProjects\\OrderingInvoicingSystem\\src\\orderinginvoicingsystem\\Salesorder.txt";

    /**
     *
     * @param name
     * @param salesId
     * @param itemId
     * @param itemName
     * @param itemDesc
     * @param Rate
     * @param Quantity
     * @param price
     * @param total
     */
    //method used to add item to order.txt file
    public void addOrderDetails(JPanel name,String salesId, String itemId, String itemName, String itemDesc, double Rate, double Quantity, double price, double total) {

        String content = "\n" + salesId.trim() + "," + itemId.trim() + "," + itemName.trim() + "," + itemDesc.trim() + "," + Rate + "," + Quantity + "," + price + "," + total;

        Path file = Paths.get(READER);//change part accordingly
        Charset charset = Charset.forName("US-ASCII");
        
        //using try with resources for the Buffered Writer class
        try (BufferedWriter writer = Files.newBufferedWriter(file, charset, StandardOpenOption.APPEND)) {

            //calling JOption pane
            int n = JOptionPane.showConfirmDialog(name, "Do You Want Save the Sales Order ?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (n == JOptionPane.YES_OPTION) {
//                System.out.println("yessssssssssssssssssssssssssssssssssssssssssssss");
                 //if yes option
                //used to write content in a text file
                writer.write(content);
                name.validate();
                name.repaint();
                JOptionPane.showMessageDialog(name, "Item Saved Successfully");
            } else if (n == JOptionPane.NO_OPTION) {
                //if no option
                JOptionPane.showMessageDialog(name, "No option choosen no record written.", "Ok Message", JOptionPane.OK_OPTION);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(name, e, "Error in adding order details", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     *
     * @param name
     * @param salesId
     * @param clientname
     * @param clientPhone
     * @param clientAddress
     * @param itemId
     * @param itemName
     * @param itemDesc
     * @param Rate
     * @param Quantity
     * @param price
     * @param total
     * @return 
     */
    //method used to add total order to salesOrder.txt file
    public boolean saveOrder(JPanel name, String salesId, String clientname, String clientPhone, String clientAddress, String itemId, String itemName, String itemDesc, double Rate, double Quantity, double price, double total) {

        boolean valid = false;
        long millis = System.currentTimeMillis();
        Date orderDate = new java.sql.Date(millis);
        System.out.println(orderDate);

        String content = "\n" + salesId.trim() + "," + clientname.trim() + "," + clientPhone.trim() + "," + clientAddress.trim() + "," + itemId.trim() + "," + itemName.trim() + "," + itemDesc.trim() + "," + Rate + "," + Quantity + "," + price + "," + total + "," + orderDate;

        Path file = Paths.get(SALES);
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedWriter writer = Files.newBufferedWriter(file, charset, StandardOpenOption.APPEND)) {

            int n = JOptionPane.showConfirmDialog(name, "Do You Want Save the Total Sales Order ?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (n == JOptionPane.YES_OPTION) {
                writer.write(content);
                JOptionPane.showMessageDialog(name, "Total Sales Order Saved Successfully");
                valid = true;
            } else if (n == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(name, "No option choosen no record written.", "Ok Message", JOptionPane.OK_OPTION);
            }
            
           
        } catch (IOException e) {
            JOptionPane.showMessageDialog(name, e, "Error in adding order details", JOptionPane.ERROR_MESSAGE);
        }
        
        return valid;
    }

    /**
     *
     * @param panel
     * @param name
     * @param name2
     * @param word
     * @return 
     * @throws IOException
     */
    //checking if salesid exist in salesOrder.txt file
    public boolean readsingleFile(String word) throws IOException {
       
        File f = new File(SALES);
        BufferedReader freader = new BufferedReader(new FileReader(f));
        String s; boolean valid = false;
        while ((s = freader.readLine()) != null) {
             
            String[] st = s.split(",");
            id = st[0];

            if (id.equalsIgnoreCase(word)) {
                valid = true;              
            }
        }
        
       return valid;
    }

}
