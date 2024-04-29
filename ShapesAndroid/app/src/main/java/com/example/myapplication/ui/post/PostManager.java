package com.example.myapplication.ui.post;

import java.util.ArrayList;
import java.util.List;

public class PostManager {
    private List<Post> posts = new ArrayList<>();
    private int nextId = 1;

    public void createPost(int id, String title, String content, boolean liked) {
        Post post = new Post(nextId, title, content, liked);
        posts.add(post);
        id = nextId++;
    }

    public List<Post> getAllPosts() {
        return posts;
    }

    public Post getPostById(int id) {
        for (Post post : posts) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null; // Post not found
    }
}
