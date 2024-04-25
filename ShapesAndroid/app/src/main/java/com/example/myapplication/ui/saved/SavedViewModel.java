package com.example.myapplication.ui.saved;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SavedViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SavedViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        // Simulated data loading process
        // For demonstration, let's say we're loading saved posts from a repository
        // Replace this with data loading logic
        String peopleData = "saved post data";
        mText.setValue(peopleData);
        return mText;
    }
}