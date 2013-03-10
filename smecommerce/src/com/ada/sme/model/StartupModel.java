package com.ada.sme.model;

import javax.swing.*;

/**
 * User: Enes Kıdık
 * Date: 3/10/13 --  Time: 3:06 PM
 */
public class StartupModel
{
    Boolean loginStatus = false;
    public StartupModel()
    {

    }

    public void Login(String[] params){

        if(params[0].equals("enes") && params[1].equals("enes")){
            loginStatus = true;
        } else{
            loginStatus = false;
        }
    }

    public boolean getLoginResult(){
        return loginStatus;
    }
}
