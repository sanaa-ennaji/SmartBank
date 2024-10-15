package com.example.smartbank.DAO;

import com.example.smartbank.Entity.DemandeCredit;
import com.example.smartbank.Entity.HistoriqueModification;
import com.example.smartbank.Entity.Status;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.EntityManagerFactory;
import com.example.smartbank.jpa.EntityManagerHelper;
import java.time.LocalDate;
import java.util.List;


public class DemandeCreditDAOImpl implements DemandeCreditDAO {

    private final EntityManagerFactory entityManagerFactory;

    public DemandeCreditDAOImpl() {

        this.entityManagerFactory = EntityManagerHelper.getEntityManagerFactory();
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public DemandeCredit create(DemandeCredit demande) {
        EntityManager em = getEntityManager();
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
            if (transaction.isActive()) {
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
        EntityManager em = getEntityManager();
        try {
            List<DemandeCredit> demandes = em.createQuery("SELECT d FROM DemandeCredit d", DemandeCredit.class).getResultList();
            System.out.println("Number of demandes fetched: " + demandes.size());
            return demandes;
        } finally {
            em.close();
        }
    }


    @Override
    public DemandeCredit findById(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DemandeCredit.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public void update(DemandeCredit demande) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(demande);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(long id) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            DemandeCredit demande = em.find(DemandeCredit.class, id);
            if (demande != null) {
                em.remove(demande);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }

    }

    @Override
    public void updateStatus(long demande_credit_id, long status_id) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();


            DemandeCredit demandeCredit = em.find(DemandeCredit.class, demande_credit_id);
            if (demandeCredit == null) {
                throw new IllegalArgumentException("DemandeCredit with ID " + demande_credit_id + " not found.");
            }


            Status newStatus = em.find(Status.class, status_id);
            if (newStatus == null) {
                throw new IllegalArgumentException("Status with ID " + status_id + " not found.");
            }


            HistoriqueModification historique = new HistoriqueModification();
            historique.setDemandeCredit(demandeCredit);
            historique.setStatus(newStatus);
            historique.setDateModification(LocalDate.now());
            historique.setRaison("Status Updated");


            em.persist(historique);

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public List<DemandeCredit> getFilteredDemands(Long statusId, LocalDate dateDebut)
   {
        EntityManager em = getEntityManager();
        try {
            StringBuilder query = new StringBuilder("SELECT d FROM DemandeCredit d ");

            boolean hasStatus = statusId != null;
            boolean hasDateDebut = dateDebut != null;

            if (hasStatus || hasDateDebut) {
                query.append("WHERE ");
                if (hasStatus) {
                    query.append("EXISTS (SELECT h FROM HistoriqueModification h WHERE h.demandeCredit.id = d.id AND h.status.id = :statusId) ");
                }
                if (hasStatus && hasDateDebut) {
                    query.append("AND ");
                }
                if (hasDateDebut) {
                    query.append("d.dateDebut >= :dateDebut ");
                }
            }


            var queryObj = em.createQuery(query.toString(), DemandeCredit.class);
            if (hasStatus) {
                queryObj.setParameter("statusId", statusId);
            }
            if (hasDateDebut) {
                queryObj.setParameter("dateDebut", dateDebut);
            }

            return queryObj.getResultList();
        } finally {
            em.close();
        }
    }








}
