package com.example.myapplication.database.posts;

import android.content.Context;

import com.example.myapplication.model.Post;

import java.util.List;

public class PostRepository {
    private PostDAO postDAO;

    public PostRepository(Context context) {
        postDAO = new PostDAO(context);
    }

    public List<Post> getAllPosts() {
        return postDAO.getAllPosts();
    }
}
