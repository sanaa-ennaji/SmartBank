package com.example.smartbank.DAO;

import com.example.smartbank.Entity.DemandeCredit;

import java.time.LocalDate;
import java.util.List;

public interface DemandeCreditDAO {

    DemandeCredit  create(DemandeCredit demande);
    List<DemandeCredit> getAll();
    DemandeCredit findById (long id);
    void update(DemandeCredit demande);
    void delete (long id);
    void updateStatus(long demande_credit_id, long status_id);
   List<DemandeCredit> getFilteredDemands(Long statusId, LocalDate dateDebut);


}
