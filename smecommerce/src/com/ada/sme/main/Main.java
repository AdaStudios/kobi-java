package com.ada.sme.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import com.ada.sme.controller.StartupController;
import com.ada.sme.controller.StatusController;
import com.ada.sme.controller.StockController;
import com.ada.sme.model.StatusModel;
import com.ada.sme.model.StockModel;
import com.ada.sme.view.CreateOwnerView;
import com.ada.sme.view.LoginView;
import com.ada.sme.view.StatusPanelView;
import com.ada.sme.view.StockView;

import javax.swing.*;


public class Main {

	
	//public static Statement statement;
	public static ArrayList<Product> products;
    static JFrame frame;
    /**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		products = new ArrayList<Product>();
		//System.out.println("Arraylist size:"+products.size());
        int owner = 1;


        if(owner==0){
            CreateOwnerView createOwner = new CreateOwnerView();
        }else{
            System.out.print("hebele");
            LoginView loginScreen = new LoginView();
            StartupController startupController = new StartupController(loginScreen);

            loginScreen.setVisible(true);

             frame = new JFrame("LoginView");
            frame.setContentPane(loginScreen.loginViewContainerPanel);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }


		
	}

    public static void closeLogin(){
           frame.setVisible(false);
    }

	
	public static void setProducts(ArrayList<Product> p){		
		products.clear();
		products.addAll(p);		
	}
	
	

}
