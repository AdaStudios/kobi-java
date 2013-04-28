/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.view;

import com.ada.sme.controller.DBController;
import com.ada.sme.main.Main;
import com.ada.sme.model.StatusModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tvostro
 */
public class MainPagePanelView extends javax.swing.JPanel {

    /**
     * Creates new form MainPagePanelView
     */
    public static int store_status = 0;
    DBController dbc;

    public MainPagePanelView() {
        initComponents();
        DefaultTableModel dtm = new DefaultTableModel();
        dbc = new DBController();
        dtm = dbc.selectDB("Select * from log_table");
        jTable1.setModel(dtm);
        Object[] cols = new Object[3];
         cols[0]="Kullanıcı";
         cols[1]="Kayıt";
         cols[2]="Tarih";
         dtm.setColumnIdentifiers(cols);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(12, 0), new java.awt.Dimension(12, 0), new java.awt.Dimension(12, 32767));
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(227, 227, 227));
        setMaximumSize(new java.awt.Dimension(646, 500));
        setMinimumSize(new java.awt.Dimension(646, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mağaza");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 20, 130, -1));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 149, 20));
        jLabel3.setText("Sistem Aktivite Günlüğü");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 30));
        add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, -1));

        jButton1.setBackground(new java.awt.Color(67, 149, 195));
        jButton1.setForeground(new java.awt.Color(254, 254, 254));
        jButton1.setText("Aç");
        jButton1.setMaximumSize(new java.awt.Dimension(90, 35));
        jButton1.setMinimumSize(new java.awt.Dimension(90, 35));
        jButton1.setPreferredSize(new java.awt.Dimension(90, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 740, 370));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (store_status == 0) {
            if (StatusModel.check()) {
                dbc.insDelUpDB("UPDATE pingtable SET closed=0 WHERE clientid=22");
            } else {
                Main.write("UPDATE pingtable SET closed=0 WHERE clientid=22");
            }

            store_status = 1;
            jButton1.setText("KAPAT");
        } else {
            if (StatusModel.check()) {
                dbc.insDelUpDB("UPDATE pingtable SET closed=1 WHERE clientid=22");
            } else {
                Main.write("UPDATE pingtable SET closed=1 WHERE clientid=22");
            }
            
            jButton1.setText("AÇ");
            store_status = 0;
        }

    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
