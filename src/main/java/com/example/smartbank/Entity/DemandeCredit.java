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

    @Column(nullable = false )
    private String projet ;

    @Column(nullable = false)
    private String  job ;

    @Column(nullable = false)
    private LocalDate dateDemande;

    @Column(nullable = false)
    private double montant;

    @Column(nullable = false)
    private int duree;

    @Column(nullable = false)
    private double mensualites ;

    @Column(nullable = false)
    private String email ;

    @Column( nullable = false)
    private String phone ;

    @Column( nullable = false)
    private String nom ;

    @Column( nullable = false)
    private String prenom ;

    @Column( nullable = false)
    private String CIN ;

    @Column( nullable = false)
    private LocalDate dateNaissance ;

    @Column( nullable = false)
    private LocalDate dateDebut ;

    @Column( nullable = false)
    private Double total;

    @Column( nullable = false)
    private boolean  credit ;

     // @Column(nullable = false)
     //  private String etat;

   //  @Column
   // private String remarques;

//    @OneToMany(mappedBy = "demandeCredit", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<HistoriqueModification> historiques = new ArrayList<>();


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

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getMontant() {
        return montant;
    }

    public double getMensualites() {
        return mensualites;
    }

    public void setMensualites(double mensualites) {
        this.mensualites = mensualites;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        total = total;
    }

    public boolean isCredit() {
        return credit;
    }

    public void setCredit(boolean credit) {
        this.credit = credit;
    }

//    public List<HistoriqueModification> getHistoriques() {
//        return historiques;
//    }
//
//    public void setHistoriques(List<HistoriqueModification> historiques) {
//        this.historiques = historiques;
//    }

}
