package com.example.smartbank;

import com.example.smartbank.DAO.DemandeCreditDAOImpl;
import com.example.smartbank.Service.DemandeCreditServiceImpl;

public class Demande {



    public static void main(String[] args) {
        DemandeCreditServiceImpl demande = new DemandeCreditServiceImpl();
        demande.getAll();
    }
}
