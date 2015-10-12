package ru.excelsior.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


public class ServletForm extends HttpServlet {
    public static final File DAT = new File("D:\\dat.txt");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>" + "<html>" + "<head>"
                + "<title>Registration</title>" + "<meta charset=\"utf-8\">"
                + "<body>" + "<form method=\"POST\">" + "<p>" + "<input type=\"email\" name=\"email\"> Mail<br>"
                + "<input type=\"password\" name=\"password\">Password</p>"
                + "<p><input type=\"submit\" ></p>" + "<p><input type=\"radio\" value=\"Women\" name=\"sex\"> Man</p>"
                + "<p><input type=\"radio\" value=\"Women\" name=\"sex\"Women</p></body></html>Woman</p>"
                + "<p><input type=\"checkbox\" name=\"checkbox\" style=\"height:10px; width:10px;\">Подписка</input></p>"
                + "</body></html>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        saveData(req.getParameter("email"), req.getParameter("password"), req.getParameter("sex"), req.getParameter("checkbox"));
    }

    protected void saveData(String email, String password, String radio, String checkbox) {

        try (FileWriter writer = new FileWriter(DAT, true)) {
            writer.write(email + " ");
            writer.write(password + " ");
            writer.write(radio==null? "not_chosen ": radio+" ");
            writer.write(checkbox==null? "off": checkbox);
            writer.append("\n");

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }


}
