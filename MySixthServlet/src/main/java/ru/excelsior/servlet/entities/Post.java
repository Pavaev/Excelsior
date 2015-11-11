package ru.excelsior.servlet.entities;


public class Post {

    private int id;
    private int user_id;
    private String username;
    private String post;


    public Post(int id, int user_id, String username, String post) {
        this.id = id;
        this.username = username;
        this.user_id = user_id;
        this.post = post;

    }
    public Post(int user_id, String username, String post) {

        this.username = username;
        this.user_id = user_id;
        this.post = post;

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
}
