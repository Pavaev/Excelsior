package ru.excelsior.servlet.repository;

import ru.excelsior.servlet.entities.User;
import ru.excelsior.servlet.exceptions.EmailExistsException;
import ru.excelsior.servlet.exceptions.IncorrectEmailAddressException;
import ru.excelsior.servlet.exceptions.IncorrectPasswordException;
import ru.excelsior.servlet.utilities.DBService;
import ru.excelsior.servlet.utilities.UserService;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserRepository {


    public static void addNewUser(User user) throws IncorrectEmailAddressException, IncorrectPasswordException, FileNotFoundException, EmailExistsException {
        String insert = "INSERT INTO users (email, password, sex, subscription, aboutMyself) VALUES (?,?,?,?,?)";
        Connection connection = DBService.connect();
        if (!emailValidator(user.getEmail())) {
            throw new IncorrectEmailAddressException("Email Is Incorrect");
        }
        if (!passwordChecker(user.getPassword())) {
            throw new IncorrectPasswordException("Password Is Incorrect(4-20 symbols).");
        }

        try {
            PreparedStatement statement = connection.prepareStatement(insert);
            statement.setString(1, user.getEmail());
            statement.setString(2, UserService.md5Apache(user.getPassword()));
            statement.setString(3, user.getSex());
            statement.setString(4, user.getSubscription());
            statement.setString(5, user.getaboutMyself());
            statement.execute();
        } catch (SQLException e) {
            System.err.println("Проблемы с базой данных");
        }

    }

    private static boolean emailValidator(String email) {
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    private static boolean passwordChecker(String password) {
        if (password == null || password.length() < 4 || password.length() > 20) {
            return false;
        }
        return true;
    }

    public static User getUser(String email) throws SQLException {
        String select = "SELECT * FROM users WHERE email = ?;";
        Connection connection = DBService.connect();
        PreparedStatement statement = connection.prepareStatement(select);
        statement.setString(1, email);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            return new User(result.getString("email"), result.getString("password"), result.getString("sex"), result.getString("subscription"), result.getString("aboutMyself"));
        }
        return null;
    }


}

