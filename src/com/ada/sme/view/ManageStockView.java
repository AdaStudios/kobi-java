/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.view;

import com.ada.sme.controller.DBController;
import com.ada.sme.controller.ManageEmployeeController;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.derby.drda.NetworkServerControl;

/**
 *
 * @author PaDaWaN
 */
public class ManageStockView extends javax.swing.JPanel {

    /**
     * Creates new form ManageEmployeeView
     */
    
    public ManageStockView() {
        initComponents();
        
        DBController dbController = new DBController();
        DefaultTableModel dtm;
        
        dtm=dbController.selectDB("SELECT product.product_id,name,model,quantity,price,status FROM product, product_description WHERE product.product_id = product_description.product_id");
        System.out.println(dtm);
        
        MSV_list1.setModel(dtm);
        
        ArrayList meta = dbController.fillCombo("SELECT product.product_id, product.model, product_description.name FROM product, product_description");
        
        MSV_identifier.addItem(meta.get(0).toString());
        MSV_identifier.addItem(meta.get(1).toString());
        MSV_identifier.addItem(meta.get(2).toString());
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

        MEV_value = new javax.swing.JTextField();
        MSV_ara = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        MSV_list1 = new javax.swing.JTable();
        MSV_identifier = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(227, 227, 227));
        setMaximumSize(new java.awt.Dimension(646, 500));
        setMinimumSize(new java.awt.Dimension(646, 500));
        setPreferredSize(new java.awt.Dimension(646, 500));
        setLayout(new java.awt.GridBagLayout());

        MEV_value.setMaximumSize(new java.awt.Dimension(100, 28));
        MEV_value.setMinimumSize(new java.awt.Dimension(100, 28));
        MEV_value.setPreferredSize(new java.awt.Dimension(100, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 12, 0, 0);
        add(MEV_value, gridBagConstraints);

        MSV_ara.setBackground(new java.awt.Color(67, 149, 195));
        MSV_ara.setForeground(new java.awt.Color(254, 254, 254));
        MSV_ara.setText("Ürün Ara");
        MSV_ara.setMaximumSize(new java.awt.Dimension(120, 35));
        MSV_ara.setMinimumSize(new java.awt.Dimension(120, 35));
        MSV_ara.setPreferredSize(new java.awt.Dimension(120, 35));
        MSV_ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSV_araActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(MSV_ara, gridBagConstraints);

        MSV_list1.setModel(MSV_list1.getModel());
        MSV_list1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MSV_list1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(MSV_list1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(MSV_identifier, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void MSV_list1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MSV_list1MouseClicked
        String id = MSV_list1.getValueAt(MSV_list1.getSelectedRow(), 0).toString();
        UpdateStockPanelView updateStockPanelView=new UpdateStockPanelView(id);
        MainFrame.main_anapanel.removeAll();
        MainFrame.main_anapanel.add(updateStockPanelView);
        MainFrame.main_anapanel.validate();
        
    }//GEN-LAST:event_MSV_list1MouseClicked

    private void MSV_araActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSV_araActionPerformed
        DBController dbController = new DBController();
        DefaultTableModel dtm;
        if(MSV_identifier.getSelectedItem().toString().equalsIgnoreCase("product_id"))
            dtm=dbController.selectDB("SELECT product.product_id,name,model,quantity,price,status FROM product, product_description WHERE "+" product."+MSV_identifier.getSelectedItem().toString()+"=product_description."+MSV_identifier.getSelectedItem().toString()+" AND product."+MSV_identifier.getSelectedItem().toString()+"="+MEV_value.getText());
        else
            dtm=dbController.selectDB("SELECT product.product_id,name,model,quantity,price,status FROM product, product_description WHERE "+" product.product_id=product_description.product_id AND "+MSV_identifier.getSelectedItem().toString()+" LIKE '%"+MEV_value.getText()+"%'");
        
        System.out.println(dtm);
        MSV_list1.setModel(dtm);
    }//GEN-LAST:event_MSV_araActionPerformed

    private void MSV_list2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MSV_list2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MSV_list2MouseClicked

    private void MSV_list3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MSV_list3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MSV_list3MouseClicked

    private void MSV_list4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MSV_list4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MSV_list4MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField MEV_value;
    private javax.swing.JButton MSV_ara;
    private javax.swing.JComboBox MSV_identifier;
    private javax.swing.JTable MSV_list1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
