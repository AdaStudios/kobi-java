package com.ada.sme.main;

import com.ada.sme.controller.StartupController;
import com.ada.sme.controller.StoreController;
import com.ada.sme.view.CreateOwnerView;
import com.ada.sme.view.LoginView;
import com.ada.sme.view.LeftMenuView;

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
        } else
        {
            LoginView loginScreen = new LoginView();

            StartupController startupController = new StartupController(loginScreen);


            loginScreen.setVisible(true);

            frame = new JFrame("Giriş Ekranı");
            frame.setContentPane(loginScreen.getLoginViewContainerPanel());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    }

    public static void closeLogin()
    {
        frame.setVisible(false);
    }

    public static void setProducts(ArrayList<Product> p)
    {
        products.clear();
        products.addAll(p);
    }


}
