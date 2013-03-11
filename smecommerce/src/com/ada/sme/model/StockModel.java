package com.ada.sme.model;

import com.ada.sme.controller.StatusController;
import com.ada.sme.main.Main;
import com.ada.sme.main.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StockModel {

	private static ArrayList<Product> searchResult;
	private String commit = "";
	//Inet4Address a;

	public StockModel() {
		searchResult = new ArrayList<Product>();
		
		reset();
	/*	try {
		//	a = (Inet4Address) InetAddress.getByName("139.179.139.112");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	public void reset() {
		searchResult.clear();
	}

	/*public boolean isReachable() {

		try {
			Boolean b = a.isReachable(200);
			return b;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}*/

	public void search(String q) {
		searchResult.clear();
		if(!q.equals(""))
		try {
			Statement s = StatusController.connection.createStatement();
			// ((org.postgresql.jdbc3.AbstractJdbc3Statement)s).setQueryTimeout(1);
			// searchResult.clear();
			/*
			 * if(q.equals("")){ throw new Exception(); }
			 */
			String sql = "select * from stock where productId=" + q;
			// ResultSet
			// resultset=((org.postgresql.jdbc3.AbstractJdbc3Statement)s).executeQuery(sql);
			ResultSet resultset = s.executeQuery(sql);
			
			while (resultset.next()) {
				int id = resultset.getInt(1);
				String pname = resultset.getString(2);
				int amount = resultset.getInt(3);
				double price = resultset.getDouble(4);
				String feature = resultset.getString(5);
				searchResult
						.add(new Product(id, pname, amount, price, feature));
			}
			System.out.println(searchResult.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();

		}
	}

	public void searchOffline(String q) {
		searchResult.clear();
		ArrayList<Product> off = Main.products;
		if(!q.equals(""))
		for (int i = 0; i < off.size(); i++) {
			if (off.get(i).getpId() == Integer.valueOf(q)) {
				searchResult.add(off.get(i));
				break;
			}
		}
	}

	public ArrayList<Product> getSearch() {

		return searchResult;
	}

	public int executeCommits(ArrayList<String> c){
		Statement s;
		for (int i = 0; i < c.size(); i++) {
			try {
				s =  StatusController.connection.createStatement();
				s.executeUpdate(c.get(i));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;	
			}
		}
		return 1;
	}
	
	public int add(Product p) {

		try {
			String sql = "INSERT INTO stock (productName,count,price,feature) VALUES (?, ?, ?, ?)";
			PreparedStatement ps =  StatusController.connection.prepareStatement(sql);
			ps.setString(1, p.getpName());
			ps.setInt(2, p.getAmount());
			ps.setDouble(3, p.getPrice());
			ps.setString(4, p.getpFeature());
			//ps.setQueryTimeout(5);
			ps.executeUpdate();
			ps.close();
			return 1;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return -1;

	}
	
	public String addOffline(Product p) {

		try {
			String sql = "INSERT INTO stock (productName,count,price,feature) VALUES (?, ?, ?, ?)";
			PreparedStatement ps =  StatusController.connection.prepareStatement(sql);
			ps.setString(1, p.getpName());
			ps.setInt(2, p.getAmount());
			ps.setDouble(3, p.getPrice());
			ps.setString(4, p.getpFeature());
			//ps.setQueryTimeout(5);
			//ps.executeUpdate();
			commit = ps.toString();
			
			return commit;
			//ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return "";

	}
	

	
	public int update(Product p) {

		try {
			String sql = "UPDATE stock SET productName = ?, count = ?, price = ?, feature = ? where productId = "+p.getpId();
			
			PreparedStatement ps =  StatusController.connection.prepareStatement(sql);
			ps.setString(1, p.getpName());
			ps.setInt(2, p.getAmount());
			ps.setDouble(3, p.getPrice());
			ps.setString(4, p.getpFeature());
			//ps.setQueryTimeout(5);
			ps.executeUpdate();
			ps.close();
			return 1;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return -1;

	}
	
	public String updateOffline(Product p) {

		try {
			String sql = "UPDATE stock SET productName = ?, count = ?, price = ?, feature = ? where productId = "+p.getpId();
			
			PreparedStatement ps =  StatusController.connection.prepareStatement(sql);
			ps.setString(1, p.getpName());
			ps.setInt(2, p.getAmount());
			ps.setDouble(3, p.getPrice());
			ps.setString(4, p.getpFeature());
			//ps.setQueryTimeout(5);
			//ps.executeUpdate();
			//ps.close();
			return ps.toString();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return "";

	}

	public int delete(int id) {
		try {
			Statement s =  StatusController.connection.createStatement();
			String sql = "delete from stock where productId=" + id;
			s.executeUpdate(sql);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public String deleteOffline(int id) {
		try {
			Statement s =  StatusController.connection.createStatement();
			String sql = "delete from stock where productId=" + id;
			//s.executeUpdate(sql);
			return sql;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}
