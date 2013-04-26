/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cagdas
 */
public class OnlineDBController {

    static Connection conn2 = null;

    public OnlineDBController() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");

            String url2 = "jdbc:mysql://139.179.139.112/open";
            conn2 = DriverManager.getConnection(url2, "opendbu", "ozyaz.13");

            System.out.println("Database connected");


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        /*   Connection con = null;
         Class.forName("com.mysql.jdbc.Driver");
         String username = "opendbu";
         String password = "ozyaz.13";
         String server = "139.179.139.112"; //remote server address
         String db = "open";
         String url = "jdbc:mysql://"+server+"/"+db;
         con = DriverManager.getConnection(url, username, password);
         } catch (ClassNotFoundException ex) {
         Logger.getLogger(OnlineDBController.class.getName()).log(Level.SEVERE, null, ex);
         }*/
    }
}
