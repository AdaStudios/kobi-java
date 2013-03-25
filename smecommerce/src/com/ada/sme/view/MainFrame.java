package com.ada.sme.view;

import com.ada.sme.controller.StartupController;
import com.ada.sme.controller.StoreController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame
{
    private JPanel mainFrameContainerPanel;
    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel bottomPanel;
    private JPanel contentContainerPanel;
    private JButton statusButton;
    private JButton localStoreButton;
    private JButton onlineStoreButton;
    private JButton notificationsButton;
    private JButton stockButton;
    private JButton supportButton;
    public static MainFrame mfinstance;


    public MainFrame()
    {

        mfinstance = this;


        localStoreButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               StoreController sc = new StoreController();
            }
        });




    }



    public void addStoreListener(ActionListener storeListener){
        localStoreButton.addActionListener(storeListener);
    }

    public JPanel getMainFrameContainerPanel(){
        return mainFrameContainerPanel;
    }

    public void setLeftPanel(JPanel leftMenu){

         //leftPanel=(LeftMenuView) leftMenu ;
       /* LeftMenuView l1 = new LeftMenuView();
        l1.setVisible(true);   */
        /*leftPanel = l1;

        leftPanel.validate(); */
         System.out.print("hebele");

        leftPanel.removeAll();
        leftPanel.add(new Button("hebele"));



    }

}
