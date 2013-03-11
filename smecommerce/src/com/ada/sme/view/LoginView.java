package com.ada.sme.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView   extends  JPanel
{
    private JPanel loginViewContainerPanel;
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

        //set head label Maybe it can be updated with a logo style image later.
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
        params[1]= String.valueOf( userPasswordPasswordField.getPassword() );
        return params;
    }

    public void addLoginListener(ActionListener loginListener){
        loginButton.addActionListener(loginListener);
    }

    public void setResult(Boolean result){
        if(!result)
        loginViewTextPane.setText("Kullanıcı Adı ya da Parola Hatalı!");
    }

    public JPanel getLoginViewContainerPanel()
    {
        return loginViewContainerPanel;
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
