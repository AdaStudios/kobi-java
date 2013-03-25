package com.ada.sme.controller;

import com.ada.sme.main.Main;
import com.ada.sme.model.StoreModel;
import com.ada.sme.model.StatusModel;
import com.ada.sme.model.StockModel;
import com.ada.sme.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreController extends LeftMenuView {


    CreateOwnerView createOwner;
    StoreController storeControllerInstance;
    LeftMenuView leftMenu;
    StartupController startupController;

    public StoreController()
    {
        LeftMenuView l1 = new LeftMenuView();
        StoreModel sm = new StoreModel();
        l1.setVisible(true);
        JPanel p2 = new JPanel();
        p2.add(new Button("osman"));
        MainFrame.mfinstance.setLeftPanel(l1);

        storeControllerInstance=this;
    }

    class StoreListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            System.out.print("click");



//




        }
    }
}

