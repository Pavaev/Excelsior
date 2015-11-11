package ru.excelsior.servlet.repository;


import ru.excelsior.servlet.entities.Post;
import ru.excelsior.servlet.entities.User;
import ru.excelsior.servlet.utilities.DBService;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostRepository {

    public static void addNewPost(Post post) {
        String insert = "INSERT INTO posts (user_id, username, post, date) VALUES (?,?,?,?)";
        Connection connection = DBService.connect();

        try {
            PreparedStatement statement = connection.prepareStatement(insert);
            statement.setInt(1, post.getUser_id());
            statement.setString(2, post.getUsername());
            statement.setString(3, post.getPost());
            statement.setString(4, post.getDate());
            statement.execute();
        } catch (SQLException e) {
            System.err.println("Проблемы с базой данных");
        }

    }

    public static ArrayList<Post> postList() {
        ArrayList<Post> list = new ArrayList<Post>();
        Connection connection = DBService.connect();
        try {
            ResultSet result = connection.createStatement().executeQuery("SELECT * FROM posts");
            while (result.next()) {
                int id = result.getInt(1);
                int user_id = result.getInt(2);
                String post = result.getString(3);
                String username = result.getString(4);
                String date = result.getString(5);


                list.add(new Post(id, user_id, username, post, date));
            }


        } catch (SQLException e) {
            System.err.println("Проблемы с базой данных");
        }
        return list;
    }
}
