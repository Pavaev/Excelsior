package ru.excelsior.servlet.servlets;


import ru.excelsior.servlet.entities.Post;
import ru.excelsior.servlet.repository.PostRepository;
import ru.excelsior.servlet.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


public class PostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        if (session.getAttribute("auth") == null) {

            resp.sendRedirect("/auth");

        } else {

            ArrayList<Post> list = PostRepository.postList();

            req.setAttribute("list", list);
            req.getServletContext().getRequestDispatcher("/WEB-INF/views/PostServlet.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        HttpSession session = req.getSession();

        String posts = req.getParameter("post");


        User user = (User) session.getAttribute("auth");

        String username = user.getEmail();

        int user_id = user.getId();
        Post post = new Post(user_id, username, posts);
        post.setDate(post.today());
        PostRepository.addNewPost(post);
        resp.sendRedirect("/myprofile/post");
    }
}