package com.example.myapplication.ui.post;

public class Post {
    private int id;
    private String title;
    private String content;
    private boolean liked;

    public Post(int id, String title, String content, boolean liked) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.liked = liked;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public void saved() {
        // Implement logic to save the post to a database or file
        // Example:
        // Database.savePost(this); // Assuming Database is a class with a method to save posts
        // or
        // FileUtil.saveToFile(this); // Assuming FileUtil is a class with a method to save objects to a file

    }
}
