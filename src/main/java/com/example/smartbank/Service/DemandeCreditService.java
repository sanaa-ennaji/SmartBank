package com.example.smartbank.Service;

import com.example.smartbank.Entity.DemandeCredit;

import java.util.List;

public interface DemandeCreditService {
     DemandeCredit create(DemandeCredit demande );
     List<DemandeCredit> getAll ();
     DemandeCredit findById (long id);
     void update (DemandeCredit demande);
}
