package com.example.myapplication.database;

public class Post {
    private int pId;
    private int userId;
    private String pText;
    private String imagePath;
    private String Cdate;

    public Post(int postId, int userId, String postText, String imagePath, String date) {
        this.pId = postId;
        this.userId = userId;
        this.pText = postText;
        this.imagePath = imagePath;
        this.Cdate = date;
    }

    // Getter methods
}
