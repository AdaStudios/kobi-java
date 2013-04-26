/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.view;

import com.ada.sme.model.StatusModel;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author PaDaWaN
 */
public class MainFrame extends javax.swing.JFrame {

    StatusModel sm;
    static int pingFlag = 0;
    final int SLEEPTIME = 5000;
    final String IPADDRESS = "139.179.139.112";

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        main_solpanel.removeAll();
        main_solpanel.add(new StoreLeftPanelView(this));
        sm = new StatusModel(IPADDRESS);

       // new Thread(new runCheck()).start();



    }

    public void setLeftPanel(JPanel p) {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_durum = new javax.swing.JButton();
        main_magaza = new javax.swing.JButton();
        main_online_market = new javax.swing.JButton();
        main_bildirim = new javax.swing.JButton();
        main_stok = new javax.swing.JButton();
        main_destek = new javax.swing.JButton();
        main_solpanel = new javax.swing.JPanel();
        main_anapanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        main_durum.setText("Durum");
        main_durum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                main_durumActionPerformed(evt);
            }
        });

        main_magaza.setText("Mağaza");
        main_magaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                main_magazaActionPerformed(evt);
            }
        });

        main_online_market.setText("Online Market");

        main_bildirim.setText("Bildirimler");

        main_stok.setText("Stok");
        main_stok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                main_stokActionPerformed(evt);
            }
        });

        main_destek.setText("Destek");

        main_solpanel.setLayout(new java.awt.CardLayout());

        main_anapanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(main_durum, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(main_magaza, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(main_online_market, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(main_bildirim, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(main_stok, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(main_destek, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 292, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(main_solpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(main_anapanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(main_durum)
                    .addComponent(main_magaza)
                    .addComponent(main_online_market)
                    .addComponent(main_bildirim)
                    .addComponent(main_stok)
                    .addComponent(main_destek))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(main_anapanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE)
                    .addComponent(main_solpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void main_durumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_main_durumActionPerformed
    }//GEN-LAST:event_main_durumActionPerformed

    private void main_magazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_main_magazaActionPerformed
        main_solpanel.removeAll();
        main_solpanel.add(new StoreLeftPanelView(this));
        main_solpanel.validate();
        
        main_anapanel.removeAll();
        main_anapanel.add(new ManageEmployeeView());
        main_anapanel.validate();
    }//GEN-LAST:event_main_magazaActionPerformed

    private void main_stokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_main_stokActionPerformed
        main_solpanel.removeAll();
        main_solpanel.add(new StockLeftPanelView(this));
        main_solpanel.validate();
        
        main_anapanel.removeAll();
        main_anapanel.add(new ManageStockView());
        main_anapanel.validate();
    }//GEN-LAST:event_main_stokActionPerformed

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
  /*      try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
     /*   java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               /* MainFrame mf = new MainFrame();

                mf.setVisible(true);*/


     /*       }
        });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel main_anapanel;
    private javax.swing.JButton main_bildirim;
    private javax.swing.JButton main_destek;
    private javax.swing.JButton main_durum;
    private javax.swing.JButton main_magaza;
    private javax.swing.JButton main_online_market;
    private javax.swing.JPanel main_solpanel;
    private javax.swing.JButton main_stok;
    // End of variables declaration//GEN-END:variables

    class runCheck implements Runnable {

        @Override
        public void run() {
            String urlString = "http://ozguryazilim.bilkent.edu.tr/open/ping.php?id=22";
            URL url = null;
            URLConnection conn = null;
            InputStream is;
            try {
                url = new URL(urlString);
                
            } catch (Exception ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (true) {
                try {
                    sm.check();
                    boolean ans = sm.getStatus();

                    if (ans) {
                        System.out.println("ulasiliyor");

                    } else if (!ans) {
                        System.out.println("ulasilmiyor");
                    }


                    if((pingFlag%4)==0){
                    conn = url.openConnection();
                    is = conn.getInputStream();
                    }

                    Thread.sleep(SLEEPTIME);
                    pingFlag++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}