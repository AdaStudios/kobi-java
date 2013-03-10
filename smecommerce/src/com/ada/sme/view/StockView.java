package com.ada.sme.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.ada.sme.main.Product;
import com.ada.sme.model.StockModel;

public class StockView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextArea textArea;
	JPanel panel;
	JLabel hata;
	JButton btnAra, btnEkle, btnGuncelle, btnSil, btnrnEkle;

	
	public String getSearchInput() {
		return textField.getText();
	}

	public Product getInsertObject() {

		String pname = textField_2.getText();
		int amount = Integer.parseInt(textField_3.getText());
		double price = Double.parseDouble(textField_4.getText());
		String feature = textArea.getText();

		return new Product(-1, pname, amount, price, feature);
	}
	
	public Product getUpdateObject() {

		String id = textField_1.getText();
		String pname = textField_2.getText();
		int amount = Integer.parseInt(textField_3.getText());
		double price = Double.parseDouble(textField_4.getText());
		String feature = textArea.getText();

		return new Product(Integer.valueOf(id), pname, amount, price, feature);
	}
	
	public String getId(){
		return textField_1.getText();
	}
	
	public void addSearchListener(ActionListener mal) {
		btnAra.addActionListener(mal);
	}

	public void addInsertListener(ActionListener mal) {
		btnEkle.addActionListener(mal);
	}
	public void addUpdateListener(ActionListener mal) {
		btnGuncelle.addActionListener(mal);
	}
	
	public void addDeleteListener(ActionListener mal) {
		btnSil.addActionListener(mal);
	}

	public void setSearch(ArrayList<Product> p) {
		reset();
		
		if (p.size() > 0) {
			panel.setVisible(true);
			btnSil.setVisible(true);
			btnGuncelle.setVisible(true);
			Product p2 = p.get(0);
			textField_1.setText(p2.getpId() + "");
			textField_2.setText(p2.getpName());
			textField_3.setText(p2.getAmount() + "");
			textField_4.setText(p2.getPrice() + "");
			textArea.setText(p2.getpFeature());
		} else {
			hata.setText("Sonuç bulunamadı!");
			hata.setForeground(Color.red);
			btnrnEkle.setVisible(true);
		}
		
	}

	public void notifyAdd(int a) {
		reset();
		if (a == -1) {
			hata.setText("Ürun Eklenemedi!");
			hata.setForeground(Color.RED);
		} else {
			hata.setText("Ürün Başarıyla eklendi!");
			
		}
	}
	
	public void notifyUpdate(int a) {
		reset();
		if (a == -1) {
			hata.setText("Ürun Güncellenemedi!");
			hata.setForeground(Color.RED);
		} else {
			hata.setText("Ürün Başarıyla Güncellendi!");
			
		}
	}
	
	public void notifyDel(int a){
		reset();
		if(a==-1){
			hata.setText("Ürün Silinemedi!");
			hata.setForeground(Color.RED);
		}else{
			hata.setText("Ürün Başarıyla Silindi!");
			
		}
	}

	public void reset() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textArea.setText("");
		panel.setVisible(false);
		btnSil.setVisible(false);
		btnGuncelle.setVisible(false);
		btnEkle.setVisible(false);
		hata.setForeground(Color.GREEN);
		btnrnEkle.setVisible(false);
	}

	/**
	 * Create the frame.
	 */
	public StockView(StockModel sm, StatusPanelView p) {
		//s_model = sm;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(107, 27, 223, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblArama = new JLabel("Arama");
		lblArama.setBounds(183, 0, 61, 15);
		contentPane.add(lblArama);

		JLabel lblProductId = new JLabel("Ürün No:");
		lblProductId.setBounds(18, 30, 93, 15);
		contentPane.add(lblProductId);

		panel = new JPanel();
		panel.setBounds(0, 58, 523, 225);
		contentPane.add(panel);
		panel.setVisible(false);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(86, 190, 364, 35);
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		StatusPanelView stpanel = p;
		p.setBounds(0, 280, 414, 50);
		//stpanel.setVisible(true);
		contentPane.add(stpanel);
		
		btnEkle = new JButton("EKLE");
		panel_1.add(btnEkle);

		btnGuncelle = new JButton("GÜNCELLE");
		panel_1.add(btnGuncelle);

		btnSil = new JButton("SİL");
		panel_1.add(btnSil);

		JLabel lblProductId_1 = new JLabel("Ürün Adı:");
		lblProductId_1.setBounds(11, 48, 80, 15);
		panel.add(lblProductId_1);

		JLabel lblAdet = new JLabel("Adet:");
		lblAdet.setBounds(11, 75, 50, 15);
		panel.add(lblAdet);

		JLabel lblFiyat = new JLabel("Fiyat:");
		lblFiyat.setBounds(11, 102, 50, 15);
		panel.add(lblFiyat);

		JLabel lblzellikler = new JLabel("Özellikler:");
		lblzellikler.setBounds(269, 75, 80, 15);
		panel.add(lblzellikler);

		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(109, 12, 98, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(109, 46, 359, 19);
		panel.add(textField_2);

		JLabel label = new JLabel("Ürün No:");
		label.setBounds(14, 14, 93, 15);
		panel.add(label);

		textField_3 = new JTextField();
		textField_3.setBounds(109, 75, 98, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(109, 100, 98, 19);
		panel.add(textField_4);
		textField_4.setColumns(10);

		textArea = new JTextArea();
		textArea.setBounds(269, 91, 199, 82);
		panel.add(textArea);

		btnAra = new JButton("ARA");
		btnAra.setBounds(347, 24, 107, 25);
		contentPane.add(btnAra);

		hata = new JLabel("");
		hata.setHorizontalAlignment(SwingConstants.CENTER);
		hata.setFont(new Font("Ubuntu", Font.BOLD, 16));
		hata.setBounds(50, 64, 404, 15);
		contentPane.add(hata);

		btnrnEkle = new JButton("Ürün Ekle");
		btnrnEkle.setVisible(false);
		btnrnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(true);
				btnEkle.setVisible(true);
				btnGuncelle.setVisible(false);
				btnSil.setVisible(false);
				hata.setText("");
				btnrnEkle.setVisible(false);
			}
		});
		btnrnEkle.setBounds(190, 109, 117, 25);
		contentPane.add(btnrnEkle);
	}
}
