/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.service.custom;

import java.util.List;
import lk.ijse.dinemore.dto.AddReceptionDTO;
import lk.ijse.dinemore.service.SuperService;

/**
 *
 * @author ACER
 */
public interface AddReceptionService extends SuperService{
    public boolean addReception(AddReceptionDTO addReceptionDTO)throws Exception;
    public AddReceptionDTO searchReception(String recId)throws Exception;
    public boolean deleteReception(String recId)throws Exception;
    public boolean updateReception(AddReceptionDTO addReceptionDTO)throws Exception;
    public List<AddReceptionDTO> getAllReception()throws Exception;
}
