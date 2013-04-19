/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.controller;

/**
 *
 * @author PaDaWaN
 */

import java.awt.List;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.apache.derby.drda.NetworkServerControl;


public class DBController {

    public DBController() {
        
    }
    
    public void insDelUpDB(String sql){
        NetworkServerControl server = null;
        Connection conn = null;
        PreparedStatement prestat = null;
        Statement stmt = null;
        
        System.out.println("hebele");
 
        try {
            server = new NetworkServerControl(InetAddress.getByName("localhost"), 1527);
            server.start(null);
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
         
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDB");
             
            stmt = conn.createStatement();            
            try {
                stmt.execute(sql);
                System.out.println(sql);
            } catch (Exception e) {
                 
            }            
            conn.close();
            conn = null;
             
            server.shutdown();
             
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{            
            if (conn != null){
                try {conn.close();} catch(SQLException e) {;}
            conn = null;
            }
        }
     
    }
    
    
    public DefaultTableModel selectDB(String sql){
        NetworkServerControl server = null;
        Connection conn = null;
        PreparedStatement prestat = null;
        Statement stmt = null;
        ResultSet result = null;
        
 
        try {
            server = new NetworkServerControl(InetAddress.getByName("localhost"), 1527);
            server.start(null);
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
         
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDB");
             
            stmt = conn.createStatement();       
           
                         
            prestat = conn.prepareStatement(sql);
            result = prestat.executeQuery();
            
            System.out.println(result.toString());
            
            DefaultTableModel dtm = new DefaultTableModel();
                
        try{
            
            
            ResultSetMetaData meta = result.getMetaData();
            int numberOfColumns = meta.getColumnCount();
            for (int j = 1; j<meta.getColumnCount();j++)
                dtm.addColumn(meta.getColumnName(j));
            while (result.next())
            {
                Object [] rowData = new Object[numberOfColumns];
                for (int i = 0; i < rowData.length; ++i)
                {
                    rowData[i] = result.getObject(i+1);
                    System.out.println(result.getObject(i+1).toString());
                }
                dtm.addRow(rowData);
                
                
            }
            //table.setModel(dtm);
            
            return dtm;
            //dtm.fireTableDataChanged();
            //////////////////////////

        }
        catch(Exception e){
            System.err.println(e);
            e.printStackTrace();
        }
        finally{
            try{
                result.close();
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
            
            
             
            server.shutdown();
             
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if (result != null){
                try { result.close();} catch (SQLException e){;}
                result = null;
            }
            if (prestat != null){
                try { prestat.close();} catch (SQLException e){;}
                prestat = null;
            }
            if (conn != null){
                try {conn.close();} catch(SQLException e) {;}
            conn = null;
            }      
            
            
        }
        
      return null;
     
    }
    
    
     public ArrayList selectSingleRowDB(String sql){
        NetworkServerControl server = null;
        Connection conn = null;
        PreparedStatement prestat = null;
        Statement stmt = null;
        ResultSet result = null;
        ArrayList list =new ArrayList();
        
 
        try {
            server = new NetworkServerControl(InetAddress.getByName("localhost"), 1527);
            server.start(null);
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
         
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDB");
             
            stmt = conn.createStatement();       
           
                         
            prestat = conn.prepareStatement(sql);
            result = prestat.executeQuery();
            
            ResultSetMetaData meta = result.getMetaData();
            int numberOfColumns = meta.getColumnCount();
            while (result.next())
            {
              list.add(result.getObject(1));
              list.add(result.getObject(2));
              list.add(result.getObject(3));
              list.add(result.getObject(4));
              list.add(result.getObject(5));
                
                
            }
            
            return list;
                
        
            
            
             
           
             
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if (result != null){
                try { result.close();} catch (SQLException e){;}
                result = null;
            }
            if (prestat != null){
                try { prestat.close();} catch (SQLException e){;}
                prestat = null;
            }
            if (conn != null){
                try {conn.close();} catch(SQLException e) {;}
            conn = null;
            }      
            
            
        }
        
      return list;
     
    }
    
}
