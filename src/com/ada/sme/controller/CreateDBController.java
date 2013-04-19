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
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.derby.drda.NetworkServerControl;

public class CreateDBController
{

    public CreateDBController() {
        
    }
    
    public void createDB(){
        NetworkServerControl server = null;
        Connection conn = null;
        PreparedStatement prestat = null;
        Statement stmt = null;
       
 
        try {
            server = new NetworkServerControl(InetAddress.getByName("localhost"), 1527);
            server.start(null);
        } catch (UnknownHostException e1) {
        } catch (Exception e1) {
        }
         
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
        }
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDB;create=true");
             
            stmt = conn.createStatement();
            try {
                stmt.execute("CREATE TABLE employee(id int primary key, name varchar(20), surname varchar(20), username varchar(20), password varchar(20))");
            } catch (Exception e) {
                //e.printStackTrace();
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
    
}
    
  
