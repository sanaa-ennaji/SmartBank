package com.example.smartbank.DAO;

import com.example.smartbank.Entity.DemandeCredit;
import com.example.smartbank.jpa.EntityManagerHelper;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


import java.util.List;

public class DemandeCreditDAOImpl implements DemandeCreditDAO {


    @Override
    public DemandeCredit create(DemandeCredit demande) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction transaction = null;
        try{
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(demande);
            transaction.commit();

        }catch(Exception  e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();

        }finally {
            em.close();
        }
        return null;
    }

    @Override
    public List<DemandeCredit> getAll() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<DemandeCredit> demandes = null ;
        try{
            demandes = em.createQuery("SELECT d From DemandeCredit d", DemandeCredit.class).getResultList();
        }finally {
            em.close();
        }
        return demandes;
    }

    @Override
    public DemandeCredit findById(long id) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        DemandeCredit demande = null ;
        try {
            demande = em.find(DemandeCredit.class, id);
        } finally {
            em.close();
        }
        return demande;
    }

    @Override
    public void updateStatus(DemandeCredit demande) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction transaction = null ;
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

    }
}
