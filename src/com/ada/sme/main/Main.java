/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.main;

/**
 *
 * @author OSman
 */


import com.ada.sme.view.CreateOwnerView;
import com.ada.sme.view.LoginView;
import com.ada.sme.controller.*;
import com.ada.sme.view.TempAddStockView;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
//import com.ada.sme.view.LeftMenuView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main
{
    public static ArrayList<Product> products;
    static JFrame frame;
    public static File file;
    public static File file1;
    public static File file2;
    public static File temp_sql;
    public static int image_id;
    public static FileWriter sql_out;
    public static FileReader sql_read;
    public static DBController db;
    
    public static void main(String[] args)
    {
       
        temp_sql = new File("tmp_sql.txt");
        file = new File("tmp_stock_list.txt");
        file1 = new File("tmp_image_list.txt");
        file2 = new File("tmp_image_list_sql.txt");
        products = new ArrayList<Product>();
        //System.out.println("Arraylist size:"+products.size());
        CreateDBController createDB =new CreateDBController();
        createDB.createDB();
        
       db = new DBController();
       ArrayList a = db.selectSingleRowDB("select * from employee");
       
        if (a.isEmpty())
        {
            CreateOwnerView createOwner = new CreateOwnerView();
            createOwner.setVisible(true);            
           /* CreateDBController createDB =new CreateDBController();
            createDB.createDB();*/
        } else
        {                 
           /* CreateDBController createDB =new CreateDBController();
            createDB.createDB(); */         
            LoginView loginScreen = new LoginView();           
            loginScreen.setVisible(true);
            
        }
    }


public static void write(String sql) throws IOException  {
    
            sql_out = new FileWriter(temp_sql,true);
            BufferedWriter bw = new BufferedWriter(sql_out);
            bw.write(sql+"\n");
            bw.close();
  }
  
  /** Read the contents of the given file. */
  public static void read() throws IOException {
    try{
     sql_read = new FileReader(temp_sql);
            BufferedReader sql_reader = new BufferedReader(sql_read);
            String satir = "";
             while((satir = sql_reader.readLine()) != null){                
                 db.insDelUpDB(satir);             
    
             }
             sql_reader.close();
            BufferedWriter opennew = new BufferedWriter(sql_out);
            System.out.print("Yazdım");
            opennew.close();
    } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }    
            
  }
  
    public static void setProducts(ArrayList<Product> p)
    {
        products.clear();
        products.addAll(p);
    }


}
