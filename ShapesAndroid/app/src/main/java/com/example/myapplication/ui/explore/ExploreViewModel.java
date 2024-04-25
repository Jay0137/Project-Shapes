package com.example.myapplication.ui.explore;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ExploreViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ExploreViewModel() {
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
}