/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.view;

import java.awt.event.ActionListener;
import com.ada.sme.model.*;
import java.awt.Color;
import com.ada.sme.controller.*;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author PaDaWaN
 */
public class LoginView extends javax.swing.JFrame {
    DBController dbController;
    
    public LoginView() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        dbController=new DBController();
       // dbController.insDelUpDB("INSERT INTO employee VALUES(1, 'riza', 'akbiyik', 'riza', 'riza')");
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        login_mesaj = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        login_kullanici = new javax.swing.JTextField();
        login_parola = new javax.swing.JPasswordField();
        login_cıkıs = new javax.swing.JButton();
        login_giris = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(227, 227, 227));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        login_mesaj.setColumns(20);
        login_mesaj.setRows(5);
        login_mesaj.setEnabled(false);
        jScrollPane1.setViewportView(login_mesaj);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Kullanıcı Adı:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Parola :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        login_kullanici.setText("riza");
        login_kullanici.setMaximumSize(new java.awt.Dimension(170, 28));
        login_kullanici.setMinimumSize(new java.awt.Dimension(170, 28));
        login_kullanici.setPreferredSize(new java.awt.Dimension(170, 28));
        login_kullanici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_kullaniciActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        getContentPane().add(login_kullanici, gridBagConstraints);

        login_parola.setText("riza");
        login_parola.setMaximumSize(new java.awt.Dimension(170, 28));
        login_parola.setMinimumSize(new java.awt.Dimension(170, 28));
        login_parola.setPreferredSize(new java.awt.Dimension(170, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        getContentPane().add(login_parola, gridBagConstraints);

        login_cıkıs.setBackground(new java.awt.Color(67, 149, 195));
        login_cıkıs.setForeground(new java.awt.Color(254, 254, 254));
        login_cıkıs.setText("Çıkış");
        login_cıkıs.setMaximumSize(new java.awt.Dimension(80, 50));
        login_cıkıs.setMinimumSize(new java.awt.Dimension(80, 50));
        login_cıkıs.setPreferredSize(new java.awt.Dimension(80, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 15, 0);
        getContentPane().add(login_cıkıs, gridBagConstraints);

        login_giris.setBackground(new java.awt.Color(67, 149, 195));
        login_giris.setForeground(new java.awt.Color(254, 254, 254));
        login_giris.setText("Giriş");
        login_giris.setMaximumSize(new java.awt.Dimension(41, 50));
        login_giris.setMinimumSize(new java.awt.Dimension(41, 50));
        login_giris.setPreferredSize(new java.awt.Dimension(41, 50));
        login_giris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_girisActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 15, 0);
        getContentPane().add(login_giris, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void login_kullaniciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_kullaniciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_login_kullaniciActionPerformed

    private void login_girisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_girisActionPerformed
        if(dbController.login(login_kullanici.getText(), login_parola.getText())){
            MainFrame frame=new MainFrame();
            frame.setSize(805, 600);
            frame.setVisible(true);
            this.setVisible(false);
        }else{
            login_mesaj.setForeground(Color.red);
            login_mesaj.setText("KULLANICI ADI VEYA PAROLA HATALI!");
        }
    }//GEN-LAST:event_login_girisActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton login_cıkıs;
    private javax.swing.JButton login_giris;
    private javax.swing.JTextField login_kullanici;
    private javax.swing.JTextArea login_mesaj;
    private javax.swing.JPasswordField login_parola;
    // End of variables declaration//GEN-END:variables
}
