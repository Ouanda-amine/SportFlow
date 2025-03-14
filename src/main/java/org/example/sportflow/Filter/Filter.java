package org.example.sportflow.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class Filter implements jakarta.servlet.Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        jakarta.servlet.Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String uri = httpRequest.getRequestURI();
        HttpSession session = httpRequest.getSession(false);

        // Redirection vers la page de connexion si la racine du site est accédée
        if (uri.equals(httpRequest.getContextPath() + "/") || uri.equals(httpRequest.getContextPath())) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }

        // Autoriser l'accès à la page de connexion et aux ressources publiques (CSS, JS)
        if (uri.endsWith("login") || uri.contains("/css/") || uri.contains("/js/")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // Vérification si l'utilisateur est connecté en tant qu'admin
        if (uri.startsWith(httpRequest.getContextPath() + "/admin")) {
            if (session == null || session.getAttribute("admin") == null) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login"); // Redirection vers la page login
                return;
            }
        }

        // Vérification si l'utilisateur est connecté en tant que membre
        if (uri.startsWith(httpRequest.getContextPath() + "/membre")) {
            if (session == null || session.getAttribute("user") == null) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login"); // Redirection vers la page login
                return;
            }
        }

        if (uri.startsWith(httpRequest.getContextPath() + "/trainer")) {
            if (session == null || session.getAttribute("entr") == null) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login"); // Redirection vers la page login
                return;
            }
        }


        // Gestion générale (par exemple, page d'accueil)
        if (uri.endsWith("home")) {
            if (session == null || (session.getAttribute("admin") == null && session.getAttribute("user") == null)) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login"); // Redirection vers la page login
                return;
            }
        }

        // Continuer la chaîne de filtres pour toutes les autres requêtes
        filterChain.doFilter(servletRequest, servletResponse);
    }

}