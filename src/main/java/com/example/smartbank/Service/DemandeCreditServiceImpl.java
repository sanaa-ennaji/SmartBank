package com.example.smartbank.Service;

import com.example.smartbank.DAO.DemandeCreditDAO;
import com.example.smartbank.Entity.DemandeCredit;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class DemandeCreditServiceImpl implements DemandeCreditService {

    @Inject
    private DemandeCreditDAO demandeCreditDAOImpl;

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

    @Override
    public void  updateStatus (long demande_credit_id, long status_id){

        demandeCreditDAOImpl.updateStatus(demande_credit_id , status_id);
    }

}
