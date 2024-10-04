package com.example.smartbank.Entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "demande_credit")
public class DemandeCredit {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private double montant;

    @Column(nullable = false)
    private int duree;

    @Column(nullable = false)
    private LocalDate dateDemande;

    @Column(nullable = false)
    private String etat;

    @Column
    private String remarques;

    @OneToMany(mappedBy = "demandeCredit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistoriqueModification> historiques = new ArrayList<>();


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setMontant(double montant) {
        this.montant = montant;

    }

    public double montant() {
        return montant;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getDuree() {
        return duree;
    }

    public void setDateDemande(LocalDate dateDemande) {
        this.dateDemande = dateDemande;
    }

    public LocalDate getDateDemande() {
        return dateDemande;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setRemarques(String Remarques) {
        this.remarques = remarques;
    }

    public String getRemarques() {
        return remarques;
    }

}
