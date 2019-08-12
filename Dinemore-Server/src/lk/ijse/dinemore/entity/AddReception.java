/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ACER
 */
@Entity
public class AddReception {
    
    @Id
    private String RecID;
    private String RecName;
    private String RecNic;
    private String RecAddress;

    public AddReception() {
    }

    public AddReception(String RecID, String RecName, String RecNic, String RecAddress) {
        this.RecID = RecID;
        this.RecName = RecName;
        this.RecNic = RecNic;
        this.RecAddress = RecAddress;
    }

    public String getRecID() {
        return RecID;
    }

    public void setRecID(String RecID) {
        this.RecID = RecID;
    }

    public String getRecName() {
        return RecName;
    }

    public void setRecName(String RecName) {
        this.RecName = RecName;
    }

    public String getRecNic() {
        return RecNic;
    }

    public void setRecNic(String RecNic) {
        this.RecNic = RecNic;
    }

    public String getRecAddress() {
        return RecAddress;
    }

    public void setRecAddress(String RecAddress) {
        this.RecAddress = RecAddress;
    }
    
    
}
