package org.example.sportflow.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.sportflow.bean.Entraineur;
import org.example.sportflow.bean.Membre;

import java.io.IOException;
@WebServlet("/trainerPage")
public class PageEntraineurServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("entr") == null) {
            // Rediriger vers la page de connexion si l'utilisateur n'est pas connecté
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        Entraineur entraineur = (Entraineur) session.getAttribute("entr");

        if (entraineur != null) {
            request.setAttribute("entr", entraineur);
            request.getRequestDispatcher("entraineurPage.jsp").forward(request, response);
        } else {
            System.out.println("Erreur : l'objet membre est null.");
            response.sendRedirect(request.getContextPath() + "/login");
        }




    }
}
