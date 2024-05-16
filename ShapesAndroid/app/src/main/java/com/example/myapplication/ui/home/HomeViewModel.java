package com.example.myapplication.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.myapplication.model.Post;
import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<List<Post>> postList;

    public HomeViewModel() {
        postList = new MutableLiveData<>();
        // Initialize the postList with an empty list or fetch data from database or API
        postList.setValue(new ArrayList<>());
    }

    // Method to set the postList data
    public void setPostList(List<Post> posts) {
        postList.setValue(posts);
    }

    // Method to get the postList LiveData
    public LiveData<List<Post>> getPostList() {
        return postList;
    }


}