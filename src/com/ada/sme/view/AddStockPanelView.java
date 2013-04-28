/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.view;

import com.ada.sme.main.*;
import com.ada.sme.controller.DBController;
import com.ada.sme.model.StatusModel;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author PaDaWaN
 */
public class AddStockPanelView extends javax.swing.JPanel {

    /**
     * Creates new form AddStockPanelView
     */
    int res;
    int image_id;
    boolean is_product_empty = false;
    FileWriter oout, oout_image_sql, oout_image;
    ObjectInputStream oin;
    MainFrame frame;
    DBController dbController;
    String first_image = null;

    public AddStockPanelView(MainFrame main) throws IOException {
        frame = main;
        initComponents();
        dbController = new DBController();


        ArrayList a = dbController.selectSingleRowDB("select * from product");
        java.util.Date today = new java.util.Date();
        java.sql.Date sqlToday = new java.sql.Date(today.getTime());

        if (a.isEmpty()) {
            is_product_empty = true;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ASPV_kod = new javax.swing.JTextField();
        ASPV_isim = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ASPV_fiyat = new javax.swing.JTextField();
        ASPV_adet_s = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        AEV_ekle = new javax.swing.JButton();
        AEV_liste = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ASPV_adet_l = new javax.swing.JTextField();
        ASPV_adet_m = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ASPV_agirlik = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ASPV_minimum = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ASPV_listele = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        ASPV_etiketler = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ASPV_aciklama = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        ASPV_gozat = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ASPV_resim_list = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(227, 227, 227));
        setMaximumSize(new java.awt.Dimension(646, 500));
        setMinimumSize(new java.awt.Dimension(646, 500));
        setPreferredSize(new java.awt.Dimension(646, 500));
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 2, 0, 2, 0, 2, 0, 2, 0};
        layout.rowHeights = new int[] {0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0};
        setLayout(layout);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Yeni Ürün Ekle");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        add(jLabel1, gridBagConstraints);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Ürün Kodu:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        add(jLabel2, gridBagConstraints);

        ASPV_kod.setMaximumSize(new java.awt.Dimension(70, 28));
        ASPV_kod.setMinimumSize(new java.awt.Dimension(70, 28));
        ASPV_kod.setPreferredSize(new java.awt.Dimension(70, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(ASPV_kod, gridBagConstraints);

        ASPV_isim.setMaximumSize(new java.awt.Dimension(1000, 28));
        ASPV_isim.setMinimumSize(new java.awt.Dimension(100, 28));
        ASPV_isim.setPreferredSize(new java.awt.Dimension(150, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        add(ASPV_isim, gridBagConstraints);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Ürün İsmi:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        add(jLabel3, gridBagConstraints);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Ürün Fiyatı:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        add(jLabel4, gridBagConstraints);

        ASPV_fiyat.setMaximumSize(new java.awt.Dimension(70, 28));
        ASPV_fiyat.setMinimumSize(new java.awt.Dimension(70, 28));
        ASPV_fiyat.setPreferredSize(new java.awt.Dimension(70, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(ASPV_fiyat, gridBagConstraints);

        ASPV_adet_s.setText("0");
        ASPV_adet_s.setMaximumSize(new java.awt.Dimension(40, 28));
        ASPV_adet_s.setMinimumSize(new java.awt.Dimension(40, 28));
        ASPV_adet_s.setPreferredSize(new java.awt.Dimension(40, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(ASPV_adet_s, gridBagConstraints);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Ürün Adeti:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        add(jLabel5, gridBagConstraints);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Ürün Resmi:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        add(jLabel6, gridBagConstraints);

        AEV_ekle.setBackground(new java.awt.Color(67, 149, 195));
        AEV_ekle.setForeground(new java.awt.Color(254, 254, 254));
        AEV_ekle.setText("Ürün Ekle");
        AEV_ekle.setMaximumSize(new java.awt.Dimension(130, 35));
        AEV_ekle.setMinimumSize(new java.awt.Dimension(130, 35));
        AEV_ekle.setPreferredSize(new java.awt.Dimension(130, 35));
        AEV_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AEV_ekleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        add(AEV_ekle, gridBagConstraints);

        AEV_liste.setBackground(new java.awt.Color(67, 149, 195));
        AEV_liste.setForeground(new java.awt.Color(254, 254, 254));
        AEV_liste.setText("Ürün Listesi");
        AEV_liste.setMaximumSize(new java.awt.Dimension(130, 35));
        AEV_liste.setMinimumSize(new java.awt.Dimension(130, 35));
        AEV_liste.setPreferredSize(new java.awt.Dimension(130, 35));
        AEV_liste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AEV_listeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        add(AEV_liste, gridBagConstraints);

        jLabel7.setText("Küçük");
        jLabel7.setToolTipText("");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabel7, gridBagConstraints);

        jLabel8.setText("Orta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabel8, gridBagConstraints);

        jLabel9.setText("Büyük");
        jLabel9.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabel9, gridBagConstraints);

        ASPV_adet_l.setText("0");
        ASPV_adet_l.setMaximumSize(new java.awt.Dimension(40, 28));
        ASPV_adet_l.setMinimumSize(new java.awt.Dimension(40, 28));
        ASPV_adet_l.setPreferredSize(new java.awt.Dimension(40, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(ASPV_adet_l, gridBagConstraints);

        ASPV_adet_m.setText("0");
        ASPV_adet_m.setMaximumSize(new java.awt.Dimension(40, 28));
        ASPV_adet_m.setMinimumSize(new java.awt.Dimension(40, 28));
        ASPV_adet_m.setPreferredSize(new java.awt.Dimension(40, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(ASPV_adet_m, gridBagConstraints);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Ürün Ağırlığı(Gr):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        add(jLabel10, gridBagConstraints);

        ASPV_agirlik.setMaximumSize(new java.awt.Dimension(70, 28));
        ASPV_agirlik.setMinimumSize(new java.awt.Dimension(70, 28));
        ASPV_agirlik.setPreferredSize(new java.awt.Dimension(70, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(ASPV_agirlik, gridBagConstraints);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Minimum:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        add(jLabel11, gridBagConstraints);

        ASPV_minimum.setMaximumSize(new java.awt.Dimension(70, 28));
        ASPV_minimum.setMinimumSize(new java.awt.Dimension(70, 28));
        ASPV_minimum.setPreferredSize(new java.awt.Dimension(70, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(ASPV_minimum, gridBagConstraints);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Ürünü Listele:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        add(jLabel12, gridBagConstraints);

        ASPV_listele.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PASİF", "AKTİF" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(ASPV_listele, gridBagConstraints);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Açıklama:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        add(jLabel13, gridBagConstraints);

        ASPV_etiketler.setMaximumSize(new java.awt.Dimension(1000, 28));
        ASPV_etiketler.setMinimumSize(new java.awt.Dimension(100, 28));
        ASPV_etiketler.setPreferredSize(new java.awt.Dimension(150, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        add(ASPV_etiketler, gridBagConstraints);

        ASPV_aciklama.setColumns(20);
        ASPV_aciklama.setRows(5);
        ASPV_aciklama.setMinimumSize(new java.awt.Dimension(40, 18));
        ASPV_aciklama.setPreferredSize(new java.awt.Dimension(100, 90));
        jScrollPane1.setViewportView(ASPV_aciklama);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane1, gridBagConstraints);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Etiketler:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        add(jLabel14, gridBagConstraints);

        ASPV_gozat.setBackground(new java.awt.Color(67, 149, 195));
        ASPV_gozat.setForeground(new java.awt.Color(254, 254, 254));
        ASPV_gozat.setText("Gözat");
        ASPV_gozat.setMaximumSize(new java.awt.Dimension(90, 35));
        ASPV_gozat.setMinimumSize(new java.awt.Dimension(90, 35));
        ASPV_gozat.setPreferredSize(new java.awt.Dimension(90, 35));
        ASPV_gozat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASPV_gozatActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(ASPV_gozat, gridBagConstraints);

        ASPV_resim_list.setColumns(20);
        ASPV_resim_list.setRows(3);
        jScrollPane3.setViewportView(ASPV_resim_list);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        add(jScrollPane3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void AEV_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AEV_ekleActionPerformed

        java.util.Date today = new java.util.Date();
        java.sql.Date sqlToday = new java.sql.Date(today.getTime());

        if (is_product_empty) {
            res = 1000;
        } else {
            res = DBController.getLastID("SELECT * FROM product order by product_id DESC");
        }

        res++;

        dbController.insProductDB("INSERT INTO product(product_id,model,quantity,stock_status_id,image,shipping,price,tax_class_id,date_available,weight,weight_class_id,subtract,minimum,status,date_added,date_modified) VALUES(" + res + ", '" + ASPV_kod.getText() + "', "
                + "" + (Integer.parseInt(ASPV_adet_s.getText()) + Integer.parseInt(ASPV_adet_m.getText()) + Integer.parseInt(ASPV_adet_l.getText())) + ", 6, 'data/" + first_image + "', 1, "
                + "" + Double.parseDouble(ASPV_fiyat.getText()) + ", 9, '" + sqlToday + "' , " + Double.parseDouble(ASPV_agirlik.getText()) + ", 2, " + Integer.parseInt(ASPV_minimum.getText()) + ", 1, "
                + "" + ASPV_listele.getSelectedIndex() + ", '" + sqlToday + "'  , '" + sqlToday + "' )");
        dbController.insProductDB("INSERT INTO product_description(product_id,language_id,name,description,tag) VALUES(" + res + ", 1, '" + ASPV_isim.getText() + "', '" + ASPV_aciklama.getText() + "', '" + ASPV_etiketler.getText() + "')");
        dbController.insProductDB("INSERT INTO product_option(product_option_id,product_id,option_id,required) VALUES(" + (res + 4000) + ", " + res + ",  11, 1 )");
        dbController.insProductDB("INSERT INTO product_option_value(product_option_value_id,product_option_id,product_id,option_id,option_value_id,quantity,subtract) VALUES(" + (res + 1000) + ", " + (res + 4000) + ", " + res + ", 11, 46, " + Integer.parseInt(ASPV_adet_s.getText()) + ", 1)");
        dbController.insProductDB("INSERT INTO product_option_value(product_option_value_id,product_option_id,product_id,option_id,option_value_id,quantity,subtract) VALUES(" + (res + 2000) + ", " + (res + 4000) + ", " + res + ", 11, 47, " + Integer.parseInt(ASPV_adet_m.getText()) + ", 1)");
        dbController.insProductDB("INSERT INTO product_option_value(product_option_value_id,product_option_id,product_id,option_id,option_value_id,quantity,subtract) VALUES(" + (res + 3000) + ", " + (res + 4000) + ", " + res + ", 11, 48, " + Integer.parseInt(ASPV_adet_l.getText()) + ", 1)");
        dbController.insProductDB("INSERT INTO product_to_category(product_id, category_id) VALUES(" + res + ",  61)");
        try {

            oout = new FileWriter(Main.file, true);
            BufferedWriter bw = new BufferedWriter(oout);

            bw.write(res + "\n");
            bw.write("INSERT INTO oc_product(product_id,model,quantity,stock_status_id,image,shipping,price,tax_class_id,date_available,weight,weight_class_id,subtract,minimum,status,date_added,date_modified) VALUES(" + res + ", '" + ASPV_kod.getText() + "', "
                    + "" + (Integer.parseInt(ASPV_adet_s.getText()) + Integer.parseInt(ASPV_adet_m.getText()) + Integer.parseInt(ASPV_adet_l.getText())) + ", 6, 'data/" + first_image + "', 1, "
                    + "" + Double.parseDouble(ASPV_fiyat.getText()) + ", 9, '" + sqlToday + "' , " + Double.parseDouble(ASPV_agirlik.getText()) + ", 2, " + Integer.parseInt(ASPV_minimum.getText()) + ", 1, "
                    + "" + ASPV_listele.getSelectedIndex() + ", '" + sqlToday + "'  , '" + sqlToday + "' )\n");

            bw.write("INSERT INTO oc_product_description(product_id,language_id,name,description,tag) VALUES(" + res + ", 1, '" + ASPV_isim.getText() + "', '" + ASPV_aciklama.getText() + "', '" + ASPV_etiketler.getText() + "')\n");
            bw.write("INSERT INTO oc_product_option(product_option_id,product_id,option_id,required) VALUES(" + (res + 4000) + ", " + res + ",  11, 1 )\n");
            bw.write("INSERT INTO oc_product_option_value(product_option_value_id,product_option_id,product_id,option_id,option_value_id,quantity,subtract) VALUES(" + (res + 1000) + ", " + (res + 4000) + ", " + res + ", 11, 46, " + Integer.parseInt(ASPV_adet_s.getText()) + ", 1)\n");
            bw.write("INSERT INTO oc_product_option_value(product_option_value_id,product_option_id,product_id,option_id,option_value_id,quantity,subtract) VALUES(" + (res + 2000) + ", " + (res + 4000) + ", " + res + ", 11, 47, " + Integer.parseInt(ASPV_adet_m.getText()) + ", 1)\n");
            bw.write("INSERT INTO oc_product_option_value(product_option_value_id,product_option_id,product_id,option_id,option_value_id,quantity,subtract) VALUES(" + (res + 3000) + ", " + (res + 4000) + ", " + res + ", 11, 48, " + Integer.parseInt(ASPV_adet_l.getText()) + ", 1)\n");
            bw.write("INSERT INTO oc_product_to_category(product_id, category_id) VALUES(" + res + ",  61)\n");
            bw.write("INSERT INTO oc_product_to_store(product_id, store_id) VALUES(" + res + ",  0)\n");

            System.out.print("Yazdım");
            bw.close();


            frame.main_anapanel.removeAll();
            frame.main_anapanel.add(new TempAddStockView(frame));
            frame.main_anapanel.validate();

        } catch (IOException ex) {
            Logger.getLogger(AddStockPanelView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AEV_ekleActionPerformed
    private void ASPV_gozatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASPV_gozatActionPerformed
        String s;
        JFileChooser jfc = new JFileChooser();
        jfc.showDialog(jfc, "Choose an image file");
        s = jfc.getSelectedFile().getAbsolutePath();
        File f = new File(s);
        String name = f.getName();
        if (first_image == null) {
            first_image = name;
        }

        try {
            if (is_product_empty) {
                res = 1000;
            } else {
                res = DBController.getLastID("SELECT * FROM product order by product_id DESC");
            }

            res++;

            
            Main.write("INSERT INTO oc_product_image(product_id,image,sort_order) VALUES(" + res + ", 'data/" + name + "',0)\n");
            dbController.insProductDB("INSERT INTO product_image(product_image_id,product_id,image,sort_order) VALUES(" + (res + 5000) + "," + res + ", 'data/" + name + "',0)\n");
            

            oout_image = new FileWriter(Main.file1, true);
            BufferedWriter bw_image = new BufferedWriter(oout_image);
            bw_image.write(s + "\n");
            bw_image.close();



        } catch (IOException ex) {
            Logger.getLogger(AddStockPanelView.class
                    .getName()).log(Level.SEVERE, null, ex);
        }



        ASPV_resim_list.append(s + "\n");

    }//GEN-LAST:event_ASPV_gozatActionPerformed

    private void AEV_listeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AEV_listeActionPerformed
    }//GEN-LAST:event_AEV_listeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AEV_ekle;
    private javax.swing.JButton AEV_liste;
    private javax.swing.JTextArea ASPV_aciklama;
    private javax.swing.JTextField ASPV_adet_l;
    private javax.swing.JTextField ASPV_adet_m;
    private javax.swing.JTextField ASPV_adet_s;
    private javax.swing.JTextField ASPV_agirlik;
    private javax.swing.JTextField ASPV_etiketler;
    private javax.swing.JTextField ASPV_fiyat;
    private javax.swing.JButton ASPV_gozat;
    private javax.swing.JTextField ASPV_isim;
    private javax.swing.JTextField ASPV_kod;
    private javax.swing.JComboBox ASPV_listele;
    private javax.swing.JTextField ASPV_minimum;
    private javax.swing.JTextArea ASPV_resim_list;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
