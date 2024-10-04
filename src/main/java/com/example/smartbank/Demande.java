package com.example.smartbank;

import com.example.smartbank.DAO.DemandeCreditDAOImpl;
import com.example.smartbank.Service.DemandeCreditServiceImpl;

public class Demande {
    private static final DemandeCreditDAOImpl demandeDAO = new DemandeCreditDAOImpl();


    public static void main(String[] args) {
        DemandeCreditServiceImpl demande = new DemandeCreditServiceImpl(demandeDAO);
        demande.getAll();
    }
}
