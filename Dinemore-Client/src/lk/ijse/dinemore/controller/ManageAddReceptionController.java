/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.controller;

import java.util.List;
import lk.ijse.dinemore.dto.AddReceptionDTO;
import lk.ijse.dinemore.observer.Subject;
import lk.ijse.dinemore.proxy.ProxyHandler;
import lk.ijse.dinemore.service.ServiceFactory;
import lk.ijse.dinemore.service.custom.AddReceptionService;

/**
 *
 * @author ACER
 */
public class ManageAddReceptionController {
    public static boolean addReception(AddReceptionDTO redto)throws Exception{
        AddReceptionService addReceptionService=(AddReceptionService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ADDRECEPTION);
        return addReception(redto);
    }
    
    public static boolean updateReception(AddReceptionDTO redto) throws Exception{
        AddReceptionService addReceptionService = (AddReceptionService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.ADDRECEPTION);
        return addReceptionService.updateReception(redto);
    } 
    
    public static boolean deleteReception(String id)throws Exception{
        AddReceptionService addReceptionService = (AddReceptionService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.ADDRECEPTION);
        return addReceptionService.deleteReception(id);
    }
    
    public static AddReceptionDTO searchOrder(String recid) throws Exception{
        AddReceptionService addReceptionService = (AddReceptionService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.ADDRECEPTION);
        return addReceptionService.searchReception(recid);
    }
    
    public static List<AddReceptionDTO> getAllReception() throws Exception{
        AddReceptionService addReceptionService = (AddReceptionService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.ADDRECEPTION);
        return addReceptionService.getAllReception();
    }
    
    public static Subject getSubeject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ADDRECEPTION);
    }
    
    public static boolean reserveCustomer(String recID) throws Exception{
        AddReceptionService addReceptionService = (AddReceptionService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.ADDRECEPTION);
        return addReceptionService.release(recID);
    }
    
    public static boolean releaseCustomer(String recID) throws Exception{
        AddReceptionService receptionService = (AddReceptionService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.ADDRECEPTION);
        return receptionService.reserve(recID);
    }
}