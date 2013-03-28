package com.ada.sme.view;

import com.ada.sme.controller.StoreController;
import com.intellij.uiDesigner.core.GridConstraints;

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

    private JButton             buttonOK;


    public MainFrame()
    {
        mfinstance = this;

        //leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));

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

    public void setLeftPanel(LeftMenuView leftMenu){

        leftPanel.removeAll();

        try {
            leftPanel.add(leftMenu.getLeftMenuContainerPanel() , new GridBagConstraints( 0, GridBagConstraints.RELATIVE, 1, 1, 0, 0, GridBagConstraints.NORTHWEST,
                    GridBagConstraints.NONE, new Insets(0,0,0,0), 0,0) );

            leftPanel.add(new LeftStaffAltMenuView().getLeftStaffAltMenuContainerPanel() , new GridBagConstraints(0, GridBagConstraints.RELATIVE, 1, 1, 0, 0, GridBagConstraints.NORTHWEST,
                    GridBagConstraints.NONE, new Insets(0,0,0,0), 0, 0) );

            leftPanel.revalidate();

        } catch (  Exception nfe) {
            JOptionPane.showMessageDialog(null, nfe.getMessage());
        }




    }

}
