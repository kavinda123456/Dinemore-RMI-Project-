/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.controller;

import lk.ijse.dinemore.dto.ReceptionDTO;
import lk.ijse.dinemore.proxy.ProxyHandler;
import lk.ijse.dinemore.service.ServiceFactory;
import lk.ijse.dinemore.service.custom.ReceptionService;

/**
 *
 * @author ACER
 */
public class ManageChefController {
    
    public static boolean updateCooking(ReceptionDTO receptionDTO) throws Exception{
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.RECEPTION);
        return receptionService.updateStatus(receptionDTO);
    }
    
    public static boolean deleteCooking(String id)throws Exception{
        ReceptionService receptionService = (ReceptionService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.RECEPTION);
        return receptionService.deleteOrder(id);
    }
    
}
