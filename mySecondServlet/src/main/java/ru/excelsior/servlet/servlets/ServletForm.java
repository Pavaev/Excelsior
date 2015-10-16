package ru.excelsior.servlet.servlets;

import ru.excelsior.servlet.entities.User;
import ru.excelsior.servlet.exceptions.EmailExistsException;
import ru.excelsior.servlet.exceptions.IncorrectEmailAdressException;
import ru.excelsior.servlet.exceptions.IncorrectPasswordException;
import ru.excelsior.servlet.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletForm extends HttpServlet {

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
                + "<p><input type=\"checkbox\" name=\"checkbox\" style=\"height:10px; width:10px;\">Subscription</input></p>"
                + "</body></html>" );
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String sex = req.getParameter("radio");
        String checkbox = req.getParameter("checkbox");

        try {
            UserRepository.addNewUser(new User(email, password, sex, checkbox == null ? "off" : "on"));
        } catch (EmailExistsException ex) {

            resp.sendRedirect("/Panaev?error=user");

            return;
        } catch (IncorrectPasswordException ex) {

            resp.sendRedirect("/Panaev?error=password");

            return;
        } catch (IncorrectEmailAdressException ex) {

            resp.sendRedirect("/Panaev?error=email");

            return;
        }
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>" + "<html>" + "<head>"
                + "<title>Registration</title>" + "<meta charset=\"utf-8\">"
                + "<body>" + "<form method=\"POST\">" + "<p>" + "<input type=\"text\" name=\"email\"> Mail<br>"
                + "<input type=\"text\" name=\"password\">Password</p>"
                + "<p><input type=\"submit\" ></p>" + "<p><input type=\"radio\" value=\"Women\" name=\"sex\"> Man</p>"
                + "<p><input type=\"radio\" value=\"Women\" name=\"sex\"Women</p></body></html>Woman</p>"
                + "<p><input type=\"checkbox\" name=\"checkbox\" style=\"height:10px; width:10px;\">Subscription</input></p>"
                + "</body></html>");
        resp.sendRedirect("/Panaev?status=1");
    }
}
