package ru.excelsior.servlet.entities;


import java.util.Calendar;

public class Post {

    private int id;
    private int user_id;
    private String username;
    private String post;
    private String date;


    public Post(int id, int user_id, String username, String post, String date) {
        this.id = id;
        this.username = username;
        this.user_id = user_id;
        this.post = post;
        this.date = date;


    }

    public Post(int user_id, String username, String post) {

        this.username = username;
        this.user_id = user_id;
        this.post = post;


    }

    public String today() {

        Calendar calendar = Calendar.getInstance();
        String today = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
        return today;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
