package com.ada.sme.view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class StatusPanelView extends JPanel {

	JLabel lblServerIsReachable,lblTrue,lblBekleyen,lblWaiting;
	/**
	 * Create the panel.
	 */
	public void setStatus(Boolean b){
		if(b){
			lblTrue.setText("Evet");
			lblTrue.setForeground(Color.GREEN);
		}else{
			lblTrue.setText("Hayır");
			lblTrue.setForeground(Color.RED);
		}
	}
	
	public void setWaiting(int c){
		lblWaiting.setText(String.valueOf(c));
		if(c>0){
			lblWaiting.setForeground(Color.RED);
		}else{
			lblWaiting.setForeground(Color.GREEN);
		}
	}
	public StatusPanelView() {
		setLayout(null);
		
		 lblServerIsReachable = new JLabel("Sunucu ulaşılabilir:");
		lblServerIsReachable.setBounds(12, 12, 159, 15);
		add(lblServerIsReachable);
		
		 lblTrue = new JLabel("Evet");
		lblTrue.setBounds(169, 12, 53, 15);
		add(lblTrue);
		
		 lblBekleyen = new JLabel("Bekleyen Komut:");
		lblBekleyen.setBounds(250, 12, 125, 15);
		add(lblBekleyen);
		
		lblWaiting = new JLabel("0");
		lblWaiting.setBounds(387, 12, 25, 15);
		lblWaiting.setForeground(Color.green);
		add(lblWaiting);

	}
	
	
}
