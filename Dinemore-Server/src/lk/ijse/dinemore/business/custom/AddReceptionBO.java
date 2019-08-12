/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.business.custom;

import java.util.List;
import lk.ijse.dinemore.business.SuperBO;
import lk.ijse.dinemore.dto.AddReceptionDTO;

/**
 *
 * @author ACER
 */
public interface AddReceptionBO extends SuperBO{
    public boolean addReception(AddReceptionDTO addReceptionDTO) throws  Exception;
    
    public boolean deleteReception(String oid) throws Exception;
    
    public List<AddReceptionDTO> getAllReception() throws Exception;
    
    public AddReceptionDTO searchReception(String oid) throws Exception;
    
    public boolean updateReception(AddReceptionDTO addReceptionDTO) throws Exception;
}
