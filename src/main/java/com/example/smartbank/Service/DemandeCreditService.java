package com.example.smartbank.Service;

import com.example.smartbank.Entity.DemandeCredit;
import com.example.smartbank.Entity.HistoriqueModification;

import java.time.LocalDate;
import java.util.List;

public interface DemandeCreditService {
     void create(DemandeCredit demande );
     List<DemandeCredit> getAll ();
     DemandeCredit findById (long id);
     void update (DemandeCredit demande);
    void updateStatus (long demande_credit_id, long status_id);
   List<DemandeCredit> getFilteredDemands(long statusId, LocalDate dateDebut);
   List<HistoriqueModification> getHistorique(Long demandeCreditId);
}
