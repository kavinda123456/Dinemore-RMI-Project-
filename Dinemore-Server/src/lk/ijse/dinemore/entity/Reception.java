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
public class Reception {
    
    @Id
    private String OrderID;
    private String CustomerName;
    private String TPNumber;
    private int Qty;
    private String Date;
    private String Time;
    private String Status;

    public Reception() {
    }

    public Reception(String OrderID, String CustomerName, String TPNumber, int Qty, String Date, String Time, String Status) {
        this.OrderID = OrderID;
        this.CustomerName = CustomerName;
        this.TPNumber = TPNumber;
        this.Qty = Qty;
        this.Date = Date;
        this.Time = Time;
        this.Status = Status;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getTPNumber() {
        return TPNumber;
    }

    public void setTPNumber(String TPNumber) {
        this.TPNumber = TPNumber;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    
    
}
