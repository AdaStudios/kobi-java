/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.controller;

/**
 *
 * @author PaDaWaN
 */
import com.ada.sme.model.StatusModel;
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
    //static Connection conn = null;
    static Connection conn_on = null;
    static Connection conn_off = null;
    static ResultSet result = null;
    final String IPADDRESS = "139.179.139.112";
    StatusModel sm;

    public DBController() {

        try {
            sm = new StatusModel(IPADDRESS);
            server = new NetworkServerControl(InetAddress.getByName("localhost"), 1527);
            server.start(null);
            //OnlineDBController ne = new OnlineDBController();

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");

            String url2 = "jdbc:mysql://139.179.139.112/open";
            conn_on = DriverManager.getConnection(url2, "opendbu", "ozyaz.13");

            System.out.println("Database connected");


        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        } catch (Exception e) {
        }
        try {
            conn_off = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDB");
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insDelUpDB(String sql) {
        sm.check();
        PreparedStatement prestat;
        try {
            prestat = conn_on.prepareStatement("SET NAMES 'latin5'");
            prestat.execute();
            prestat = conn_on.prepareStatement("SET CHARACTER SET latin5");
            prestat.execute();
            prestat = conn_on.prepareStatement("SET COLLATION_CONNECTION = 'latin5_turkish_ci'");
            prestat.execute();
            prestat = conn_on.prepareStatement(sql);
            prestat.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
           
    }
    
    public void insProductDB(String sql) {
        sm.check();
        PreparedStatement prestat;
        try {               
                prestat = conn_off.prepareStatement(sql);
                prestat.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DefaultTableModel selectDB(String sql) {

        PreparedStatement prestat = null;
        try {
           
                prestat = conn_off.prepareStatement(sql);
                result = prestat.executeQuery();

                DefaultTableModel dtm = new DefaultTableModel();

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
                // server.shutdown();
            
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
    
    public DefaultTableModel selectDBFromOnline(String sql) {

        PreparedStatement prestat = null;
        try {
           
                prestat = conn_on.prepareStatement(sql);
                result = prestat.executeQuery();

                ResultSetMetaData meta = result.getMetaData();
                int numberOfColumns = meta.getColumnCount();
             
                DefaultTableModel dtm = new DefaultTableModel();

              
                for (int j = 1; j <= meta.getColumnCount(); j++) {
                    dtm.addColumn(meta.getColumnName(j));
                }
                
                while (result.next()) {
                    Object[] rowData = new Object[numberOfColumns];
                    for (int i = 0; i < rowData.length; ++i) {
                        rowData[i] = result.getObject(i + 1);
                        //System.out.println(result.getObject(i + 1).toString());
                    }
                    String sql2 = "INSERT into order_t VALUES("+String.valueOf(rowData[0])+","+String.valueOf(rowData[1])+",'"+String.valueOf(rowData[2])+"','"+String.valueOf(rowData[3])+"','"+String.valueOf(rowData[4])+"','"+String.valueOf(rowData[5])+"','"+String.valueOf(rowData[6])+"','"+String.valueOf(rowData[7])+"','"+String.valueOf(rowData[8])+"','"+String.valueOf(rowData[9])+"','"+String.valueOf(rowData[10])+"','"+String.valueOf(rowData[11])+"','"+String.valueOf(rowData[12])+"','"+String.valueOf(rowData[13])+"','"+String.valueOf(rowData[14])+"','"+String.valueOf(rowData[15])+"','"+String.valueOf(rowData[16])+"','"+String.valueOf(rowData[17])+"','"+String.valueOf(rowData[18])+"','"+String.valueOf(rowData[19])+"','"+String.valueOf(rowData[20])+"','"+String.valueOf(rowData[21])+"','"+String.valueOf(rowData[22])+"','"+String.valueOf(rowData[23])+"','"+String.valueOf(rowData[24])+"','"+String.valueOf(rowData[25])+"','"+String.valueOf(rowData[26])+"',"+String.valueOf(rowData[27])+","+String.valueOf(rowData[28])+",'"+String.valueOf(rowData[29])+"','"+String.valueOf(rowData[30])+"','"+String.valueOf(rowData[31])+"')";
                    System.out.println(sql2);
                    empInsDelUpDB(sql2);                   
                    
                }

                return selectDB("SELECT order_id, firstname, lastname, total, name, date_modified FROM order_t, order_status where order_t.order_status_id=order_status.order_status_id AND order_language=1 order by date_modified DESC");
                // server.shutdown();
            
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
    
    public void updateOrderProductDBFromOnline(String sql) {

        PreparedStatement prestat = null;
        try {
           
                prestat = conn_on.prepareStatement(sql);
                result = prestat.executeQuery();

                ResultSetMetaData meta = result.getMetaData();
                int numberOfColumns = meta.getColumnCount();
             
          
                
                while (result.next()) {
                    Object[] rowData = new Object[numberOfColumns];
                    for (int i = 0; i < rowData.length; ++i) {
                        rowData[i] = result.getObject(i + 1);
                        //System.out.println(result.getObject(i + 1).toString());
                    }
                    String sql2 = "INSERT into order_product VALUES("+String.valueOf(rowData[0])+","+String.valueOf(rowData[1])+","+String.valueOf(rowData[2])+",'"+String.valueOf(rowData[3])+"','"+String.valueOf(rowData[4])+"',"+String.valueOf(rowData[5])+","+String.valueOf(rowData[6])+","+String.valueOf(rowData[7])+","+String.valueOf(rowData[8])+","+String.valueOf(rowData[9])+")";
                    System.out.print("updateOP"+sql2);
                    empInsDelUpDB(sql2);                   
                    
                }

               // return selectDB("SELECT * FROM order_t, order_status where order_t.order_status_id=order_status.order_status_id AND order_language=2");
                // server.shutdown();
            
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
       

    }
    
    public void updateOrderOptionDBFromOnline(String sql) {

        PreparedStatement prestat = null;
        try {
           
                prestat = conn_on.prepareStatement(sql);
                result = prestat.executeQuery();

                ResultSetMetaData meta = result.getMetaData();
                int numberOfColumns = meta.getColumnCount();
 
                while (result.next()) {
                    Object[] rowData = new Object[numberOfColumns];
                    for (int i = 0; i < rowData.length; ++i) {
                        rowData[i] = result.getObject(i + 1);
                        //System.out.println(result.getObject(i + 1).toString());
                    }
                    String sql2 = "INSERT into order_option VALUES("+String.valueOf(rowData[0])+","+String.valueOf(rowData[1])+","+String.valueOf(rowData[2])+",'"+String.valueOf(rowData[3])+"','"+String.valueOf(rowData[4])+"')";
                    System.out.print("updateOP"+sql2);
                    empInsDelUpDB(sql2);                   
                    
                }

            
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
       

    }

    public boolean login(String username, String pass) {

        PreparedStatement prestat = null;
        try {

            prestat = conn_off.prepareStatement("SELECT password FROM employee WHERE username='" + username + "'");
            result = prestat.executeQuery();

            ResultSetMetaData meta = result.getMetaData();
            int numberOfColumns = meta.getColumnCount();

            
            if(result.next())
            if (result.getObject(1).toString().equals(pass)) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList fillCombo(String sql) {

        ArrayList list = new ArrayList();
        PreparedStatement prestat = null;
        try {


            prestat = conn_off.prepareStatement(sql);
            result = prestat.executeQuery();

            System.out.println(result.toString());

            DefaultTableModel dtm = new DefaultTableModel();

            ResultSetMetaData meta = result.getMetaData();

            int numberOfColumns = meta.getColumnCount();
            for (int j = 1; j < meta.getColumnCount(); j++) {
                list.add(meta.getColumnName(j));
            }

            return list;

        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }

        return null;
    }

    public static int getLastID(String sql) {
        try {
            PreparedStatement prestat = conn_off.prepareStatement(sql);
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
            prestat = conn_off.prepareStatement(sql);
            result = prestat.executeQuery();

            ResultSetMetaData meta = result.getMetaData();
            int numberOfColumns = meta.getColumnCount();
            while (result.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    list.add(result.getObject(i));
                }

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
    
    public void empInsDelUpDB(String sql) {
         try {
                PreparedStatement prestat;
                prestat = conn_off.prepareStatement(sql);
                prestat.execute();
                /*file*/            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
