package com.example.smartbank.DAO;

import com.example.smartbank.Entity.DemandeCredit;

import java.util.List;

public interface DemandeCreditDAO {

    DemandeCredit  create(DemandeCredit demande);
    List<DemandeCredit> getAll();
    DemandeCredit findById (long id);
    void updateStatus(DemandeCredit demande);
    void delete (long id);


}
