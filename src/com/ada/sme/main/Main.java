/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.main;

/**
 *
 * @author PaDaWaN
 */


import com.ada.sme.view.CreateOwnerView;
import com.ada.sme.view.LoginView;
import com.ada.sme.controller.*;
//import com.ada.sme.view.LeftMenuView;

import javax.swing.*;
import java.util.ArrayList;

public class Main
{
    public static ArrayList<Product> products;
    static JFrame frame;

    public static void main(String[] args)
    {
        products = new ArrayList<Product>();
        //System.out.println("Arraylist size:"+products.size());
        int owner = 1;
        
        
        if (owner == 0)
        {
            CreateOwnerView createOwner = new CreateOwnerView();
            createOwner.setVisible(true);
        } else
        {
            
           CreateDBController createDB =new CreateDBController();
            createDB.createDB();
            
            
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