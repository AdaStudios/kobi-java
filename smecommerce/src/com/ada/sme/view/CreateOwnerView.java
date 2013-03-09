package com.ada.sme.view;

import javax.swing.*;
import java.awt.*;

public class CreateOwnerView
{
    private JPanel createOwnerContainerPanel;
    private JTextField ownerIdTextField;
    private JPasswordField ownerPasswordField;
    private JPasswordField ownerRePasswordField2;
    private JButton exitCreateOwnerButton;
    private JButton createOwnerButton;
    private JLabel ownerIdLabel;
    private JLabel ownerPasswordLabel;
    private JLabel ownerRePasswordLabel;
    private JTextPane createOwnerHeaderTextPane;
    private JLabel createOwnerHeaderLogoLabel;

//    public static void main(String[] args)
//    {
//        JFrame frame = new JFrame("CreateOwnerView");
//        frame.setContentPane(new CreateOwnerView().createOwnerContainerPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }

    public CreateOwnerView()
    {
        //set head label
        createOwnerHeaderLogoLabel.setFont(new Font("arial", Font.BOLD, 18));
        createOwnerHeaderLogoLabel.setForeground(new Color(143, 51, 32));
        createOwnerHeaderLogoLabel.setText("E-COMMERCE for SME v0.01");
        //setting header jtextpane for information.
        createOwnerHeaderTextPane.setFont(new Font("arial", Font.BOLD, 14));
        createOwnerHeaderTextPane.setForeground(Color.RED);
        createOwnerHeaderTextPane.setText("UYARI\nProgramı ilk defa çalıştırıyorsunuz.\nLütfen Yönetici hesabı oluşturun." );



    }
}
