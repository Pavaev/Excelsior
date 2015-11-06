package ru.excelsior.servlet.utilities;

import ru.excelsior.servlet.entities.User;
import ru.excelsior.servlet.exceptions.IdentifyException;
import ru.excelsior.servlet.repository.UserRepository;

import java.io.FileNotFoundException;

public class UserIdentification {

    public static User identificate(String email, String password) throws IdentifyException, FileNotFoundException {

        for(User user: UserRepository.userList()){
            if (user.getEmail().equals(email)&&(user.getPassword().equals(password))){
                return user;
            }
        }
        throw new IdentifyException("Incorrect email or password");
    }


}
