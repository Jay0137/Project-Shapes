package com.example.myapplication.model;

public class Post {
    private int userId;
    private static String username;
    private String text;
    private String imagePath;
    private String date;

    public Post(int userId, String text, String imagePath, String date) {
        this.userId = userId;
        this.text = text;
        this.imagePath = imagePath;
        this.date = date;
    }

    public static String getUsername() {
        return username;
    }

    // Add getters and setters here
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
