package com.ada.sme.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import com.ada.sme.main.Main;
import com.ada.sme.model.FileModel;
import com.ada.sme.model.StatusModel;
import com.ada.sme.model.StockModel;
import com.ada.sme.view.StatusPanelView;


public class StatusController extends Thread{
	public static Connection connection;
	StatusModel sm; 
	StatusPanelView sp;
	FileModel file_model;
	StockModel st_m;
	boolean lastans = true;
	
	static int sleeptime = 2000;
	
	public StatusController(StatusModel sm, StatusPanelView sp) {			
		this.sm = sm;
		this.sp = sp;
		st_m = new StockModel();
		file_model = new FileModel("offlinestock.bin");
		this.start();
	}
	
	public void run() {
		while(true)
			try {				
				sm.check();
				boolean ans = sm.getStatus();
				sp.setStatus(ans);
				sp.setWaiting(StockController.commits.size());
				if(!ans && lastans){
					
					Main.setProducts(file_model.fillArrayList());
				}else if(!lastans && ans){
					int a = st_m.executeCommits(StockController.commits);
					if(a==1){
						StockController.commits.clear();
					}
				}
				lastans = ans;
				sleep(sleeptime);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		//System.out.println("DONE! " + getName());
	}
	
	/*
	public void changeStatus(Boolean b){
		sp.setStatus(b);
	}
	
	public void changeWaiting(int a){
		sp.setWaiting(a);
	}*/
	
	public void initializeDB() {
	    try {
	      // Load the JDBC driver
	      Class.forName("org.postgresql.Driver");
	      System.out.println("Driver loaded");

	      // Establish a connection		
	      String url = "jdbc:postgresql://ozguryazilim.bilkent.edu.tr/projectsme";
	      /*  String user = "user12";
	        String password = "34klq*";
	      String con = "jdbc:mysql://ozguryazilim.bilkent.edu.tr/projectsme";*/
	      //connection = DriverManager.getConnection(con,"osman","1269318+");
	      connection = DriverManager.getConnection(url,"osman","ozyaz.14");
	     
	  
	      System.out.println("Database connected");
	   
	     
	    }
	    catch (Exception ex) {
	      ex.printStackTrace();
	    }
 }

}
