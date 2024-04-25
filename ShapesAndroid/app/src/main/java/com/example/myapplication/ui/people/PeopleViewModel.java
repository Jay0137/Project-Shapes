package com.example.myapplication.ui.people;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PeopleViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PeopleViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        // Simulated data loading process
        // For demonstration, let's say we're loading others users profiles from a repository
        // Replace this with data loading logic
        String peopleData = "Other user's information";
        mText.setValue(peopleData);
        return mText;
    }

    public void updateText(String newText) {
        mText.setValue(newText);
    }
}