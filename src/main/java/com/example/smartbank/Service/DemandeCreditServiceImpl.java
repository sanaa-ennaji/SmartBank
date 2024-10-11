package com.example.smartbank.Service;

import com.example.smartbank.DAO.DemandeCreditDAO;
import com.example.smartbank.DAO.DemandeCreditDAOImpl;
import com.example.smartbank.Entity.DemandeCredit;

import java.util.List;

public class DemandeCreditServiceImpl implements DemandeCreditService {

    public DemandeCreditDAO demandeCreditDAOImpl;

    public DemandeCreditServiceImpl() {
        this.demandeCreditDAOImpl = new DemandeCreditDAOImpl();
    }

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
