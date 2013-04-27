/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.view;

import com.ada.sme.controller.DBController;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
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
    ArrayList<String> imageList;
    
    public AddStockPanelView() {
        initComponents();
        DBController dbController=new DBController();
        
        
        ArrayList a = dbController.selectSingleRowDB("select * from product");
        java.util.Date today = new java.util.Date();
        java.sql.Date sqlToday = new java.sql.Date(today.getTime());
        
        if (a.isEmpty())
            dbController.insDelUpDB("INSERT INTO product VALUES(1000, 'model', "
                + "0, 6, 'hebele', 1, "
                + "0, 9, '"+sqlToday+"' , 0, 2, 1, 1, "
                + "0, '"+sqlToday+"'  , '"+sqlToday+"' )");
        
        res = DBController.getLastID("SELECT * FROM product");
        imageList=new ArrayList<String>();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        ASPV_aciklama = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        ASPV_etiketler = new javax.swing.JTextField();
        ASPV_gozat = new javax.swing.JButton();

        setBackground(new java.awt.Color(227, 227, 227));
        setMaximumSize(new java.awt.Dimension(640, 470));
        setMinimumSize(new java.awt.Dimension(640, 470));
        setPreferredSize(new java.awt.Dimension(640, 470));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Yeni Ürün Ekle");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jLabel1, gridBagConstraints);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Ürün Kodu:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jLabel2, gridBagConstraints);

        ASPV_kod.setMaximumSize(new java.awt.Dimension(60, 28));
        ASPV_kod.setMinimumSize(new java.awt.Dimension(60, 28));
        ASPV_kod.setPreferredSize(new java.awt.Dimension(60, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(ASPV_kod, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 15);
        add(ASPV_isim, gridBagConstraints);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Ürün İsmi:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jLabel3, gridBagConstraints);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Ürün Fiyatı:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jLabel4, gridBagConstraints);

        ASPV_fiyat.setMaximumSize(new java.awt.Dimension(60, 28));
        ASPV_fiyat.setMinimumSize(new java.awt.Dimension(60, 28));
        ASPV_fiyat.setPreferredSize(new java.awt.Dimension(60, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(ASPV_fiyat, gridBagConstraints);

        ASPV_adet_s.setText("0");
        ASPV_adet_s.setMaximumSize(new java.awt.Dimension(60, 28));
        ASPV_adet_s.setMinimumSize(new java.awt.Dimension(60, 28));
        ASPV_adet_s.setPreferredSize(new java.awt.Dimension(60, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(ASPV_adet_s, gridBagConstraints);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Ürün Adeti:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jLabel5, gridBagConstraints);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Ürün Resmi:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jLabel6, gridBagConstraints);

        AEV_ekle.setText("Kaydet");
        AEV_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AEV_ekleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 10, 1);
        add(AEV_ekle, gridBagConstraints);

        AEV_liste.setText("Ürün Listesi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 10, 15);
        add(AEV_liste, gridBagConstraints);

        jLabel7.setText("Küçük");
        jLabel7.setToolTipText("");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jLabel7, gridBagConstraints);

        jLabel8.setText("Orta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jLabel8, gridBagConstraints);

        jLabel9.setText("Büyük");
        jLabel9.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jLabel9, gridBagConstraints);

        ASPV_adet_l.setText("0");
        ASPV_adet_l.setMaximumSize(new java.awt.Dimension(60, 28));
        ASPV_adet_l.setMinimumSize(new java.awt.Dimension(60, 28));
        ASPV_adet_l.setPreferredSize(new java.awt.Dimension(60, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(ASPV_adet_l, gridBagConstraints);

        ASPV_adet_m.setText("0");
        ASPV_adet_m.setMaximumSize(new java.awt.Dimension(60, 28));
        ASPV_adet_m.setMinimumSize(new java.awt.Dimension(60, 28));
        ASPV_adet_m.setPreferredSize(new java.awt.Dimension(60, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(ASPV_adet_m, gridBagConstraints);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Ürün Ağırlığı(Gr):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jLabel10, gridBagConstraints);

        ASPV_agirlik.setMaximumSize(new java.awt.Dimension(60, 28));
        ASPV_agirlik.setMinimumSize(new java.awt.Dimension(60, 28));
        ASPV_agirlik.setPreferredSize(new java.awt.Dimension(60, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(ASPV_agirlik, gridBagConstraints);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Minimum:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(1, 15, 1, 1);
        add(jLabel11, gridBagConstraints);

        ASPV_minimum.setMaximumSize(new java.awt.Dimension(60, 28));
        ASPV_minimum.setMinimumSize(new java.awt.Dimension(60, 28));
        ASPV_minimum.setPreferredSize(new java.awt.Dimension(60, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(ASPV_minimum, gridBagConstraints);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Ürünü Listele:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jLabel12, gridBagConstraints);

        ASPV_listele.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PASİF", "AKTİF" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(ASPV_listele, gridBagConstraints);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Açıklama:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jLabel13, gridBagConstraints);

        ASPV_aciklama.setColumns(20);
        ASPV_aciklama.setRows(5);
        jScrollPane1.setViewportView(ASPV_aciklama);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.8;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 15);
        add(jScrollPane1, gridBagConstraints);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Etiketler:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(jLabel14, gridBagConstraints);

        ASPV_etiketler.setToolTipText("ürünle ilgili etiketleri giriniz.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 15);
        add(ASPV_etiketler, gridBagConstraints);

        ASPV_gozat.setText("Gözat");
        ASPV_gozat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASPV_gozatActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        add(ASPV_gozat, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void AEV_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AEV_ekleActionPerformed
        
        java.util.Date today = new java.util.Date();
        java.sql.Date sqlToday = new java.sql.Date(today.getTime());
        
        
        res++;
        DBController dbcontroller=new DBController();
        dbcontroller.insDelUpDB("INSERT INTO product VALUES("+res+", '"+ASPV_kod.getText()+"', "
                + ""+(Integer.parseInt(ASPV_adet_s.getText())+Integer.parseInt(ASPV_adet_m.getText())+Integer.parseInt(ASPV_adet_l.getText()))+", 6, 'hebele', 1, "
                + ""+Double.parseDouble(ASPV_fiyat.getText())+", 9, '"+sqlToday+"' , "+Double.parseDouble(ASPV_agirlik.getText())+", 2, "+Integer.parseInt(ASPV_minimum.getText())+", 1, "
                + ""+ASPV_listele.getSelectedIndex()+", '"+sqlToday+"'  , '"+sqlToday+"' )");
        dbcontroller.insDelUpDB("INSERT INTO product_description VALUES("+res+", 1, '"+ASPV_isim.getText()+"', '"+ASPV_aciklama.getText()+"', '"+ASPV_etiketler.getText()+"')");
        dbcontroller.insDelUpDB("INSERT INTO product_option VALUES(227, "+res+",  11, 1 )");
        dbcontroller.insDelUpDB("INSERT INTO product_option_value VALUES("+(res+1000)+", 227, "+res+", 11, 46, "+Integer.parseInt(ASPV_adet_s.getText())+", 1)");
        dbcontroller.insDelUpDB("INSERT INTO product_option_value VALUES("+(res+1001)+", 227, "+res+", 11, 47, "+Integer.parseInt(ASPV_adet_m.getText())+", 1)");
        dbcontroller.insDelUpDB("INSERT INTO product_option_value VALUES("+(res+1002)+", 227, "+res+", 11, 48, "+Integer.parseInt(ASPV_adet_l.getText())+", 1)");
        dbcontroller.insDelUpDB("INSERT INTO product_to_category VALUES("+res+",  61)");
        
        for(int i=0;i<imageList.size();i++){
            try {
                
                DBController dbController=new DBController();
                
                 ArrayList a = dbController.selectSingleRowDB("select * from product_image");
                 if (a.isEmpty())
                        dbController.insDelUpDB("INSERT INTO product_image VALUES(1000, 1000, 'image' ,0)");
                
        
                image_id = DBController.getLastID("SELECT * FROM product_image");
                image_id++;
                File f = new File(imageList.get(i));
                String urlString = "ftp://openftp:ozyaz.11@ozguryazilim.bilkent.edu.tr/" + image_id;
                URL url = new URL(urlString);
                URLConnection connection = url.openConnection();
                connection.setDoOutput(true);
                BufferedOutputStream out = new BufferedOutputStream(connection.getOutputStream());
                FileInputStream in = new FileInputStream(f);
                byte[] buffer = new byte[1024];
                int j = 0;
                while ((j = in.read(buffer)) >= 0) {
                    out.write(buffer, 0, j);
                }
                out.close();
                in.close();
                
                
                dbcontroller.insDelUpDB("INSERT INTO product_image VALUES("+image_id+", "+res+", 'data/"+image_id+"')");
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        
     
    }//GEN-LAST:event_AEV_ekleActionPerformed

    private void ASPV_gozatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASPV_gozatActionPerformed
        String s;
        JFileChooser jfc = new JFileChooser();
        jfc.showDialog(jfc, "Choose an image file");
        s = jfc.getSelectedFile().getAbsolutePath();
        imageList.add(s);

    }//GEN-LAST:event_ASPV_gozatActionPerformed

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
    // End of variables declaration//GEN-END:variables
}
