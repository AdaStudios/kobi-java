package com.ada.sme.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import com.ada.sme.controller.StatusController;
import com.ada.sme.controller.StockController;
import com.ada.sme.model.StatusModel;
import com.ada.sme.model.StockModel;
import com.ada.sme.view.StatusPanelView;
import com.ada.sme.view.StockView;


public class Main {

	
	//public static Statement statement;
	public static ArrayList<Product> products;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		products = new ArrayList<Product>();
		//System.out.println("Arraylist size:"+products.size());
		StatusPanelView statuspanel = new StatusPanelView();
		StatusModel statusmodel = new StatusModel("139.179.139.112");
		StatusController c = new StatusController(statusmodel, statuspanel);	
		 c.initializeDB();
		 
		StockModel model = new StockModel();		
		StockView frame = new StockView(model,statuspanel);
		StockController s_controller = new StockController(model,frame);	
		
	   
		frame.setVisible(true);
		
	}
	
	
	
	public static void setProducts(ArrayList<Product> p){		
		products.clear();
		products.addAll(p);		
	}
	
	

}
