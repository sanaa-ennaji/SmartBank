package com.example.smartbank.Service;

import com.example.smartbank.DAO.DemandeCreditDAO;
import com.example.smartbank.DAO.DemandeCreditDAOImpl;
import com.example.smartbank.Entity.DemandeCredit;

import java.time.LocalDate;
import java.util.List;

public class DemandeCreditServiceImpl implements DemandeCreditService {

    public DemandeCreditDAO demandeCreditDAOImpl;

    public DemandeCreditServiceImpl() {
        this.demandeCreditDAOImpl = new DemandeCreditDAOImpl();
    }

    @Override
    public DemandeCredit create(double montant, int duree, String projet, double mensualites , String email , String nom , String prenom , String phone , String CIN ,LocalDate dateNaissance, LocalDate dateDebute , Double total , boolean credit ) {
        DemandeCredit demande = new DemandeCredit();
        demande.setMontant(montant);
        demande.setDuree(duree);
        demande.setProjet(projet);
       demande.setMensualites(mensualites);
       demande.setEmail(email);
       demande.setNom(nom);
       demande.setPrenom(prenom);
       demande.setCIN(CIN);
        demande.setDateDebut(dateNaissance);
       demande.setDateDebut(dateDebute);
       demande.setTotal(total);
       demande.setCredit(credit);

        demande.setDateDemande(LocalDate.now());
        demandeCreditDAOImpl.create(demande);

        return demande;
    }

    @Override
    public List<DemandeCredit> getAll() {
        return demandeCreditDAOImpl.getAll();
    }

    @Override
    public DemandeCredit findById(long id) {
        return demandeCreditDAOImpl.findById(id);
    }

    @Override
    public void update(DemandeCredit demande) {
        demandeCreditDAOImpl.update(demande);
    }
}
