package com.ada.sme.controller;

import com.ada.sme.main.Main;
import com.ada.sme.model.StoreModel;
import com.ada.sme.model.StatusModel;
import com.ada.sme.model.StockModel;
import com.ada.sme.view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreController extends LeftMenuView {

    MainFrame mainFrame;
    CreateOwnerView createOwner;
    StoreController startupControllerInstance;
    LeftMenuView leftMenu;


    public StoreController(LeftMenuView v)
    {
        leftMenu=v;
        startupControllerInstance=this;
        mainFrame.addStoreListener(new StoreListener());
        StoreController storeController = new StoreController(new LeftMenuView());
    }

    class StoreListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            System.out.print("click");


            mainFrame.setLeftPanel(leftMenu);
//




        }
    }
}

