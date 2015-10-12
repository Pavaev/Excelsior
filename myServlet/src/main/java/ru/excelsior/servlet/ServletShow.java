package ru.excelsior.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ServletShow extends HttpServlet {


    protected ArrayList<String> datSection()throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        Scanner scan = new Scanner(ServletForm.DAT);
        while(scan.hasNext()==true) {
            list.add(scan.next());
        }
        return list;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>" + "<html>" + "<head>"
                + "<title>Table</title>" + "<meta charset=\"utf-8\">"
                + "<body><table cellpadding=\"8\" border=\"5\">"
                + "<tr><th>email</th><th>password</th><th>sex</th><th>subscription</th></tr>");


        ArrayList<String> list = datSection();
                int q =0;
        for (int i = 0; i < list.size(); i++) {
            out.println("<tr>");
            for (int j = 0; j < 4; j++) {
                out.println("<td>" + list.get(q++) + "</td>");
            }
            out.println("</tr>");
        }
        out.println("</table></body></html>");
        out.close();

    }


}


