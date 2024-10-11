package com.example.smartbank;

import com.example.smartbank.Entity.DemandeCredit;
import com.example.smartbank.Service.DemandeCreditService;
import jakarta.inject.Inject;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import java.util.List;

public class Main {

    @Inject
    private DemandeCreditService demandeCreditService;

    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            Main main = container.select(Main.class).get();


            List<DemandeCredit> demandeCredits = main.demandeCreditService.getAll();


            for (DemandeCredit demandeCredit : demandeCredits) {
                System.out.println(demandeCredit);
            }
        }
    }
}
