package ru.excelsior.servlet.utilities;

import org.apache.commons.codec.digest.DigestUtils;
import ru.excelsior.servlet.entities.User;
import ru.excelsior.servlet.exceptions.IdentifyException;
import ru.excelsior.servlet.repository.UserRepository;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class UserService {

    public static User identificate(String email, String password) throws IdentifyException, FileNotFoundException, SQLException {

        User user = UserRepository.getUser(email);
        if (user.getPassword().equals(password)) {
            return user;
        }

        throw new IdentifyException("Incorrect email or password");
    }

    public static String md5Apache(String password) {
        String hashedPassword = DigestUtils.md5Hex(password);

        return hashedPassword;
    }


}
