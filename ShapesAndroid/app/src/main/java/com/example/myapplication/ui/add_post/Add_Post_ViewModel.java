package com.example.myapplication.ui.add_post;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Add_Post_ViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public Add_Post_ViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}