package com.example.myapplication.ui.addpost;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddPostViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AddPostViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        // Simulated data loading process
        // For demonstration, let's say we're loading unfollow users posts from a repository
        // Replace this with data loading logic
        String peopleData = "unfollow post data";
        mText.setValue(peopleData);
        return mText;
    }

    public void createPost(String postContent) {
        // You can implement the logic here to save the post to your data source
        // For demonstration purposes, let's just print the post content for now
        System.out.println("New Post: " + postContent);
    }
}