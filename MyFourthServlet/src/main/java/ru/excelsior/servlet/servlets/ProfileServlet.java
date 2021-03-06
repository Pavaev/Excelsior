package ru.excelsior.servlet.servlets;





import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        HttpSession session = req.getSession();

        if (session.getAttribute("auth") == null){

            resp.sendRedirect("/auth");

        }else {
            req.setAttribute("user", session.getAttribute("auth"));
            req.getServletContext().getRequestDispatcher("/WEB-INF/views/ProfileServlet.jsp").forward(req,resp);
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("auth", null);
        resp.sendRedirect("/auth");


    }



}