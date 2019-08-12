/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.controller;

import java.util.List;
import lk.ijse.dinemore.dto.ReceptionDTO;
import lk.ijse.dinemore.observer.Subject;
import lk.ijse.dinemore.proxy.ProxyHandler;
import lk.ijse.dinemore.service.ServiceFactory;
import lk.ijse.dinemore.service.SuperService;
import lk.ijse.dinemore.service.custom.ReceptionService;

/**
 *
 * @author ACER
 */
public class ManageReceptionController {
    public static boolean addReception(ReceptionDTO cdto) throws Exception{
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.RECEPTION);
        return receptionService.addOrder(cdto);
    }
    
    public static ReceptionDTO searchOrder(String oid) throws Exception{
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.RECEPTION);
        return receptionService.searchOrder(oid);
    }
    
    public static List<ReceptionDTO> getAllOrder() throws Exception{
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.RECEPTION);
        return receptionService.getAllOrder();
    }
    
    public static Subject getSubeject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.RECEPTION);
    }
    
    public static boolean reserveCustomer(String orderID) throws Exception{
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.RECEPTION);
        return receptionService.release(orderID);
    }
    
    public static boolean releaseCustomer(String orderID) throws Exception{
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.RECEPTION);
        return receptionService.reserve(orderID);
    }
}
