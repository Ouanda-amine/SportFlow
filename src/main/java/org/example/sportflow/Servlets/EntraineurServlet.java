package org.example.sportflow.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.sportflow.DAO.EntraineurDAO;
import org.example.sportflow.bean.Entraineur;

import java.io.IOException;
import java.util.List;

@WebServlet("/trainer")

public class EntraineurServlet extends HttpServlet {

    private EntraineurDAO entraineurDAO = new EntraineurDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Entraineur entraineur = entraineurDAO.gettrainerBYid(id);
            request.setAttribute("entraineur", entraineur);
            request.getRequestDispatcher("modifierEntraineur.jsp").forward(request, response);

        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
           entraineurDAO.deleteTrainer(id);
            response.sendRedirect(request.getContextPath() + "/trainer");


        }else{
            List<Entraineur> entraineurList = entraineurDAO.getallTrainers();
            request.setAttribute("entraineurlist", entraineurList);
            request.getRequestDispatcher("ListEntraineur.jsp").forward(request, response);


        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("name");
            String spe = request.getParameter("spe");
            String role = request.getParameter("role");
            String usern = request.getParameter("username");
            String password = request.getParameter("password");



            Entraineur entraineur = new Entraineur(nom, spe, role, usern, password);
            entraineur.setIdent(id);
            entraineurDAO.modifierTrainer(entraineur);

        }else{

        String nom = request.getParameter("name");
        String spe = request.getParameter("spe");
        String role = request.getParameter("role");
        String usern = request.getParameter("usernamee");
        String password = request.getParameter("passwordd");

        Entraineur entraineur = new Entraineur(nom, spe, role, usern, password);

        entraineurDAO.CreateTrainer(entraineur);
        }

        response.sendRedirect(request.getContextPath() + "/trainer");





    }


}
