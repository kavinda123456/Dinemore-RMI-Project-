/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.dinemore.business.custom.ReceptionBO;
import lk.ijse.dinemore.dto.ReceptionDTO;
import lk.ijse.dinemore.entity.Reception;
import lk.ijse.dinemore.repository.RepositoryFactory;
import lk.ijse.dinemore.repository.custom.ReceptionRepository;
import lk.ijse.dinemore.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ACER
 */
public class ReceptionBOImpl implements ReceptionBO{
    
    private ReceptionRepository receptionRepository;

    public ReceptionBOImpl() {
        receptionRepository=(ReceptionRepository)RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.RECEPTION);
    }
    
    

    @Override
    public boolean addOrder(ReceptionDTO receptionDTO) throws Exception {
       try(Session session = HibernateUtil.getSessionFactory().openSession()){
            receptionRepository.setSesstion(session);
            session.beginTransaction();
            Reception reception = new Reception(
                    receptionDTO.getOrderID(),
                    receptionDTO.getCustomerName(),
                    receptionDTO.getTPNumber(),
                    receptionDTO.getQty(),
                    receptionDTO.getDate(),
                    receptionDTO.getTime(),
                    receptionDTO.getStatus()
                    
            );
            boolean result = receptionRepository.save(reception);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public List<ReceptionDTO> getAllOrder() throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            receptionRepository.setSesstion(session);
            session.beginTransaction();
            List<Reception> receptions = receptionRepository.findAll();
            session.getTransaction().commit();
            if (receptions != null) {
                System.out.println("Not Null");
                List<ReceptionDTO> allReception=new ArrayList<>();
                for (Reception reception : receptions) {
                    ReceptionDTO receptionDTO = new ReceptionDTO(
                            reception.getOrderID(),
                            reception.getCustomerName(),
                            reception.getTPNumber(),
                            reception.getQty(),
                            reception.getDate(),
                            reception.getTime(),
                            reception.getStatus()
                    );
                    
//                    System.out.println("Hello :"+custome.getId());
                    allReception.add(receptionDTO);
                }
                return allReception;
            }else{
                return null;
            }
        }
    }

    @Override
    public ReceptionDTO searchOrder(String oid) throws Exception {
        Reception reception = receptionRepository.findByID(oid);
        return new ReceptionDTO(
                reception.getOrderID(),
                reception.getCustomerName(),
                reception.getTPNumber(),
                reception.getQty(),
                reception.getDate(),
                reception.getTime(),
                reception.getStatus()
        );
                
    }

    @Override
    public boolean deleteOrder(String oid) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            receptionRepository.setSesstion(session);
            session.beginTransaction();
            Reception reception = receptionRepository.findByID(oid);
            boolean result = false;
            if (reception != null) {
                result = receptionRepository.delete(reception);
            }
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateStatus(ReceptionDTO receptionDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            receptionRepository.setSesstion(session);
            session.beginTransaction();
            Reception reception = new Reception(
                    receptionDTO.getOrderID(),
                    receptionDTO.getCustomerName(),
                    receptionDTO.getTPNumber(),
                    receptionDTO.getQty(),
                    receptionDTO.getDate(),
                    receptionDTO.getTime(),
                    receptionDTO.getStatus()
            );
            boolean result = receptionRepository.update(reception);
            session.getTransaction().commit();
            return result;
        }
    }
    
}
