package com.ada.sme.view;

import javax.swing.*;
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
    private JLabel current;


    public MainFrame()
    {


    }

    public JPanel getMainFrameContainerPanel(){
        return mainFrameContainerPanel;
    }

}
