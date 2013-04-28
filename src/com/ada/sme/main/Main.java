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
import com.ada.sme.view.MainFrame;
import com.ada.sme.view.TempAddStockView;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
//import com.ada.sme.view.LeftMenuView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

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
    public static FileReader oin_image;
    public static FileWriter oout_images;
    private static FileWriter oout_image;
    public static void main(String[] args)
    {
       
        temp_sql = new File("tmp_sql.txt");
        file = new File("tmp_stock_list.txt");
        file1 = new File("tmp_image_list.txt");
        file2 = new File("tmp_image_list_sql.txt");
        products = new ArrayList<Product>();
        //System.out.println("Arraylist size:"+products.size());
        /*CreateDBController createDB =new CreateDBController();
        createDB.createDB();*/
        
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


public static void write(String sql)  {
        try {    
            sql_out = new FileWriter(temp_sql,true);
            BufferedWriter bw = new BufferedWriter(sql_out);
            bw.write(sql+"\n");
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
            
  }
  
  /** Read the contents of the given file. */
  public static void read() {
    try{
     sql_read = new FileReader(temp_sql);
            BufferedReader sql_reader = new BufferedReader(sql_read);
            String satir = "";
             while((satir = sql_reader.readLine()) != null){                
                 db.insDelUpDB(satir);
                 System.err.println(satir);
    
             }
             sql_reader.close();
                          
            sql_out = new FileWriter(temp_sql);
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

    public static void imageUpload() throws FileNotFoundException, IOException {
            MainFrame.uploading=true;
            oin_image = new FileReader(file1);
            BufferedReader reader_image = new BufferedReader(oin_image);
            String satir;
            
            ArrayList<String> list =new ArrayList<String>();
            
            while ((satir = reader_image.readLine()) != null) 
                list.add(satir);
            
            reader_image.close();
            
            oout_image = new FileWriter(Main.file1);
            BufferedWriter bw_image = new BufferedWriter(oout_image);
            System.out.print("Yazdım");
            bw_image.close();
            
            for(int i=0;i<list.size();i++){
                
                satir=list.get(i);
                String[] split;
                split = satir.split("\\/");
                String name = split[split.length - 1];
                try {
                    File f = new File(satir);
                    String urlString = "ftp://openftp:ozyaz.11@ozguryazilim.bilkent.edu.tr/" + name;
                    System.err.println(urlString);
                    URL url = new URL(urlString);
                    URLConnection connection = url.openConnection();
                    connection.setDoOutput(true);
                    BufferedOutputStream out = new BufferedOutputStream(connection.getOutputStream());
                    FileInputStream in = new FileInputStream(f);
                    byte[] buffer = new byte[1024];
                    int j = 0;
                    while ((j = in.read(buffer)) >= 0) {
                        out.write(buffer, 0, j);
                    }
                    out.close();
                    in.close();


                    String source = satir;
                    String target = "data/";

                    //name of source file
                    File sourceFile = new File(source);


                    File targetFile = new File(target + name);
                    System.out.println("Copying file : " + sourceFile.getName() + " from Java Program");

                    //copy file from one location to other
                    //FileUtils.copyFile(sourceFile, targetFile);
                    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            MainFrame.uploading=false;
            
        
    }


}
