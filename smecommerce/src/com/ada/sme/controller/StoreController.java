package com.ada.sme.controller;

import com.ada.sme.model.StoreModel;
import com.ada.sme.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreController extends LeftMenuView {


    CreateOwnerView createOwner;
    StoreController storeControllerInstance;
    LeftMenuView leftMenu;
    StartupController startupController;

    public StoreController()
    {
        storeControllerInstance=this;


        LeftMenuView l1 = new LeftMenuView();
        //l1.setLayout(new GridBagLayout() );
        System.out.println( " --->LeftMenu view geldi :::" + l1.getLeftMenuContainerPanel().toString() );

        StoreModel sm = new StoreModel();
        l1.getLeftMenuContainerPanel().setVisible(true);
        MainFrame.mfinstance.setLeftPanel(l1);

    }

    class StoreListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            System.out.print("store listener click..");
        }
    }
}

