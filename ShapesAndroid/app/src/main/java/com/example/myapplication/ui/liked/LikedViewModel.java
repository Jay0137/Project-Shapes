package com.example.myapplication.ui.liked;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class LikedViewModel extends ViewModel {

    private MutableLiveData<List<Post>> likedPostsLiveData;
    private List<Post> likedPosts;

    public LiveData<List<Post>> getLikedPosts() {
        if (likedPostsLiveData == null) {
            likedPostsLiveData = new MutableLiveData<>();
            loadLikedPosts(); // Load liked posts when LiveData is first requested
        }
        return likedPostsLiveData;
    }

    private void loadLikedPosts() {
        // Simulate loading of liked posts from a data source (e.g., database)
        likedPosts = new ArrayList<>();
        // Add dummy liked posts (Replace with actual liked posts data)
        likedPosts.add(new Post("Post 1", "Content of Post 1", true));
        likedPosts.add(new Post("Post 2", "Content of Post 2", true));
        likedPosts.add(new Post("Post 3", "Content of Post 3", true));
        // Update LiveData with the loaded data
        likedPostsLiveData.setValue(likedPosts);
    }
}
