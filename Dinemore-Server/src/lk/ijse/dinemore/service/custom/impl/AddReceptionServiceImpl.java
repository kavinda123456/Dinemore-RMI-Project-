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
import lk.ijse.dinemore.business.custom.AddReceptionBO;
import lk.ijse.dinemore.dto.AddReceptionDTO;
import lk.ijse.dinemore.observer.Observer;
import lk.ijse.dinemore.observer.Subject;
import lk.ijse.dinemore.reservation.impl.ReservationImpl;
import lk.ijse.dinemore.service.custom.AddReceptionService;

/**
 *
 * @author ACER
 */
public class AddReceptionServiceImpl extends UnicastRemoteObject implements AddReceptionService,Subject{
    private AddReceptionBO addReceptionBO;
    private static ArrayList<Observer>alObserver= new ArrayList<>();
    private static ReservationImpl<AddReceptionService> ResBook= new ReservationImpl<>();

    public AddReceptionServiceImpl() throws Exception{
        addReceptionBO=(AddReceptionBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ADDRECEPTION);
    }
    
    

    @Override
    public boolean addReception(AddReceptionDTO addReceptionDTO) throws Exception {
        boolean addReception=addReceptionBO.addReception(addReceptionDTO);
        notifyObservers();
        return addReception;
    }

    @Override
    public AddReceptionDTO searchReception(String recId) throws Exception {
        return addReceptionBO.searchReception(recId);
    }

    @Override
    public boolean deleteReception(String recId) throws Exception {
        boolean deleteReception=addReceptionBO.deleteReception(recId);
        notifyObservers();
        return deleteReception;
    }

    @Override
    public boolean updateReception(AddReceptionDTO addReceptionDTO) throws Exception {
        boolean updateReception=addReceptionBO.updateReception(addReceptionDTO);
        notifyObservers();
        return updateReception;
    }

    @Override
    public List<AddReceptionDTO> getAllReception() throws Exception {
        return addReceptionBO.getAllReception();
    }

    @Override
    public void registerObserver(Observer observer) throws Exception {
        alObserver.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws Exception {
        alObserver.remove(observer);
    }

    @Override
    public void notifyObservers() throws Exception {
        new Thread(()->{
            for (Observer observer : alObserver) {
                try {
                    observer.updateObservers();
                } catch (Exception ex) {
                    Logger.getLogger(AddReceptionServiceImpl.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }).start();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return ResBook.reserve(id, this);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return ResBook.relese(id);
    }
    
}
