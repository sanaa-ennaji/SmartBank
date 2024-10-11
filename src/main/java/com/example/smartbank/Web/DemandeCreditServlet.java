package com.example.smartbank.Web;

import com.example.smartbank.Entity.DemandeCredit;
import com.example.smartbank.Service.DemandeCreditService;
import com.example.smartbank.Service.DemandeCreditServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


@WebServlet("/demande")
public class DemandeCreditServlet extends HttpServlet {

    private DemandeCreditService demandeCreditService;

    public void init() throws ServletException {
        this.demandeCreditService = new DemandeCreditServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<DemandeCredit> demandes = demandeCreditService.getAll();
        request.setAttribute("demandes", demandes);
        request.getRequestDispatcher("/creditClient.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            double montant = Double.parseDouble(request.getParameter("montant"));
            int duree = Integer.parseInt(request.getParameter("duree"));
            String projet = request.getParameter("projet");
            double mensualites = Double.parseDouble(request.getParameter("mensualites"));
            String email = request.getParameter("email");
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String phone = request.getParameter("phone");
            String CIN = request.getParameter("CIN");
            LocalDate dateDebute = LocalDate.parse(request.getParameter("dateDebute"));
            LocalDate dateNaissance = LocalDate.parse(request.getParameter("dateNaissance"));
            Double total = Double.parseDouble(request.getParameter("total"));
            boolean credit = Boolean.parseBoolean(request.getParameter("credit"));
            DemandeCredit demande = new DemandeCredit();
            demande.setMontant(montant);
            demande.setDuree(duree);
            demande.setProjet(projet);
            demande.setMensualites(mensualites);
            demande.setEmail(email);
            demande.setNom(nom);
            demande.setPrenom(prenom);
            demande.setPhone(phone);
            demande.setCIN(CIN);
            demande.setDateNaissance(dateNaissance);
            demande.setDateDebut(dateDebute);
            demande.setTotal(total);
            demande.setCredit(credit);
            demande.setDateDemande(LocalDate.now());

            demandeCreditService.create(demande);

            response.sendRedirect("demande");
        } catch (Exception e) {

            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input");
        }
    }


}
