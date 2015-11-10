package ru.excelsior.servlet.entities;

/**
 * Created by Daniel Shchepetov on 13.10.2015.
 */
public class User {
    private int idusers;
    private String email;
    private String password;
    private String sex;
    private String subscription;
    private String aboutMyself;

    public User( String email, String password, String sex, String subscription, String aboutMyself) {

        this.email = email;
        this.password = password;
        this.sex = sex;
        this.subscription = subscription;
        this.aboutMyself = aboutMyself;
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

    public String getaboutMyself() {
        return aboutMyself;
    }

    public void setaboutMyself(String aboutMyself) {
        this.aboutMyself = aboutMyself;
    }

    public int getIdusers() {
        return idusers;
    }

    public void setIdusers(int idusers) {
        this.idusers = idusers;
    }
}
