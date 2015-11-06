package ru.excelsior.servlet.repository;

import ru.excelsior.servlet.entities.User;
import ru.excelsior.servlet.exceptions.EmailExistsException;
import ru.excelsior.servlet.exceptions.IncorrectEmailAddressException;
import ru.excelsior.servlet.exceptions.IncorrectPasswordException;
import ru.excelsior.servlet.utilities.DBService;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserRepository {

    private static final String INSERT = "INSERT INTO users (email, password, sex, subscription, aboutMyself) VALUES (?,?,?,?,?)";


    public static void addNewUser(User user) throws IncorrectEmailAddressException, IncorrectPasswordException, FileNotFoundException, EmailExistsException {
        Connection connection = DBService.connect();
        if (!emailValidator(user.getEmail())) {
            throw new IncorrectEmailAddressException("Email Is Incorrect");
        }
        if (!passwordChecker(user.getPassword())) {
            throw new IncorrectPasswordException("Password Is Incorrect");
        }
        if (userEmailExists(user)) {
            throw new EmailExistsException("Email Is Already Exists");
        }
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
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
        if (password == null || password.length() < 6 || password.length() > 20) {
            return false;
        }
        return true;
    }

    public static ArrayList<User> userList() throws FileNotFoundException {
        ArrayList<User> list = new ArrayList<User>();
        Connection connection = DBService.connect();
        try {
            ResultSet result = connection.createStatement().executeQuery("SELECT email, password, sex, subscription, aboutMyself FROM users");
            while (result.next()) {
                list.add(new User(result.getString("email"), result.getString("password"), result.getString("sex"), result.getString("subscription"), result.getString("aboutMyself")));
            }
        } catch (SQLException e) {
            System.err.println("Проблемы с базой данных");
        }
        return list;
    }


    private static boolean userEmailExists(User currentUser) throws FileNotFoundException {

        ArrayList<User> list = userList();
        for (User user : list) {
            if (user.getEmail() != null && user.getEmail().equals(currentUser.getEmail())) {
                return true;
            }
        }

        return false;
    }
}

