package com.example.smartbank.jpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class EntityManagerHelper {
    private static EntityManagerFactory emf;

    private EntityManagerHelper() {}


    static {
        try {
            emf = Persistence.createEntityManagerFactory("SmartBankPU");
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("EntityManagerFactory initialization failed.");
        }
    }


    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }


    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

}
