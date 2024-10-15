package com.example.smartbank.Service;

import com.example.smartbank.Entity.DemandeCredit;

import java.time.LocalDate;
import java.util.List;

public interface DemandeCreditService {
     DemandeCredit create(DemandeCredit demande );
     List<DemandeCredit> getAll ();
     DemandeCredit findById (long id);
     void update (DemandeCredit demande);
    void updateStatus (long demande_credit_id, long status_id);
   List<DemandeCredit> getFilteredDemands(long statusId, LocalDate dateDebut);
}
