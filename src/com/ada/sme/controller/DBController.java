/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.controller;

/**
 *
 * @author PaDaWaN
 */
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

    static NetworkServerControl server = null;
    static Connection conn = null;
    static ResultSet result = null;    

    public DBController() {
        
        try {
           
            server = new NetworkServerControl(InetAddress.getByName("localhost"), 1527);
            server.start(null);
             OnlineDBController ne = new OnlineDBController();
             
             
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        } catch (Exception e) {
            
        }
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDB");
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insDelUpDB(String sql) {
        
            try {
                PreparedStatement prestat = conn.prepareStatement(sql);
                prestat.execute();
                System.out.println(sql);
            } catch (Exception e) {
                System.err.println(e);
                e.printStackTrace();
            }
           
    }

    public DefaultTableModel selectDB(String sql) {
        
        PreparedStatement prestat = null;
        try {
            prestat = conn.prepareStatement(sql);
            result = prestat.executeQuery();

            System.out.println(result.toString());

            DefaultTableModel dtm = new DefaultTableModel();

            try {

                ResultSetMetaData meta = result.getMetaData();
                int numberOfColumns = meta.getColumnCount();
                for (int j = 1; j <= meta.getColumnCount(); j++) {
                    dtm.addColumn(meta.getColumnName(j));
                }
                while (result.next()) {
                    Object[] rowData = new Object[numberOfColumns];
                    for (int i = 0; i < rowData.length; ++i) {
                        rowData[i] = result.getObject(i + 1);
                        System.out.println(result.getObject(i + 1).toString());
                    }
                    dtm.addRow(rowData);
                }

                return dtm;

            } catch (Exception e) {
                System.err.println(e);
                e.printStackTrace();
            } finally {
                try {
                    result.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // server.shutdown();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {;
                }
                result = null;
            }
            if (prestat != null) {
                try {
                    prestat.close();
                } catch (SQLException e) {;
                }
                prestat = null;
            }
        }
        return null;

    }
    
    
    public boolean login(String username, String pass) {

        PreparedStatement prestat = null;
        try {

            prestat = conn.prepareStatement("SELECT password FROM employee WHERE username='" + username + "'");
            result = prestat.executeQuery();

            ResultSetMetaData meta = result.getMetaData();
            int numberOfColumns = meta.getColumnCount();
         
            result.next();
            if (result.getObject(1).toString().equals(pass)) {
                    return true;
            }
            
      

        } catch (SQLException e) {
            e.printStackTrace();
                        
        } 
        
        return false;

    }
    
    
     public ArrayList fillCombo(String sql){
        
        ArrayList list = new ArrayList();
        PreparedStatement prestat = null;
        try {
  
             
            prestat = conn.prepareStatement(sql);
            result = prestat.executeQuery();
            
            System.out.println(result.toString());
            
            DefaultTableModel dtm = new DefaultTableModel();

            ResultSetMetaData meta = result.getMetaData();
            
            int numberOfColumns = meta.getColumnCount();
            for (int j = 1; j<meta.getColumnCount();j++)
                list.add(meta.getColumnName(j));
            
            return list;
            
        }
        catch(Exception e){
            System.err.println(e);
            e.printStackTrace();
        }

      return null;
    }

    public static int getLastID(String sql) {
        try {
            PreparedStatement prestat = conn.prepareStatement(sql);
            prestat.setMaxRows(1);
            ResultSet rs = prestat.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (Exception ex) {
           ex.printStackTrace();
           
        }
        return 0;
    }

    public ArrayList selectSingleRowDB(String sql) {
        ArrayList list = new ArrayList();
        PreparedStatement prestat = null;
        try {
            prestat = conn.prepareStatement(sql);
            result = prestat.executeQuery();
            
            ResultSetMetaData meta = result.getMetaData();
            int numberOfColumns = meta.getColumnCount();
            while (result.next()) {
                for(int i=1;i<=numberOfColumns;i++)
                    list.add(result.getObject(i));
               
            }
            System.out.print(list.toString());
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return list;
    }
}
