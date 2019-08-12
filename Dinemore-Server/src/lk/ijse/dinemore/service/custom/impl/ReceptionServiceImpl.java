/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.service.custom.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.dinemore.business.BOFactory;
import lk.ijse.dinemore.business.custom.ReceptionBO;
import lk.ijse.dinemore.dto.ReceptionDTO;
import lk.ijse.dinemore.observer.Observer;
import lk.ijse.dinemore.observer.Subject;
import lk.ijse.dinemore.reservation.impl.ReservationImpl;
import lk.ijse.dinemore.service.custom.ReceptionService;

/**
 *
 * @author ACER
 */
public class ReceptionServiceImpl extends UnicastRemoteObject implements ReceptionService,Subject{
    
    private ReceptionBO receptionBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<ReceptionService> ResBook = new ReservationImpl<>();
    
    public ReceptionServiceImpl() throws Exception{
        receptionBO=(ReceptionBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RECEPTION);
    }
    
    
    @Override
    public boolean addOrder(ReceptionDTO receptionDTO) throws Exception {
        boolean addOrder=receptionBO.addOrder(receptionDTO);
        notifyObservers();
        return addOrder;
    }

    @Override
    public ReceptionDTO searchOrder(String oid) throws Exception {
        return receptionBO.searchOrder(oid);
    }

    @Override
    public List<ReceptionDTO> getAllOrder() throws Exception {
        return receptionBO.getAllOrder();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return ResBook.reserve(id, this);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return ResBook.relese(id);
    }

    @Override
    public void registerObserver(Observer observer) throws Exception {
        alObservers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws Exception {
        alObservers.remove(observer);
    }

    @Override
    public void notifyObservers() throws Exception {
         new Thread(()->{
            for (Observer observer : alObservers) {
                try {
                    observer.updateObservers();
                } catch (Exception ex) {
                    Logger.getLogger(ReceptionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    @Override
    public boolean deleteOrder(String oid) throws Exception {
        boolean deleteOrder=receptionBO.deleteOrder(oid);
        notifyObservers();
        return deleteOrder;
    }

    @Override
    public boolean updateStatus(ReceptionDTO receptionDTO) throws Exception {
        boolean updateOrder=receptionBO.updateStatus(receptionDTO);
        notifyObservers();
        return updateOrder;
    }
    
}
