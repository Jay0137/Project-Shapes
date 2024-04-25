package com.example.myapplication.ui.liked;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LikedFragment extends Fragment {

    private RecyclerView recyclerView;
    private LikedPostAdapter likedPostAdapter;
    private List<Post> likedPosts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_liked, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewLiked);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize likedPosts list
        likedPosts = new ArrayList<>();

        // Add dummy liked posts (Replace with actual liked posts data)
        likedPosts.add(new Post("Post 1", "Content of Post 1", true));
        likedPosts.add(new Post("Post 2", "Content of Post 2", true));
        likedPosts.add(new Post("Post 3", "Content of Post 3", true));

        // Initialize and set adapter
        likedPostAdapter = new LikedPostAdapter(likedPosts);
        recyclerView.setAdapter(likedPostAdapter);

        return view;
    }
}

