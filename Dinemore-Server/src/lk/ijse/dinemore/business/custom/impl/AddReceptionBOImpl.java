/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.dinemore.business.custom.AddReceptionBO;
import lk.ijse.dinemore.dto.AddReceptionDTO;
import lk.ijse.dinemore.entity.AddReception;
import lk.ijse.dinemore.repository.RepositoryFactory;
import lk.ijse.dinemore.repository.custom.AddReceptionRepository;
import lk.ijse.dinemore.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ACER
 */
public class AddReceptionBOImpl implements AddReceptionBO{
    
    private AddReceptionRepository addReceptionRepository;

    public AddReceptionBOImpl() {
        addReceptionRepository=(AddReceptionRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ADDRECEPTION);
    }
    
    

    @Override
    public boolean addReception(AddReceptionDTO addReceptionDTO) throws Exception {
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
           addReceptionRepository.setSesstion(session);
           session.beginTransaction();
            AddReception addReception=new AddReception(
                    addReceptionDTO.getRecID(),
                    addReceptionDTO.getRecName(),
                    addReceptionDTO.getRecNic(),
                    addReceptionDTO.getRecAddress()
            );
            boolean result=addReceptionRepository.save(addReception);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean deleteReception(String oid) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            addReceptionRepository.setSesstion(session);
            session.beginTransaction();
            AddReception addReception = addReceptionRepository.findByID(oid);
            boolean result = false;
            if (addReception != null) {
                result = addReceptionRepository.delete(addReception);
            }
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public List<AddReceptionDTO> getAllReception() throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            addReceptionRepository.setSesstion(session);
            session.beginTransaction();
            List<AddReception> addReceptions = addReceptionRepository.findAll();
            session.getTransaction().commit();
            if (addReceptions != null) {
                System.out.println("Not Null");
                List<AddReceptionDTO> allReception=new ArrayList<>();
                for (AddReception addReception : addReceptions) {
                    AddReceptionDTO addreceptionDTO = new AddReceptionDTO(
                            addReception.getRecID(),
                            addReception.getRecName(),
                            addReception.getRecNic(),
                            addReception.getRecAddress()
                    );
                    
//                    System.out.println("Hello :"+custome.getId());
                    allReception.add(addreceptionDTO);
                }
                return allReception;
            }else{
                return null;
            }
        }
    }

    @Override
    public AddReceptionDTO searchReception(String oid) throws Exception {
        AddReception addReception=addReceptionRepository.findByID(oid);
        return new AddReceptionDTO(
                addReception.getRecID(),
                addReception.getRecName(),
                addReception.getRecNic(),
                addReception.getRecAddress() 
        );
    }

    @Override
    public boolean updateReception(AddReceptionDTO addReceptionDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            addReceptionRepository.setSesstion(session);
            session.beginTransaction();
            AddReception addReception = new AddReception(
                    addReceptionDTO.getRecID(),
                    addReceptionDTO.getRecName(),
                    addReceptionDTO.getRecNic(),
                    addReceptionDTO.getRecAddress()
            );
            boolean result = addReceptionRepository.update(addReception);
            session.getTransaction().commit();
            return result;
        }
    }
    
}
