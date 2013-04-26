/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.view;

import com.ada.sme.controller.DBController;
import java.util.ArrayList;

/**
 *
 * @author PaDaWaN
 */
public class UpdateStockPanelView extends javax.swing.JPanel {

    /**
     * Creates new form AddStockPanelView
     */
    
    int res;
    String pro_id;
    public UpdateStockPanelView(String id) {
        initComponents();
        DBController dbController=new DBController();
        ArrayList res;
        res = dbController.selectSingleRowDB("SELECT model,image,weight,minimum,status,price FROM product WHERE product_id="+id);
        USPV_kod.setText(res.get(0).toString());
        USPV_resim.setText(res.get(1).toString());        
        USPV_agirlik.setText(res.get(2).toString());
        USPV_minimum.setText(res.get(3).toString());
        USPV_listele.setSelectedIndex(Integer.parseInt(res.get(4).toString()));
        USPV_fiyat.setText(res.get(5).toString());
        
        res = dbController.selectSingleRowDB("SELECT name,description,tag FROM product_description WHERE product_id="+id);
        USPV_isim.setText(res.get(0).toString());
        USPV_aciklama.setText(res.get(1).toString());
        USPV_etiketler.setText(res.get(2).toString());
        
        res = dbController.selectSingleRowDB("SELECT quantity FROM product_option_value WHERE option_value_id=46 and product_id="+id);
        USPV_adet_s.setText(res.get(0).toString());
        res = dbController.selectSingleRowDB("SELECT quantity FROM product_option_value WHERE option_value_id=47 and product_id="+id);
        USPV_adet_m.setText(res.get(0).toString());
        res = dbController.selectSingleRowDB("SELECT quantity FROM product_option_value WHERE option_value_id=48 and product_id="+id);
        USPV_adet_l.setText(res.get(0).toString());
        
        pro_id=id;
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
        jLabel2 = new javax.swing.JLabel();
        USPV_kod = new javax.swing.JTextField();
        USPV_isim = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        USPV_fiyat = new javax.swing.JTextField();
        USPV_adet_s = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        USPV_resim = new javax.swing.JTextField();
        USPV_guncelle = new javax.swing.JButton();
        USPV_sil = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        USPV_adet_l = new javax.swing.JTextField();
        USPV_adet_m = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        USPV_agirlik = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        USPV_minimum = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        USPV_listele = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        USPV_aciklama = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        USPV_etiketler = new javax.swing.JTextArea();
        USPV_sil1 = new javax.swing.JButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ürün bilgilerini Güncelle");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Ürün Kodu:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Ürün İsmi:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Ürün Fiyatı:");

        USPV_adet_s.setText("0");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Ürün Adeti:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Ürün Resmi:");

        USPV_guncelle.setText("Güncelle");
        USPV_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USPV_guncelleActionPerformed(evt);
            }
        });

        USPV_sil.setText("Ürünü Sil");
        USPV_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USPV_silActionPerformed(evt);
            }
        });

        jLabel7.setText("Small");
        jLabel7.setToolTipText("");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel8.setText("Medium");

        jLabel9.setText("Large");
        jLabel9.setToolTipText("");

        USPV_adet_l.setText("0");

        USPV_adet_m.setText("0");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Ürün Ağırlığı(Gr):");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Minimum:");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Ürünü Listele:");

        USPV_listele.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PASİF", "AKTİF" }));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Açıklama:");

        USPV_aciklama.setColumns(20);
        USPV_aciklama.setRows(5);
        jScrollPane1.setViewportView(USPV_aciklama);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Etiketler:");

        USPV_etiketler.setColumns(20);
        USPV_etiketler.setRows(5);
        jScrollPane2.setViewportView(USPV_etiketler);

        USPV_sil1.setText("Geri");
        USPV_sil1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USPV_sil1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(USPV_minimum, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(USPV_agirlik, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(USPV_listele, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(191, 191, 191))
                                    .addComponent(jScrollPane1)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(USPV_fiyat, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(USPV_isim, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(USPV_kod, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(USPV_resim, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(USPV_adet_s, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(USPV_adet_m)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(21, 21, 21))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(USPV_adet_l)
                                                .addGap(18, 18, 18))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(USPV_guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(USPV_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(USPV_sil1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(USPV_kod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(USPV_isim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(USPV_fiyat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USPV_adet_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(USPV_adet_l, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(USPV_adet_m, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USPV_resim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USPV_agirlik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USPV_minimum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(USPV_listele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USPV_guncelle)
                    .addComponent(USPV_sil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(USPV_sil1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void USPV_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USPV_guncelleActionPerformed
        
        DBController dbController= new DBController();
        int total= Integer.parseInt(USPV_adet_s.getText())+Integer.parseInt(USPV_adet_m.getText())+Integer.parseInt(USPV_adet_l.getText());
        dbController.insDelUpDB("UPDATE product SET model='"+USPV_kod.getText()+"', price="+USPV_fiyat.getText()+", quantity="+String.valueOf(total)+", image='"+USPV_resim.getText()+"', weight="+USPV_agirlik.getText()+", minimum="+USPV_minimum.getText()+", status="+USPV_listele.getSelectedIndex()+" WHERE product_id="+pro_id);
        dbController.insDelUpDB("UPDATE product_description SET description='"+USPV_aciklama.getText()+"', tag='"+USPV_etiketler.getText()+"', name='"+USPV_isim.getText()+"' WHERE product_id="+pro_id);
        dbController.insDelUpDB("UPDATE product_option_value SET quantity="+USPV_adet_s.getText()+" WHERE product_id="+pro_id+" and option_value_id=46");
        dbController.insDelUpDB("UPDATE product_option_value SET quantity="+USPV_adet_m.getText()+" WHERE product_id="+pro_id+" and option_value_id=47");
        dbController.insDelUpDB("UPDATE product_option_value SET quantity="+USPV_adet_l.getText()+" WHERE product_id="+pro_id+" and option_value_id=48");
   
    }//GEN-LAST:event_USPV_guncelleActionPerformed

    private void USPV_sil1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USPV_sil1ActionPerformed
        MainFrame.main_anapanel.removeAll();
        MainFrame.main_anapanel.add(new ManageStockView());
        MainFrame.main_anapanel.validate();
    }//GEN-LAST:event_USPV_sil1ActionPerformed

    private void USPV_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USPV_silActionPerformed
        DBController dbController = new DBController();
        dbController.insDelUpDB("DELETE FROM product WHERE product_id="+pro_id);
        dbController.insDelUpDB("DELETE FROM product_description WHERE product_id="+pro_id);
        dbController.insDelUpDB("DELETE FROM product_option WHERE product_id="+pro_id);
        dbController.insDelUpDB("DELETE FROM product_option_value WHERE product_id="+pro_id);
        dbController.insDelUpDB("DELETE FROM product_to_category WHERE product_id="+pro_id);
        
        
        MainFrame.main_anapanel.removeAll();
        MainFrame.main_anapanel.add(new ManageStockView());
        MainFrame.main_anapanel.validate();
    }//GEN-LAST:event_USPV_silActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea USPV_aciklama;
    private javax.swing.JTextField USPV_adet_l;
    private javax.swing.JTextField USPV_adet_m;
    private javax.swing.JTextField USPV_adet_s;
    private javax.swing.JTextField USPV_agirlik;
    private javax.swing.JTextArea USPV_etiketler;
    private javax.swing.JTextField USPV_fiyat;
    private javax.swing.JButton USPV_guncelle;
    private javax.swing.JTextField USPV_isim;
    private javax.swing.JTextField USPV_kod;
    private javax.swing.JComboBox USPV_listele;
    private javax.swing.JTextField USPV_minimum;
    private javax.swing.JTextField USPV_resim;
    private javax.swing.JButton USPV_sil;
    private javax.swing.JButton USPV_sil1;
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
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}