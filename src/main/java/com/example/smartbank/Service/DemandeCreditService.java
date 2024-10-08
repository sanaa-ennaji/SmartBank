package com.example.smartbank.Service;

import com.example.smartbank.Entity.DemandeCredit;

import java.time.LocalDate;
import java.util.List;

public interface DemandeCreditService {
     DemandeCredit create(double montant, int duree, String projet, double mensualites , String email , String nom , String prenom , String phone , String CIN ,LocalDate dateNaissance, LocalDate dateDebute , Double total , boolean credit );
     List<DemandeCredit> getAll ();
     DemandeCredit findById (long id);
     void update (DemandeCredit demande);
}
