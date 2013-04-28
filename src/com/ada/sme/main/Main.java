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
import java.io.File;
//import com.ada.sme.view.LeftMenuView;

import javax.swing.*;
import java.util.ArrayList;

public class Main
{
    public static ArrayList<Product> products;
    static JFrame frame;
    public static File file;
    public static File file1;
    public static File file2;
    public static int image_id;
    
    public static void main(String[] args)
    {
        
        file = new File("tmp_ssdfastock_list.txt");
        file1 = new File("tmp_image_list.txt");
        file2 = new File("tmp_image_list_sql.txt");
        products = new ArrayList<Product>();
        //System.out.println("Arraylist size:"+products.size());
        /*CreateDBController createDB =new CreateDBController();
        createDB.createDB();*/
        
       DBController db = new DBController();
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



    public static void setProducts(ArrayList<Product> p)
    {
        products.clear();
        products.addAll(p);
    }


}
