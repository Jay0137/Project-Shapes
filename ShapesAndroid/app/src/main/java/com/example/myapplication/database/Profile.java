package com.example.myapplication.database;

public class Profile {
    private String profilePicture;
    private String bio;

    public Profile(String profilePicture, String bio) {
        this.profilePicture = profilePicture;
        this.bio = bio;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getBio() {
        return bio;
    }
}