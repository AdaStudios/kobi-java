package com.ada.sme.model;

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
