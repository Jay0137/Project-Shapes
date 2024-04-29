package com.example.myapplication.ui.liked;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.ui.post.Post;

import java.util.ArrayList;
import java.util.List;

public class LikedViewModel extends ViewModel {

    private MutableLiveData<List<Post>> likedPostsLiveData;
    private List<Post> allPosts; // Assuming you have a list of all posts

    public LiveData<List<Post>> getLikedPosts() {
        if (likedPostsLiveData == null) {
            likedPostsLiveData = new MutableLiveData<>();
            loadLikedPosts(); // Load liked posts when LiveData is first requested
        }
        return likedPostsLiveData;
    }

    private void loadLikedPosts() {
        // Simulate loading of all posts from a data source (e.g., database)
        allPosts = new ArrayList<>();


        // Filter out only the liked posts
        List<Post> likedPosts = new ArrayList<>();
        for (Post post : allPosts) {
            if (post.isLiked()) {
                likedPosts.add(post);
            }
        }

        // Update LiveData with the filtered liked posts
        likedPostsLiveData.setValue(likedPosts);
    }
}
