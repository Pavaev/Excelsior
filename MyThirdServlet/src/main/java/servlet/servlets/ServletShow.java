package servlet.servlets;

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
import java.util.ArrayList;

public class ServletShow extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        ArrayList<User> list = UserRepository.userList();

        req.setAttribute("list", list);
        req.getServletContext().getRequestDispatcher("/WEB-INF/views/ServletShow.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }




}