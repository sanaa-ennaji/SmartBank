package com.example.smartbank.DAO;

import com.example.smartbank.Entity.DemandeCredit;
import com.example.smartbank.Entity.HistoriqueModification;
import com.example.smartbank.Entity.Status;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.enterprise.context.RequestScoped;

import java.time.LocalDate;
import java.util.List;

@RequestScoped
public class DemandeCreditDAOImpl implements DemandeCreditDAO {

    @Inject
    private EntityManager em;

    @Override
    public DemandeCredit create(DemandeCredit demande) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(demande);


            Status initialStatus = em.createQuery("SELECT s FROM Status s WHERE s.name = 'encours'", Status.class)
                    .setMaxResults(1)
                    .getSingleResult();


            HistoriqueModification historique = new HistoriqueModification();
            historique.setDemandeCredit(demande);
            historique.setStatus(initialStatus);
            historique.setDateModification(LocalDate.now());
            historique.setRaison("Created");


            em.persist(historique);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return demande;
    }

    @Override
    public List<DemandeCredit> getAll() {
        return em.createQuery("SELECT d FROM DemandeCredit d", DemandeCredit.class).getResultList();
    }

    @Override
    public DemandeCredit findById(long id) {
        return em.find(DemandeCredit.class, id);
    }

    @Override
    public void update(DemandeCredit demande) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(demande);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {
        EntityTransaction transaction = em.getTransaction();
        try {
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
        }
    }
}
