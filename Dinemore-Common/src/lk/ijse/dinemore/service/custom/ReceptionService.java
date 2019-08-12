/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.service.custom;

import java.util.List;
import lk.ijse.dinemore.dto.ReceptionDTO;
import lk.ijse.dinemore.service.SuperService;

/**
 *
 * @author ACER
 */
public interface ReceptionService extends SuperService{
    public boolean addOrder(ReceptionDTO receptionDTO) throws Exception;
    public ReceptionDTO searchOrder(String oid) throws Exception;
    public boolean deleteOrder(String oid) throws Exception;
    public boolean updateStatus(ReceptionDTO receptionDTO) throws Exception;  
    public List<ReceptionDTO> getAllOrder() throws Exception;
}
