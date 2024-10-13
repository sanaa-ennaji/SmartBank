package com.example.smartbank.Web;

import com.example.smartbank.Entity.DemandeCredit;
import com.example.smartbank.Service.DemandeCreditService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class DemandeCreditServlet extends HttpServlet {

    @Inject
    private DemandeCreditService demandeCreditService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<DemandeCredit> demandes = demandeCreditService.getAll();
        request.setAttribute("demandes", demandes);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String montantParam = request.getParameter("montant");
            String dureeParam = request.getParameter("duree");
            String mensualitesParam = request.getParameter("mensualites");
            String email = request.getParameter("email");
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String civilite = request.getParameter("civilite");
            String phone = request.getParameter("phone");
            String CIN = request.getParameter("CIN");
            String dateDebuteParam = request.getParameter("dateDebute");
            String dateNaissanceParam = request.getParameter("dateNaissance");
            String totalParam = request.getParameter("total");
            String creditParam = request.getParameter("credit");


            if (montantParam == null ) {
                throw new IllegalArgumentException("Missing required parameters1");
            }

            if (dureeParam == null ) {
                throw new IllegalArgumentException("Missing required parameters 2.");
            }

            if (mensualitesParam == null ) {
                throw new IllegalArgumentException("Missing required parameters 3.");
            }


            double montant = Double.parseDouble(montantParam.trim());
            int duree = Integer.parseInt(dureeParam.trim());
            double mensualites = Double.parseDouble(mensualitesParam.trim());
            LocalDate dateDebute = LocalDate.parse(dateDebuteParam);
            LocalDate dateNaissance = LocalDate.parse(dateNaissanceParam);
            Double total = Double.parseDouble(totalParam.trim());
            boolean credit = Boolean.parseBoolean(creditParam);

            DemandeCredit demande = new DemandeCredit();
            demande.setMontant(montant);
            demande.setDuree(duree);
            demande.setProjet(request.getParameter("projet"));
            demande.setJob(request.getParameter("job"));
            demande.setMensualites(mensualites);
            demande.setEmail(email);
            demande.setNom(nom);
            demande.setPrenom(prenom);
            demande.setCivilite(civilite);
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
