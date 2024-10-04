package com.example.smartbank.jpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class EntityManagerHelper {
    private EntityManagerHelper() {}
    private static EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("SmartBankPU");
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("EntityManagerFactory initialization failed.");
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void close() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

}
