/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.business;

import lk.ijse.dinemore.business.custom.impl.AddReceptionBOImpl;
import lk.ijse.dinemore.business.custom.impl.ReceptionBOImpl;

/**
 *
 * @author ACER
 */
public class BOFactory {
    public enum BOTypes{
        RECEPTION,ADDRECEPTION;
    }
    
    private static BOFactory bOFactory;

    private BOFactory() {
    }
    
    public static BOFactory getInstance(){
        if (bOFactory == null) {
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }
    
    public SuperBO getBO(BOTypes bOTypes){
        switch(bOTypes){
            case RECEPTION: 
                return new ReceptionBOImpl();
            case ADDRECEPTION:
                return new AddReceptionBOImpl();
            default: return null;
        }
    }
}
