package com.example.smartbank.Web;

import com.example.smartbank.Service.DemandeCreditService;
import com.example.smartbank.Entity.HistoriqueModification;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/historiqueDemande")
public class HistoriqueModificationServlet extends HttpServlet {

    @Inject
    private DemandeCreditService demandeCreditService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String demandeCreditIdStr = req.getParameter("demandeCreditId");
        if (demandeCreditIdStr == null || demandeCreditIdStr.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "demandeCreditId is required");
            return;
        }

        try {
            Long demandeCreditId = Long.parseLong(demandeCreditIdStr);


            List<HistoriqueModification> historiqueList = demandeCreditService.getHistorique(demandeCreditId);

            req.setAttribute("historiqueList", historiqueList);

            req.getRequestDispatcher("historique.jsp").forward(req, resp);

        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid demandeCreditId format");
        }
    }
}
