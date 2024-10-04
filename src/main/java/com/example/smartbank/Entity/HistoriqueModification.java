package com.example.smartbank.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "historique_modification")
public class HistoriqueModification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    @Column(nullable = false)
    private LocalDate dateModification;

    @Column(nullable = false)
    private String etatPrecedent ;

    @Column(nullable = false)
    private String nouvelEtat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "demande_credit_id" , nullable = false)
    private DemandeCredit demandeCredit ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEtatPrecedent() {
        return etatPrecedent;
    }

    public void setEtatPrecedent(String etatPrecedent) {
        this.etatPrecedent = etatPrecedent;
    }

    public LocalDate getDateModification() {
        return dateModification;
    }

    public void setDateModification(LocalDate dateModification) {
        this.dateModification = dateModification;
    }

    public String getNouvelEtat() {
        return nouvelEtat;
    }

    public void setNouvelEtat(String nouvelEtat) {
        this.nouvelEtat = nouvelEtat;
    }

    public DemandeCredit getDemandeCredit() {
        return demandeCredit;
    }

    public void setDemandeCredit(DemandeCredit demandeCredit) {
        this.demandeCredit = demandeCredit;
    }

}
