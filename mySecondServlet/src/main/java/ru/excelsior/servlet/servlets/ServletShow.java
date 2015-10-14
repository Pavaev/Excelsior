package ru.excelsior.servlet.servlets;

/**
 * Created by Daniel Shchepetov on 14.10.2015.
 */
import ru.excelsior.servlet.entities.User;
import ru.excelsior.servlet.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ServletShow extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>" + "<html>" + "<head>"
                + "<title>Registration</title>" + "<meta charset=\"utf-8\">"
                + "<body>" + "<form method=\"POST\">" + "<p>" + "<input type=\"text\" name=\"email\"> Mail<br>"
                + "<input type=\"text\" name=\"password\">Password</p>"
                + "<p><input type=\"submit\" ></p>" + "<p><input type=\"radio\" value=\"Women\" name=\"sex\"> Man</p>"
                + "<p><input type=\"radio\" value=\"Women\" name=\"sex\"Women</p></body></html>Woman</p>"
                + "<p><input type=\"checkbox\" name=\"checkbox\" style=\"height:10px; width:10px;\">Subscription</input></p><table>");
        ArrayList<User> list = UserRepository.userList();
        for (User user : list) {
            out.println("<tr><td>");
            out.println(user.getEmail());
            out.println("</td><td>");

            out.println(user.getPassword());
            out.println("</td><td>");
            out.println(user.getSex());
            out.println("</td><td>");
            out.println(user.getSubscription());
            out.println("</td>");

        }
        out.println("</table></body></html>");
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }




}