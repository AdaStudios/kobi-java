/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.view;

import com.ada.sme.main.*;
import com.ada.sme.controller.DBController;
import com.ada.sme.model.StatusModel;
import static com.ada.sme.view.MainFrame.main_anapanel;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author PaDaWaN
 */
public class TempAddStockView extends javax.swing.JPanel {

    /**
     * Creates new form TempAddStockView
     */
    MainFrame frame;
    FileReader oin, oin_image, oin_image_sql;
    FileWriter oout, oout_image, oout_image_sql;
    ArrayList<String> sql_list;
    int image_id;

    public TempAddStockView(MainFrame main) {
        initComponents();
        sql_list = new ArrayList<String>();
        frame = main;

        String select_sql;

        try {

            oin = new FileReader(Main.file);
            BufferedReader reader = new BufferedReader(oin);


            String tmp;

            DBController dbController = new DBController();
            DefaultTableModel dtm;
            select_sql = "SELECT product.product_id,model,quantity,image,price,status FROM product WHERE ";

            int flag = 0;
            String satir;

            while ((satir = reader.readLine()) != null) {
                tmp = satir;
                sql_list.add(reader.readLine());
                sql_list.add(reader.readLine());
                sql_list.add(reader.readLine());
                sql_list.add(reader.readLine());
                sql_list.add(reader.readLine());
                sql_list.add(reader.readLine());
                sql_list.add(reader.readLine());
                sql_list.add(reader.readLine());

                System.out.print("IDDDDDDDDDD=" + tmp + "\n");
                if (flag == 0) {
                    flag = 1;
                    select_sql += "product_id=" + tmp + " ";
                } else {
                    select_sql += "OR product_id=" + tmp + " ";
                }

            }


            reader.close();
            System.out.println(select_sql);
            dtm = dbController.selectDB(select_sql);
            TASV_list.setModel(dtm);
        } catch (IOException ex) {
            Logger.getLogger(AddStockPanelView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane2 = new javax.swing.JScrollPane();
        TASV_list = new javax.swing.JTable();
        TASV_yeni = new javax.swing.JButton();
        TASV_kaydet = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        TASV_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TASV_listMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TASV_list);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 12);
        add(jScrollPane2, gridBagConstraints);

        TASV_yeni.setBackground(new java.awt.Color(67, 149, 195));
        TASV_yeni.setText("Yeni Ürün Ekle");
        TASV_yeni.setMaximumSize(new java.awt.Dimension(140, 35));
        TASV_yeni.setMinimumSize(new java.awt.Dimension(140, 35));
        TASV_yeni.setPreferredSize(new java.awt.Dimension(140, 35));
        TASV_yeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TASV_yeniActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        add(TASV_yeni, gridBagConstraints);

        TASV_kaydet.setText("Eklenen Ürünleri Kaydet");
        TASV_kaydet.setMaximumSize(new java.awt.Dimension(250, 35));
        TASV_kaydet.setMinimumSize(new java.awt.Dimension(220, 35));
        TASV_kaydet.setPreferredSize(new java.awt.Dimension(220, 35));
        TASV_kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TASV_kaydetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        add(TASV_kaydet, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void TASV_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TASV_listMouseClicked
        String id = TASV_list.getValueAt(TASV_list.getSelectedRow(), 0).toString();
        UpdateStockPanelView updateStockPanelView = new UpdateStockPanelView(id);
        MainFrame.main_anapanel.removeAll();
        MainFrame.main_anapanel.add(updateStockPanelView);
        MainFrame.main_anapanel.validate();

    }//GEN-LAST:event_TASV_listMouseClicked

    private void TASV_yeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TASV_yeniActionPerformed
        frame.main_anapanel.removeAll();
        try {
            frame.main_anapanel.add(new AddStockPanelView(frame));
        } catch (IOException ex) {
            Logger.getLogger(StockLeftPanelView.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.main_anapanel.validate();
    }//GEN-LAST:event_TASV_yeniActionPerformed

    private void TASV_kaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TASV_kaydetActionPerformed
        try {
            DBController db = new DBController();
            for (int i = 0; i < sql_list.size(); i++) {
                if (StatusModel.check()) {
                    db.insDelUpDB(sql_list.get(i));
                } else {
                    Main.write(sql_list.get(i));
                }
            }
            oout = new FileWriter(Main.file);
            BufferedWriter bw = new BufferedWriter(oout);
            System.out.print("Yazdım");
            bw.close();
            
            
            
            oin_image_sql = new FileReader(Main.file2);
            BufferedReader reader_image_sql = new BufferedReader(oin_image_sql);
            String satir;
            while ((satir = reader_image_sql.readLine()) != null) {
                if (StatusModel.check())
                    db.insDelUpDB(satir);
                else
                    Main.write(satir);
            }
            reader_image_sql.close();
            oout_image_sql = new FileWriter(Main.file2);
            BufferedWriter bw_image_sql = new BufferedWriter(oout_image_sql);
            System.out.print("Yazdım");
            bw_image_sql.close();

        } catch (IOException ex) {
            Logger.getLogger(TempAddStockView.class.getName()).log(Level.SEVERE, null, ex);
        }
        main_anapanel.removeAll();
        main_anapanel.add(new ManageStockView());
        main_anapanel.validate();


        main_anapanel.updateUI();



    }//GEN-LAST:event_TASV_kaydetActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TASV_kaydet;
    private javax.swing.JTable TASV_list;
    private javax.swing.JButton TASV_yeni;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
