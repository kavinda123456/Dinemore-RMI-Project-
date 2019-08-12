/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.service.impl;

import java.rmi.server.UnicastRemoteObject;
import lk.ijse.dinemore.service.ServiceFactory;
import lk.ijse.dinemore.service.SuperService;
import lk.ijse.dinemore.service.custom.impl.AddReceptionServiceImpl;
import lk.ijse.dinemore.service.custom.impl.ReceptionServiceImpl;

/**
 *
 * @author ACER
 */
public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory{
    private static ServiceFactory serviceFactory;

    public ServiceFactoryImpl() throws Exception{
    }
    
    public static ServiceFactory getInstance() throws Exception{
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactoryImpl();
        }
        return serviceFactory;
    }

    @Override
    public SuperService getService(ServiceType serviceType) throws Exception {
        switch(serviceType){
            case RECEPTION:
                return new ReceptionServiceImpl();
            case ADDRECEPTION:
                return new AddReceptionServiceImpl();
            default: return null;
        }
    }
    
    
}
