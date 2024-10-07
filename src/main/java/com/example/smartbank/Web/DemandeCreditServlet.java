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
        double montant = Double.parseDouble(request.getParameter("montant"));
        int duree = Integer.parseInt(request.getParameter("duree"));
        String etat = request.getParameter("etat");
        String remarques = request.getParameter("remarques");

        demandeCreditService.create(montant, duree, etat, remarques);
        response.sendRedirect("demande");
    }
}
