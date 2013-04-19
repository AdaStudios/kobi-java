/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.model;

/**
 *
 * @author PaDaWaN
 */
public class StartupModel {
    
    
    public boolean Login(String kullanici,String sifre){
        
        if(kullanici.equals("riza") && sifre.equals("riza"))
            return  true;
        else
            return false;
    }
}


