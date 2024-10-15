package com.example.smartbank.Web;

import com.example.smartbank.Service.DemandeCreditService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/updateStatus")
public class updateStatus extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Inject
    private DemandeCreditService demandeCreditService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long demandeCreditId = Long.parseLong(request.getParameter("demande_credit_id"));
        long statusId = Long.parseLong(request.getParameter("status_id"));

        try {

            demandeCreditService.updateStatus(demandeCreditId, statusId);

            response.sendRedirect("successPage.jsp");
        } catch (Exception e) {

            e.printStackTrace();
            response.sendRedirect("errorPage.jsp");
        }
    }
}
