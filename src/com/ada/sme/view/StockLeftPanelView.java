/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PaDaWaN
 */
public class StockLeftPanelView extends javax.swing.JPanel {

    /**
     * Creates new form StatusLeftPanelView
     */
    MainFrame frame;
    public StockLeftPanelView(MainFrame main) {
        initComponents();
        frame= main;
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

        SLPV_ekle = new javax.swing.JButton();
        SLPV_yonet = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 22), new java.awt.Dimension(0, 22), new java.awt.Dimension(32767, 22));
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(227, 227, 227));
        setForeground(new java.awt.Color(254, 254, 254));
        setMaximumSize(new java.awt.Dimension(146, 2000));
        setMinimumSize(new java.awt.Dimension(146, 550));
        setPreferredSize(new java.awt.Dimension(146, 500));
        setLayout(new java.awt.GridBagLayout());

        SLPV_ekle.setBackground(new java.awt.Color(67, 149, 195));
        SLPV_ekle.setForeground(new java.awt.Color(254, 254, 254));
        SLPV_ekle.setText("Ürün Ekle");
        SLPV_ekle.setMaximumSize(new java.awt.Dimension(146, 80));
        SLPV_ekle.setMinimumSize(new java.awt.Dimension(146, 80));
        SLPV_ekle.setPreferredSize(new java.awt.Dimension(146, 80));
        SLPV_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SLPV_ekleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        add(SLPV_ekle, gridBagConstraints);

        SLPV_yonet.setBackground(new java.awt.Color(67, 149, 195));
        SLPV_yonet.setForeground(new java.awt.Color(254, 254, 254));
        SLPV_yonet.setText("Ürünleri Yönet");
        SLPV_yonet.setMaximumSize(new java.awt.Dimension(146, 80));
        SLPV_yonet.setMinimumSize(new java.awt.Dimension(146, 80));
        SLPV_yonet.setPreferredSize(new java.awt.Dimension(146, 80));
        SLPV_yonet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SLPV_yonetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        add(SLPV_yonet, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        add(filler1, gridBagConstraints);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Stok");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 1.0;
        add(jLabel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void SLPV_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SLPV_ekleActionPerformed
        frame.main_anapanel.removeAll();
        try {
            frame.main_anapanel.add(new AddStockPanelView());
        } catch (IOException ex) {
            Logger.getLogger(StockLeftPanelView.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.main_anapanel.validate();
    }//GEN-LAST:event_SLPV_ekleActionPerformed

    private void SLPV_yonetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SLPV_yonetActionPerformed
        frame.main_anapanel.removeAll();
        frame.main_anapanel.add(new ManageStockView());
        frame.main_anapanel.validate();
        
    }//GEN-LAST:event_SLPV_yonetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SLPV_ekle;
    private javax.swing.JButton SLPV_yonet;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
