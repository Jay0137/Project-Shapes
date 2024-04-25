package com.example.myapplication.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {
    private MutableLiveData<String> userProfileLiveData;

    public ProfileViewModel() {
        userProfileLiveData = new MutableLiveData<>();
        // Initialize or fetch user profile data here
        loadUserProfile();
    }

    public LiveData<String> getText() {
        return userProfileLiveData;
    }

    private void loadUserProfile() {
        // Simulated data loading process
        // For demonstration, let's say we're loading user profile from a repository
        // Replace this with data loading logic
        String userProfileData = "User's profile information";
        userProfileLiveData.setValue(userProfileData);
    }
}
