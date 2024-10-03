package com.example.smartbank.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class EntityManagerHelper {
  private static EntityManagerFactory emf;


    private EntityManagerHelper(){

    }

    static {
       try {
           emf = Persistence.createEntityManagerFactory("SmartBankPU");
        }catch (PersistenceException e){
           e.printStackTrace();
           throw new ExceptionInInitializerError("entityManagerFactory failed");

       }
    }

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static void close (){
       if(emf != null){
           emf.close();
       }
    }

}
