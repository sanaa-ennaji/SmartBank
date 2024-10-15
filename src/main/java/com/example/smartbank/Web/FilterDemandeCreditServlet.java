package com.example.smartbank.Web;

import com.example.smartbank.Service.DemandeCreditService;
import com.example.smartbank.Service.DemandeCreditServiceImpl;
import com.example.smartbank.Entity.DemandeCredit;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/filterDemandeCredits")
public class FilterDemandeCreditServlet extends HttpServlet {

    @Inject
    private DemandeCreditService demandeCreditService;

    @Override
    public void init() throws ServletException {
        super.init();
        demandeCreditService = new DemandeCreditServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        String dateDebut = request.getParameter("dateDebut");

        List<DemandeCredit> filteredDemandes = null;

        if (status != null && !status.isEmpty() && dateDebut != null && !dateDebut.isEmpty()) {
            filteredDemandes = demandeCreditService.filterByStatusAndDateDebut(status, dateDebut);
        } else {
            filteredDemandes = demandeCreditService.getAll();
        }


        request.setAttribute("demandes", filteredDemandes);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/demandeCreditList.jsp");
        dispatcher.forward(request, response);
    }
}
