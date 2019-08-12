/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.service;

import java.rmi.Remote;

/**
 *
 * @author ACER
 */
public interface ServiceFactory extends Remote{
    
    public enum ServiceType{
        RECEPTION,ADDRECEPTION;
    }
    
    public SuperService getService(ServiceType serviceType) throws Exception;
}
