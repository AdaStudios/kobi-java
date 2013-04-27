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

public class CreateDBController {

    public CreateDBController() {
    }

    public void createDB() {
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
        } catch (Exception e) {
        }
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDB;create=true");
            
            stmt = conn.createStatement();
            try {
                stmt.execute("CREATE TABLE employee(id int primary key, name varchar(20), surname varchar(20), username varchar(20), password varchar(20))");
                stmt.execute("CREATE TABLE product(product_id int , model varchar(64), quantity int , stock_status_id int , image varchar(255) , shipping int , price decimal(15,4) , tax_class_id int , date_avaiable date , weight decimal(15,8) , weight_class_id int , minimum int , subtract int , status int , date_added date , date_modified date)");
                stmt.execute("CREATE TABLE product_description(product_id int , language_id int , name varchar(255) , description varchar(255) , tag varchar(255))");
                stmt.execute("CREATE TABLE product_option(product_option_id int , product_id int , option_id int , required int)");
                stmt.execute("CREATE TABLE product_option_value(product_option_value_id int , product_option_id int , product_id int , option_id int, option_value_id int , quantity int , subtract int)");
                stmt.execute("CREATE TABLE product_to_category(product_id int , category_id int)");
                stmt.execute("CREATE TABLE product_image(product_image_id int , product_id int , image varchar(255) , sort_order int)");
               // stmt.execute("INSERT INTO employee VALUES(1, 'riza', 'akbiyik', 'riza', 'riza')");
                
                //cagdas
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
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {;
                }
                conn = null;
            }
        }
    }
}
