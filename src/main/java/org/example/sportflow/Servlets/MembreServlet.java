package org.example.sportflow.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.sportflow.DAO.MembreDAO;
import org.example.sportflow.bean.Entraineur;
import org.example.sportflow.bean.Membre;

import java.io.IOException;
import java.util.List;

@WebServlet("/membre")

public class MembreServlet extends HttpServlet {

    private MembreDAO membreDAO = new MembreDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Membre membre = membreDAO.getmembreBYid(id);
            request.setAttribute("membre", membre);
            request.getRequestDispatcher("modifierMembre.jsp").forward(request, response);

        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            membreDAO.deletemembre(id);
            response.sendRedirect(request.getContextPath() + "/membre");


        }else{
            List<Membre> membreList = membreDAO.getallMembers();
            request.setAttribute("membrelist", membreList);
            request.getRequestDispatcher("ListMembre.jsp").forward(request, response);


        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String action = request.getParameter("action");
        if("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String date = request.getParameter("date");
            String spe = request.getParameter("sportt");
            String role = request.getParameter("role");
            String usern = request.getParameter("username");
            String password = request.getParameter("password");



            Membre membre = new Membre(nom, date ,spe, role, usern, password);
            membre.setId(id);
            membreDAO.modifiermember(membre);

        }else{

        String nom = request.getParameter("nom");
        String date = request.getParameter("date");
        String sportPra = request.getParameter("sport");
        String role = request.getParameter("role");
        String adresse = request.getParameter("username");
        String password = request.getParameter("password");

        Membre membre = new Membre(nom, date, sportPra, role, adresse, password);
        membreDAO.CreateMembre(membre);
        }

        response.sendRedirect(request.getContextPath() + "/membre");






    }
}
