package com.example.smartbank.Service;

import com.example.smartbank.Entity.DemandeCredit;

import java.util.List;

public interface DemandeCreditService {
     DemandeCredit create (double montant , int duree , String etat , String remarques);
     List<DemandeCredit> getAll ();
     DemandeCredit findById (long id);
     void update (DemandeCredit demande);
}
