package com.ada.sme.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ada.sme.controller.StatusController;
import com.ada.sme.main.Main;
import com.ada.sme.main.Product;

public class FileModel {

	File file;
	ObjectOutputStream oout;
	ObjectInputStream oin;
	Connection connection;
	

	public FileModel(String filename) {
		this.file = new File(filename);
		this.connection = StatusController.connection;
	
		/*try {
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/*public ArrayList<Product> getProducts(){
		System.out.println(products.size()+"File");
		return products;
	
	}*/
	
	public void updateFile() {
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			//products.clear();
			Statement s = connection.createStatement();
			// ((org.postgresql.jdbc3.AbstractJdbc3Statement)s).setQueryTimeout(1);

			String sql = "select * from stock";
			// ResultSet
			// resultset=((org.postgresql.jdbc3.AbstractJdbc3Statement)s).executeQuery(sql);
			ResultSet resultset = s.executeQuery(sql);
			// searchResult.clear();
			while (resultset.next()) {
				int id = resultset.getInt(1);
				String pname = resultset.getString(2);
				int amount = resultset.getInt(3);
				double price = resultset.getDouble(4);
				String feature = resultset.getString(5);
				products.add(new Product(id, pname, amount, price, feature));
			}
			System.out.println(products.size()+"beforewrite");
			oout = new ObjectOutputStream(new FileOutputStream(file));
			oout.writeObject(products);
			oout.close();
			System.out.println("all written");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Product> fillArrayList(){
		ArrayList<Product> products = null;
		try {
			oin = new ObjectInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			products = (ArrayList<Product>)(oin.readObject());
			oin.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return products;
		
	}

}
