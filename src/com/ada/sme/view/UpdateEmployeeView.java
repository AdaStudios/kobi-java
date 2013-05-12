/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.view;

/**
 *
 * @author PaDaWaN
 */
import com.ada.sme.controller.*;
import com.ada.sme.main.Main;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UpdateEmployeeView extends javax.swing.JPanel {

    /**
     * Creates new form UpdateEmployeeView
     */
    ArrayList res;

    public UpdateEmployeeView(String id) {
        initComponents();

        DBController dbController = new DBController();

        res = dbController.selectSingleRowDB("SELECT * FROM employee WHERE id=" + id);

        UEV_isim.setText((String) res.get(1));
        UEV_soyad.setText((String) res.get(2));
        UEV_kullaniciadi.setText((String) res.get(3));
        UEV_sifre.setText((String) res.get(4));
    }

    public boolean validateInputs(int a){
        //two buttons Guncelle , Çalışanı Sil
        //UEV_update ---> 1
        //UEV_delete ---> 2
        
        if(a==1){
            //rules
            //türkçe karakter yok
            //isim soyad ve kullanıcı adı 4-12 karakter ve küçük büyük harfler
            //parola 5-14 karakter özel karakterler, numeric alfa numerik karakterler
            if(UEV_isim.getText().matches("^[a-zA-Z]{4,12}$") &&
               UEV_soyad.getText().matches("^[a-zA-Z]{4,12}$") &&
               UEV_kullaniciadi.getText().matches("^[a-zA-Z]{4,12}$") &&
               UEV_sifre.getText().matches("^(?=.*\\d)(?=.*[a-zA-Z]).{4,12}$")   ){ 
                return true;
            }else
            {
                return false;
            }
        } else if (a==2){
            //rules
            //türkçe karakter yok
            // isim ve kullanıcı adı 4-12 karakter küçük büyük harflerden olmalı
            if( UEV_isim.getText().matches("^[a-zA-Z]{4,12}$") && 
                UEV_kullaniciadi.getText().matches("^[a-zA-Z]{4,12}$") ){
            return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        UEV_isim = new javax.swing.JTextField();
        UEV_soyad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        UEV_kullaniciadi = new javax.swing.JTextField();
        UEV_sifre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        UEV_update = new javax.swing.JButton();
        UEV_delete = new javax.swing.JButton();
        UEV_geri = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 15), new java.awt.Dimension(0, 15), new java.awt.Dimension(32767, 15));

        setBackground(new java.awt.Color(227, 227, 227));
        setMaximumSize(new java.awt.Dimension(646, 500));
        setMinimumSize(new java.awt.Dimension(646, 500));
        setPreferredSize(new java.awt.Dimension(646, 500));
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 2, 0, 2, 0};
        layout.rowHeights = new int[] {0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0};
        setLayout(layout);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Çalışanın Bilgilerini Güncelle");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 55, 0, 0);
        add(jLabel1, gridBagConstraints);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Çalışan İsmi:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        add(jLabel3, gridBagConstraints);

        UEV_isim.setMaximumSize(new java.awt.Dimension(170, 28));
        UEV_isim.setMinimumSize(new java.awt.Dimension(170, 28));
        UEV_isim.setPreferredSize(new java.awt.Dimension(170, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        add(UEV_isim, gridBagConstraints);

        UEV_soyad.setMaximumSize(new java.awt.Dimension(170, 28));
        UEV_soyad.setMinimumSize(new java.awt.Dimension(170, 28));
        UEV_soyad.setPreferredSize(new java.awt.Dimension(170, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        add(UEV_soyad, gridBagConstraints);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Çalışan Soyadı:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        add(jLabel4, gridBagConstraints);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Kullanıcı Adı:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        add(jLabel5, gridBagConstraints);

        UEV_kullaniciadi.setMaximumSize(new java.awt.Dimension(170, 28));
        UEV_kullaniciadi.setMinimumSize(new java.awt.Dimension(170, 28));
        UEV_kullaniciadi.setPreferredSize(new java.awt.Dimension(170, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        add(UEV_kullaniciadi, gridBagConstraints);

        UEV_sifre.setMaximumSize(new java.awt.Dimension(170, 28));
        UEV_sifre.setMinimumSize(new java.awt.Dimension(170, 28));
        UEV_sifre.setPreferredSize(new java.awt.Dimension(170, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        add(UEV_sifre, gridBagConstraints);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Şifre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        add(jLabel6, gridBagConstraints);

        UEV_update.setBackground(new java.awt.Color(67, 149, 195));
        UEV_update.setForeground(new java.awt.Color(254, 254, 254));
        UEV_update.setText("Güncelle");
        UEV_update.setMaximumSize(new java.awt.Dimension(170, 35));
        UEV_update.setMinimumSize(new java.awt.Dimension(170, 35));
        UEV_update.setPreferredSize(new java.awt.Dimension(170, 35));
        UEV_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UEV_updateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        add(UEV_update, gridBagConstraints);

        UEV_delete.setBackground(new java.awt.Color(67, 149, 195));
        UEV_delete.setForeground(new java.awt.Color(254, 254, 254));
        UEV_delete.setText("Çalışanı Sil");
        UEV_delete.setMaximumSize(new java.awt.Dimension(170, 35));
        UEV_delete.setMinimumSize(new java.awt.Dimension(170, 35));
        UEV_delete.setPreferredSize(new java.awt.Dimension(170, 35));
        UEV_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UEV_deleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        add(UEV_delete, gridBagConstraints);

        UEV_geri.setBackground(new java.awt.Color(67, 149, 195));
        UEV_geri.setForeground(new java.awt.Color(254, 254, 254));
        UEV_geri.setText("Geri");
        UEV_geri.setMaximumSize(new java.awt.Dimension(90, 35));
        UEV_geri.setMinimumSize(new java.awt.Dimension(90, 35));
        UEV_geri.setPreferredSize(new java.awt.Dimension(90, 35));
        UEV_geri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UEV_geriActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 4);
        add(UEV_geri, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        add(filler1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void UEV_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UEV_updateActionPerformed

        if(validateInputs(1)){
            DBController dbController = new DBController();
            dbController.empInsDelUpDB("UPDATE employee SET name='" + UEV_isim.getText() + "', surname='" + UEV_soyad.getText() + "', username='" + UEV_kullaniciadi.getText() + "', password='" + UEV_sifre.getText() + "' WHERE id=" + String.valueOf(res.get(0)));
            Main.logger(UEV_isim.getText() + " " + UEV_soyad.getText() + " kullanıcısı düzenlendi.");
        
            MainFrame.main_anapanel.removeAll();
            MainFrame.main_anapanel.add(new ManageEmployeeView());
            MainFrame.main_anapanel.validate();
        } else {
            //REGEX geçemedi
            JOptionPane.showMessageDialog(null,"Lütfen girmiş olduğunuz alanları kontrol ediniz.\n"
                  + "Kurallar:\n"
                    + "Türkçe karakter kullanmayınız (ş,ç,ı,ü,ğ,ö,İ,Ş,Ç,Ö,Ğ,Ü)\n"
                  + "İsim , Soyad ve Kullanıcı adı 4-12 karakter ve sadece küçük büyük harfler olabilir,\n"
                    + "Şifre 4-12 karakter küçük büyük harfler, rakamlar ve özel karakterler  olabilir.\n"
                    + "en az 1 sayı içermesi gerekir.",
                  "Hatalı Giriş Yaptınız!!!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_UEV_updateActionPerformed

    private void UEV_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UEV_deleteActionPerformed
      if(validateInputs(2)){
        DBController dbController = new DBController();
        dbController.empInsDelUpDB("DELETE FROM employee WHERE id=" + String.valueOf(res.get(0)));
        Main.logger(UEV_isim.getText() + " " + UEV_soyad.getText() + " kullanıcısı silindi.");
        
        MainFrame.main_anapanel.removeAll();
        MainFrame.main_anapanel.add(new ManageEmployeeView());
        MainFrame.main_anapanel.validate();
      } else {
          //REGEX i geçemedi
          JOptionPane.showMessageDialog(null,"Lütfen girmiş olduğunuz alanları kontrol ediniz.\n"
                  + "Kurallar:\n"
                  + "Türkçe karakter kullanmayınız (ş,ç,ı,ü,ğ,ö,İ,Ş,Ç,Ö,Ğ,Ü)\n"
                  + "Lütfen girdiğiniz Kullannıcı Adını kontrol ediniz.",
                  "Hatalı Giriş Yaptınız!!!",JOptionPane.WARNING_MESSAGE);
      }
    }//GEN-LAST:event_UEV_deleteActionPerformed

    private void UEV_geriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UEV_geriActionPerformed
        MainFrame.main_anapanel.removeAll();
        MainFrame.main_anapanel.add(new ManageEmployeeView());
        MainFrame.main_anapanel.validate();
    }//GEN-LAST:event_UEV_geriActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UEV_delete;
    private javax.swing.JButton UEV_geri;
    private javax.swing.JTextField UEV_isim;
    private javax.swing.JTextField UEV_kullaniciadi;
    private javax.swing.JTextField UEV_sifre;
    private javax.swing.JTextField UEV_soyad;
    private javax.swing.JButton UEV_update;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
