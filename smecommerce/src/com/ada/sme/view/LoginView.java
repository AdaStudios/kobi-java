package com.ada.sme.view;

import org.hsqldb.error.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView   extends  JPanel
{
    public JPanel loginViewContainerPanel;
    private JLabel loginViewHeadLabel;
    private JTextPane loginViewTextPane;
    private JTextField userIdTextField;
    private JButton exitButton;
    private JButton loginButton;
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

    public String[] getLoginParams(){
        String params[]={"",""};
        params[0]=userIdTextField.getText();
        params[1]=userPasswordPasswordField.getText();

        System.out.print(params[1]+"--"+params[0]);
        return params;

    }

    public void addLoginListener(ActionListener loginListener){
        loginButton.addActionListener(loginListener);
    }

    public void setResult(Boolean result){
        if(!result)
        loginViewTextPane.setText("Kullanıcı Adı ya da Parola Hatalı!");
    }

   /* public static void main(String[] args)
    {
        JFrame frame = new JFrame("LoginView");
        frame.setContentPane(new LoginView().loginViewContainerPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }         */
}
