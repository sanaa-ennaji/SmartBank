package com.example.smartbank;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/", "/admin", "/profile"})
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        switch (path) {
            case "/demande":
                request.getRequestDispatcher("/Admin.jsp").forward(request, response);
                break;
            case "/profile":
                request.getRequestDispatcher("/profile.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
        }
    }

    @Override
    public void destroy() {

    }
}
