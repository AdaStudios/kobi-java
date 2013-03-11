package com.ada.sme.controller;

import com.ada.sme.main.Main;
import com.ada.sme.model.StartupModel;
import com.ada.sme.model.StatusModel;
import com.ada.sme.model.StockModel;
import com.ada.sme.view.CreateOwnerView;
import com.ada.sme.view.LoginView;
import com.ada.sme.view.StatusPanelView;
import com.ada.sme.view.StockView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartupController
{

    LoginView loginView;
    CreateOwnerView createOwner;
    StartupModel startupModel;
    StartupController startupControllerInstance;


    public StartupController(JPanel v)
    {
        startupControllerInstance=this;
        startupModel = new StartupModel();
              if(v instanceof LoginView){
                      loginView =(LoginView) v;
              }else{
                   createOwner = (CreateOwnerView) v;
              }

        loginView.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            System.out.print("click");
                String[] params = loginView.getLoginParams();
                startupModel.Login(params);
                Boolean result = startupModel.getLoginResult();
                if(!result){
                    loginView.setResult(result);
                }else{

                    StatusPanelView statuspanel = new StatusPanelView();
                    StatusModel statusmodel = new StatusModel("139.179.139.112");
                    StatusController c = new StatusController(statusmodel, statuspanel);
                    c.initializeDB();

                    StockModel model = new StockModel();
                    StockView frame = new StockView(model,statuspanel);
                    StockController s_controller = new StockController(model,frame);

                    loginView.setVisible(false);
                    frame.setVisible(true);
                    Main.closeLogin();

                }

        }
    }
}

