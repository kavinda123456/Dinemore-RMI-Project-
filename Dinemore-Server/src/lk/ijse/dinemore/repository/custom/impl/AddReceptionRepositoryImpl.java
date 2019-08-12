/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.repository.custom.impl;

import java.util.List;
import lk.ijse.dinemore.entity.AddReception;
import lk.ijse.dinemore.repository.custom.AddReceptionRepository;
import org.hibernate.Session;

/**
 *
 * @author ACER
 */
public class AddReceptionRepositoryImpl implements AddReceptionRepository{
    private Session session;

    @Override
    public void setSesstion(Session session) {
       this.session=session;
    }

    @Override
    public boolean save(AddReception t) throws Exception {
        return (session.save(t)!=null);
    }

    @Override
    public boolean delete(AddReception t) throws Exception {
        session.delete(t);
        return true;
    }

    @Override
    public AddReception findByID(String id) throws Exception {
        return session.get(AddReception.class, id);
    }

    @Override
    public boolean update(AddReception t) throws Exception {
        session.update(t);
        return true;
    }

    @Override
    public List<AddReception> findAll() throws Exception {
        return session.createQuery("FROM AddReception").list();
    }
    
}
