package ru.excelsior.servlet.entities;

/**
 * Created by Daniel Shchepetov on 13.10.2015.
 */
public class User {

    private String email;
    private String password;
    private String sex;
    private String subscription;

    public User(String email, String password, String sex, String subscription) {
        this.email = email;
        this.password = password;
        this.sex = sex;
        this.subscription = subscription;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }
}
