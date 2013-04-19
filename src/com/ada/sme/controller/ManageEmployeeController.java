/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.controller;

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
import javax.swing.table.DefaultTableModel;
import org.apache.derby.drda.NetworkServerControl;

/**
 *
 * @author PaDaWaN
 */
public class ManageEmployeeController {
    
    public ArrayList fillCombo(){
        
        ArrayList list = new ArrayList();
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
           
                         
            prestat = conn.prepareStatement("SELECT * FROM employee");
            result = prestat.executeQuery();
            
            System.out.println(result.toString());
            
            DefaultTableModel dtm = new DefaultTableModel();
                
        try{
            
            
            ResultSetMetaData meta = result.getMetaData();
            
            int numberOfColumns = meta.getColumnCount();
            for (int j = 1; j<meta.getColumnCount();j++)
                list.add(meta.getColumnName(j));
            //table.setModel(dtm);
            
            return list;
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
    
}
