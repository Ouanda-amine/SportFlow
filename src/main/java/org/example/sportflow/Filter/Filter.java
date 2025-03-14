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

        if (uri.equals(httpRequest.getContextPath() + "/") || uri.equals(httpRequest.getContextPath())) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }

        if (uri.endsWith("login") || uri.contains("/css/") || uri.contains("/js/")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (uri.startsWith(httpRequest.getContextPath() + "/admin")) {
            if (session == null || session.getAttribute("admin") == null) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login"); // Redirection vers la page login
                return;
            }
        }

        if (uri.startsWith(httpRequest.getContextPath() + "/membre")) {
            if (session == null || session.getAttribute("membre") == null) {
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


        if (uri.endsWith("home")) {
            if (session == null || (session.getAttribute("admin") == null && session.getAttribute("membre") == null)) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login"); // Redirection vers la page login
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

}