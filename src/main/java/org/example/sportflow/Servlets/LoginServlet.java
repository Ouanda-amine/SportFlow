package org.example.sportflow.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.sportflow.DAO.AdminDAO;
import org.example.sportflow.DAO.EntraineurDAO;
import org.example.sportflow.DAO.MembreDAO;
import org.example.sportflow.bean.Admin;
import org.example.sportflow.bean.Entraineur;
import org.example.sportflow.bean.Membre;

import java.io.IOException;

@WebServlet("/login")

public class LoginServlet  extends HttpServlet {

    private AdminDAO adminDAO = new AdminDAO();
    private MembreDAO membreDAO = new MembreDAO();
    private EntraineurDAO entraineurDAO = new EntraineurDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("login.jsp").forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Admin admin = adminDAO.getAdmin(username, password);

        if (admin != null) {

            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);

            response.sendRedirect(request.getContextPath() + "/home");

            return;
        }
        Membre membre = membreDAO.getmembreInfos(username, password);
        if (membre != null) {
            HttpSession session = request.getSession();
            session.setAttribute("membre", membre);

            response.sendRedirect(request.getContextPath() + "/membrePage");
            return;
        }
        Entraineur entraineur = entraineurDAO.getTrainerInfos(username, password);
        if (entraineur != null) {
            HttpSession session = request.getSession();
            session.setAttribute("entr", entraineur);

            response.sendRedirect(request.getContextPath() + "/trainerPage");
            return;
        }





            request.setAttribute("errorMessage", "Nom d'utilisateur ou mot de passe invalide.");
            request.getRequestDispatcher("login.jsp").forward(request, response);

    }


}
