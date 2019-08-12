/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.repository;

import lk.ijse.dinemore.repository.custom.impl.AddReceptionRepositoryImpl;
import lk.ijse.dinemore.repository.custom.impl.ReceptionRepositoryImpl;

/**
 *
 * @author ACER
 */
public class RepositoryFactory {
     public enum RepositoryTypes{
        RECEPTION,ADDRECEPTION;
    }
    
    public static RepositoryFactory repositoryFactory;

    private RepositoryFactory() {
    }
    
    public static RepositoryFactory getInstance(){
        if (repositoryFactory == null) {
            repositoryFactory = new RepositoryFactory();
        }
        return repositoryFactory;
    }
    
    public SuperRepository getRepository(RepositoryTypes repositoryTypes){
        
       switch(repositoryTypes){
           case RECEPTION:
               return new ReceptionRepositoryImpl();
           case ADDRECEPTION:
               return new AddReceptionRepositoryImpl();
           default:
               return null;
       }
    }
}
