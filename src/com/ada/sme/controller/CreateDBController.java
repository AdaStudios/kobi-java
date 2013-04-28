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
import java.util.logging.Level;
import java.util.logging.Logger;
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
                System.out.println("yaratıldı0");
                stmt.execute("CREATE TABLE employee(id int primary key, name varchar(20), surname varchar(20), username varchar(20), password varchar(20))");
                stmt.execute("CREATE TABLE product(product_id int , model varchar(64), quantity int , stock_status_id int , image varchar(255) , shipping int , price decimal(15,4) , tax_class_id int , date_available date , weight decimal(15,8) , weight_class_id int , minimum int , subtract int , status int , date_added date , date_modified date)");
                stmt.execute("CREATE TABLE product_description(product_id int , language_id int , name varchar(255) , description varchar(255) , tag varchar(255))");
                stmt.execute("CREATE TABLE product_option(product_option_id int , product_id int , option_id int , required int)");
                stmt.execute("CREATE TABLE product_option_value(product_option_value_id int , product_option_id int , product_id int , option_id int, option_value_id int , quantity int , subtract int)");
                stmt.execute("CREATE TABLE product_to_category(product_id int , category_id int)");
                stmt.execute("CREATE TABLE product_image(product_image_id int , product_id int , image varchar(255) , sort_order int)");
                stmt.execute("CREATE TABLE order_t(order_id int, customer_id int, firstname varchar(30), lastname varchar(30), email varchar(30), telephone varchar(30), fax varchar(30), payment_firstname varchar(30), payment_lastname varchar(30), payment_company varchar(30), payment_address_1 varchar(128), payment_address_2 varchar(128), payment_city varchar(32), payment_postcode varchar(10), payment_country varchar(128), payment_zone varchar(128), payment_method varchar(128),"
                        + " shipping_firstname varchar(30), shipping_lastname varchar(30), shipping_company varchar(30), shipping_address_1 varchar(128), shipping_address_2 varchar(128), shipping_city varchar(32), shipping_postcode varchar(10), shipping_country varchar(128), shipping_zone varchar(128), comment varchar(255), total decimal(15,4), order_status_id int,currency_code varchar(3),date_added varchar(32), date_modified varchar(32))");
                stmt.execute("CREATE TABLE order_status(order_status_id int, order_language int, name varchar(32))");
                stmt.execute("CREATE TABLE order_product(order_product_id int, order_id int,product_id int,name varchar(255), model varchar(64), quantity int, price decimal(15,4), total decimal(15,4), tax decimal(15,4), reward int)");
                stmt.execute("CREATE TABLE order_option(order_option_id int, order_id int,order_product_id int,name varchar(255), value varchar(255) )");
                
                stmt.execute("INSERT INTO order_status VALUES (2, 1, 'Hazırlanıyor'), (3, 1, 'Kargolandı'), (7, 1, 'İptal edildi'), (5, 1, 'Tamamlandı'), (8, 1, 'Red edildi'), (9, 1, 'Canceled Reversal'), (10, 1, 'Başarısız'), (11, 1, 'Geri iade edildi'), (12, 1, 'Reversed'), (13, 1, 'Chargeback'), (1, 1, 'Onay aşamasında'), (16, 1, 'Voided'), (15, 1, 'Processed'), (14, 1, 'Expired')");
                // stmt.execute("INSERT INTO employee VALUES(1, 'riza', 'akbiyik', 'riza', 'riza')");
                System.out.println("yaratıldı");
                //cagdas
            } catch (Exception e) {
                e.printStackTrace();
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

    public void deleteAll() {
        NetworkServerControl server = null;
        Connection conn = null;
        PreparedStatement prestat = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDB;");
            stmt = conn.createStatement();
            stmt.execute("DELETE FROM product");
            stmt.execute("DELETE FROM product_description");
            stmt.execute("DELETE FROM product_option");
            stmt.execute("DELETE FROM product_option_value");
            stmt.execute("DELETE FROM product_to_category");
            stmt.execute("DELETE FROM product_image");
        } catch (SQLException ex) {
            Logger.getLogger(CreateDBController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
