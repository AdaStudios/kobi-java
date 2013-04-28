/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.view;

import com.ada.sme.controller.DBController;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author osman
 */
public class OrderView extends javax.swing.JFrame {
 DefaultTableModel dtm;
 DBController dbController;
 DefaultTableModel meta;
  ArrayList all;
    /**
     * Creates new form OrderView
     */
    public OrderView(String id) {
        initComponents();
        
        //open frame at the center of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        dbController = new DBController(); 
        updateOrderProduct();
        updateOrderOption();
        
        all = dbController.selectSingleRowDB("SELECT * FROM order_t, order_status WHERE order_language=1 AND order_t.order_status_id=order_status.order_status_id AND order_t.order_id="+id);
        System.err.println(all.size()+": all list");
        dtm = dbController.selectDB("Select name,model,quantity,price,total from order_product WHERE order_id="+all.get(0).toString());
        Object[] cols = new Object[5];
        cols[0]="Ürün Adı";
        cols[1]="Model";
        cols[2]="Adet";
        cols[3]="Fiyat";
        cols[4]="Toplam";
        dtm.setColumnIdentifiers(cols);
         
         MEV_list1.setModel(dtm);    
         
         updateOrderOption();
         
         dtm=dbController.selectDB("SELECT model, value FROM order_product, order_option WHERE order_product.order_product_id=order_option.order_product_id AND order_product.order_id="+all.get(0).toString());
         MEV_list.setModel(dtm);
         
         double total = 0;
         for (int i = 0; i < MEV_list1.getRowCount(); i++) {
             total+= Double.valueOf(MEV_list1.getValueAt(i,4).toString());
         }
           jLabel28.setText(total+"");
           total+=7;
           jLabel34.setText(total+"");
           jLabel32.setText(all.get(34).toString());
           
        // MEV_list.getValueAt(WIDTH, WIDTH)
         
         jLabel12.setText(all.get(0).toString());
         jLabel11.setText(all.get(31).toString());
         jLabel17.setText(all.get(7).toString()+" "+all.get(8).toString() );
         jLabel18.setText(all.get(9).toString());
         jLabel19.setText(all.get(10).toString()+" "+all.get(11).toString());
         jLabel20.setText(all.get(13).toString()+" "+all.get(12).toString()+" "+all.get(15).toString());
         jLabel13.setText(all.get(16).toString());
         jLabel21.setText(all.get(4).toString());
         jLabel22.setText(all.get(5).toString());
         jLabel10.setText(all.get(6).toString());
         
         jLabel23.setText(all.get(17).toString()+" "+all.get(18).toString() );
         jLabel24.setText(all.get(19).toString());
         jLabel25.setText(all.get(20).toString()+" "+all.get(21).toString());
         jLabel26.setText(all.get(23).toString()+" "+all.get(22).toString()+" "+all.get(25).toString());
         
       
        meta = dbController.selectDB("Select order_status_id, name from order_status");
        
        for (int i = 0; i < meta.getRowCount(); i++) {
            jComboBox1.addItem(meta.getValueAt(i,1).toString());
        }
        
       
        // jLabel32.setText(all.get(37).toString());
        
       /*  jLabel34.setText(all.get(39).toString());*/
         
    }
    
    public void updateOrderProduct(){        
        
        dtm=dbController.selectDB("SELECT * FROM order_product");
       // System.out.println(dtm.getValueAt(12, 0));
        System.out.println("firstSelect");
        if(dtm.getRowCount()==0){
       // dtm = dbController.selectDBFromOnline("Select * from oc_order_product");
            System.out.println("BOŞ!!!\n\n");
         dbController.updateOrderProductDBFromOnline("SELECT * FROM oc_order_product");
        }else{
             int id2 = DBController.getLastID("SELECT order_product_id from order_product order by order_product_id DESC");
             System.out.println(id2+"Last id\n\n");
            
           dbController.updateOrderProductDBFromOnline("Select * from oc_order_product WHERE order_product_id>"+id2);          
        }
    }
    
    public void updateOrderOption(){        
        
        dtm=dbController.selectDB("SELECT * FROM order_option");

        if(dtm.getRowCount()==0){
         dbController.updateOrderOptionDBFromOnline("SELECT order_option_id, order_id, order_product_id,name,value FROM oc_order_option");
        }else{
             int id2 = DBController.getLastID("SELECT order_option_id from order_option order by order_option_id DESC");
             System.out.println(id2+"Option Last Id\n\n");
            
           dbController.updateOrderOptionDBFromOnline("Select order_option_id, order_id, order_product_id, name, value FROM oc_order_option WHERE order_option_id>"+id2);          
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MEV_list = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        MEV_list1 = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Meşrutiyet Cad. Kızılay No:32 Çankaya/Ankara");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel3.setText("(0312) 290 40 64");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel4.setText("www.magazam.com");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel5.setText("magazam@magazam.com");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setText("Ekleme Tarihi:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, -1));

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel8.setText("Sipariş No:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, -1, -1));

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel9.setText("KARGO ADRESİ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, -1, -1));

        jLabel10.setText("fax");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        jLabel11.setText("2013");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, -1, -1));

        jLabel12.setText("0");
        jLabel12.setMinimumSize(new java.awt.Dimension(500, 500));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, -1, -1));

        jLabel13.setText("Kapıda");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, -1, -1));

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel14.setText("Ödeme Methodu");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        jLabel15.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel15.setText("FATURA ADRESİ");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel16.setText("Örnek Mağaza");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel17.setText("Ad Soyad");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel18.setText("İşyeri");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel19.setText("adress1");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel20.setText("city/zone/postcode");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel21.setText("mail");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        jLabel22.setText("tel");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jLabel23.setText("Ad Soyad");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, -1));

        jLabel24.setText("İşyeri");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, -1, -1));

        jLabel25.setText("adress1");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, -1, -1));

        jLabel26.setText("city/zone/postcode");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, -1, -1));

        MEV_list.setEnabled(false);
        MEV_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MEV_listMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(MEV_list);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, 230, 120));

        jLabel27.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel27.setText("Ara Toplam:");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, -1, -1));

        jLabel28.setText("0");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, -1, -1));

        jLabel30.setText("7");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 500, -1, -1));

        jLabel29.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel29.setText("Kargo:");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, -1, -1));

        jLabel34.setText("0");
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, -1, -1));

        jLabel33.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel33.setText("Toplam");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, -1, -1));

        MEV_list1.setEnabled(false);
        MEV_list1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MEV_list1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(MEV_list1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 600, 120));

        jLabel31.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel31.setText("Kargo Durumu Değiştir:");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, -1, -1));

        jLabel32.setText("0");
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, -1, -1));

        jLabel35.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel35.setText("Kargo Durumu:");
        getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, -1, -1));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, 170, -1));

        jButton1.setText("Değiştir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 540, 170, -1));

        jButton2.setText("Çıkış");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 490, 140, 80));
    }// </editor-fold>//GEN-END:initComponents

    private void MEV_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MEV_listMouseClicked
       /* String id = MEV_list.getValueAt(MEV_list.getSelectedRow(), 0).toString();
        UpdateEmployeeView updateemployeeView=new UpdateEmployeeView(id);
        MainFrame.main_anapanel.removeAll();
        MainFrame.main_anapanel.add(updateemployeeView);
        MainFrame.main_anapanel.validate();*/
    }//GEN-LAST:event_MEV_listMouseClicked

    private void MEV_list1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MEV_list1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MEV_list1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int a = jComboBox1.getSelectedIndex();
        dbController.insProductDB("UPDATE order_t SET order_status_id="+meta.getValueAt(a, 0)+" WHERE order_id="+all.get(0).toString());
        jLabel32.setText(meta.getValueAt(a, 1).toString());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                // TODO add your handling code here:
        MainFrame.callOnlineAgain();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MEV_list;
    private javax.swing.JTable MEV_list1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
