package com.example.myapplication.database;

public class UserDetails {
    private String username;
    private String createdAt;
    private String profilePicture;
    private String bio;

    // Constructor
    public UserDetails(String username, String createdAt, String profilePicture, String bio) {
        this.username = username;
        this.createdAt = createdAt;
        this.profilePicture = profilePicture;
        this.bio = bio;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getBio() {
        return bio;
    }
}
