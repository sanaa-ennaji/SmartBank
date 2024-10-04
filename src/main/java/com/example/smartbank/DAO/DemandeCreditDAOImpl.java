package com.example.smartbank.DAO;

import com.example.smartbank.Entity.DemandeCredit;
import com.example.smartbank.jpa.EntityManagerHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;


import java.util.List;

public class DemandeCreditDAOImpl implements DemandeCreditDAO {

    private EntityManagerFactory entityManagerFactory;


    public DemandeCreditDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public DemandeCredit create(DemandeCredit demande) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(demande);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        return demande;
    }

    @Override
    public List<DemandeCredit> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<DemandeCredit> demandes = null;
        try {
            demandes = em.createQuery("SELECT d FROM DemandeCredit d", DemandeCredit.class).getResultList();
        } finally {
            em.close();
        }
        return demandes;
    }

    @Override
    public DemandeCredit findById(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        DemandeCredit demande = null;
        try {
            demande = em.find(DemandeCredit.class, id);
        } finally {
            em.close();
        }
        return demande;
    }

    @Override
    public void update(DemandeCredit demande) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(demande);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            DemandeCredit demande = em.find(DemandeCredit.class, id);
            if (demande != null) {
                em.remove(demande);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


}
