package ru.excelsior.servlet.repository;

import ru.excelsior.servlet.entities.User;
import ru.excelsior.servlet.exceptions.EmailExistsException;
import ru.excelsior.servlet.exceptions.IncorrectEmailAddressException;
import ru.excelsior.servlet.exceptions.IncorrectPasswordException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Daniel Shchepetov on 14.10.2015.
 */
public class UserRepository {
    public static final File DAT = new File("D:\\dat.txt");

    public static void addNewUser(User user) throws IncorrectEmailAddressException, IncorrectPasswordException, FileNotFoundException, EmailExistsException {
        if (!emailValidator(user.getEmail())) {
            throw new IncorrectEmailAddressException("Email Is Incorrect");
        }
        if (!passwordChecker(user.getPassword())) {
            throw new IncorrectPasswordException("Password Is Incorrect");
        }
        if (userEmailExists(user)) {
            throw new EmailExistsException("Email Is Already Exists");
        }
        try (FileWriter writer = new FileWriter(DAT, true)) {
            writer.write(user.getEmail() + " ");
            writer.write(user.getPassword() + " ");
            writer.write(user.getSex() == null ? "not_chosen " : user.getSex() + " ");
            writer.write(user.getSubscription() == null ? "off" : user.getSubscription());
            writer.append("\n");

        } catch (IOException ex) {

            ex.printStackTrace();
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
        Scanner scan = new Scanner(DAT);

        while (scan.hasNext()) {

            User user = new User(scan.next(), scan.next(), scan.next(), scan.next());  //email, password, sex, subscription
            list.add(user);

        }
        return list;

    }


    private static boolean userEmailExists(User user) throws FileNotFoundException {
        Scanner scan = new Scanner(DAT);

        while (scan.hasNext()) {
            int i = 0;
            String email = scan.next();
            if (user.getEmail().equals(email)) {
                return true;
            } else while (scan.hasNext() && i < 3) {
                scan.next();
                i++;
            }
        }

        return false;
    }
}

