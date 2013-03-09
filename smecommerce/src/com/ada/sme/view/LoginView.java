package com.ada.sme.view;

import javax.swing.*;
import java.awt.*;

public class LoginView
{
    private JPanel loginViewContainerPanel;
    private JLabel loginViewHeadLabel;
    private JTextPane loginViewTextPane;
    private JTextField userIdTextField;
    private JButton çıkışButton;
    private JButton girişButton;
    private JPasswordField userPasswordPasswordField;
    private JLabel userIdLabel;
    private JLabel userPasswordLabel;

    public LoginView()
    {
        //set head label
        loginViewHeadLabel.setFont(new Font("arial", Font.BOLD, 18));
        loginViewHeadLabel.setForeground(new Color(143, 51, 32));
        loginViewHeadLabel.setText("E-COMMERCE for SME v0.01");
        //setting header jtextpane for information.
        loginViewTextPane.setFont(new Font("arial", Font.BOLD, 14));
        loginViewTextPane.setForeground(Color.RED);
        loginViewTextPane.setText("Kullanıcı adı ve parolanızı giriniz." );

    }

//    public static void main(String[] args)
//    {
//        JFrame frame = new JFrame("LoginView");
//        frame.setContentPane(new LoginView().loginViewContainerPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }
}
