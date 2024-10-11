package com.example.smartbank.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "historique_modification")
public class HistoriqueModification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "demande_credit_id", nullable = false)
    private DemandeCredit demandeCredit;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @Column(nullable = false)
    private LocalDate dateModification;

    @Column(nullable = false)
    private String raison;


    public HistoriqueModification() {}

    public HistoriqueModification(DemandeCredit demandeCredit, Status status, LocalDate dateModification, String raison) {
        this.demandeCredit = demandeCredit;
        this.status = status;
        this.dateModification = dateModification;
        this.raison = raison;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DemandeCredit getDemandeCredit() {
        return demandeCredit;
    }

    public void setDemandeCredit(DemandeCredit demandeCredit) {
        this.demandeCredit = demandeCredit;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDateModification() {
        return dateModification;
    }

    public void setDateModification(LocalDate dateModification) {
        this.dateModification = dateModification;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }
}
