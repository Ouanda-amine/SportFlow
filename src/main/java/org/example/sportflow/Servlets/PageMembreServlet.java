package org.example.sportflow.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.sportflow.bean.Membre;

import java.io.IOException;

@WebServlet("/membrePage")
public class PageMembreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("membre") == null) {
            // Rediriger vers la page de connexion si l'utilisateur n'est pas connecté
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        Membre membre = (Membre) session.getAttribute("membre");

        if (membre != null) {
            request.setAttribute("membre", membre);
            request.getRequestDispatcher("membrePage.jsp").forward(request, response);
        } else {
            System.out.println("Erreur : l'objet membre est null.");
            response.sendRedirect(request.getContextPath() + "/login");
        }




    }
}
