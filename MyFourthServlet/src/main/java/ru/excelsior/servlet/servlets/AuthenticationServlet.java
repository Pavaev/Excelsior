package ru.excelsior.servlet.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import ru.excelsior.servlet.exceptions.IdentifyException;
import ru.excelsior.servlet.utilities.UserIdentification;
import ru.excelsior.servlet.entities.User;


public class AuthenticationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        if (session.getAttribute("auth") == null) {
            req.getServletContext().getRequestDispatcher("/WEB-INF/views/AuthenticationServlet.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/myprofile");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {

            User user = UserIdentification.identificate(email, password);
            session.setAttribute("auth",user);
            resp.sendRedirect("/myprofile");
            return;
        } catch ( IdentifyException ex) {
            req.setAttribute("message", ex.getMessage());
        }
        req.getServletContext().getRequestDispatcher("/WEB-INF/views/AuthenticationServlet.jsp").forward(req, resp);
    }
}