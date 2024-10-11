package com.example.smartbank.Service;

import com.example.smartbank.DAO.DemandeCreditDAO;
import com.example.smartbank.Entity.DemandeCredit;
import jakarta.inject.Inject;

import java.util.List;

public class DemandeCreditServiceImpl implements DemandeCreditService {

    @Inject
    public DemandeCreditDAO demandeCreditDAOImpl;

    @Override
    public DemandeCredit create(DemandeCredit demande) {
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
