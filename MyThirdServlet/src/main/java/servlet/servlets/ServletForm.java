package servlet.servlets;

import ru.excelsior.servlet.entities.User;
import ru.excelsior.servlet.exceptions.EmailExistsException;
import ru.excelsior.servlet.exceptions.IncorrectEmailAddressException;
import ru.excelsior.servlet.exceptions.IncorrectPasswordException;
import ru.excelsior.servlet.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ServletForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        if (req.getParameter("status") != null) {
            if (req.getParameter("status").equals("true")) req.setAttribute("message", "User created");
        }
        req.getServletContext().getRequestDispatcher("/WEB-INF/views/ServletForm.jsp").forward(req, resp);

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
            resp.sendRedirect(req.getRequestURI()+"?status=true");
            req.getServletContext().getRequestDispatcher("/WEB-INF/views/ServletForm.jsp").forward(req, resp);

        } catch (EmailExistsException | IncorrectPasswordException| IncorrectEmailAddressException ex) {

          req.setAttribute("message", ex.getMessage());
            req.getServletContext().getRequestDispatcher("/WEB-INF/views/ServletForm.jsp").forward(req, resp);
        }


    }
}
