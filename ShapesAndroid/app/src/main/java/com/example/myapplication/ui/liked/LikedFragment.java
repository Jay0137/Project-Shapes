package com.example.myapplication.ui.liked;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ui.post.Post;
import com.example.myapplication.ui.post.PostStorage;

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
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Create an instance of PostStorage
        PostStorage postStorage = new PostStorage(getContext());

        // Retrieve posts
        likedPosts = postStorage.getPosts();

        // Initialize and set adapter
        likedPostAdapter = new LikedPostAdapter(likedPosts);
        recyclerView.setAdapter(likedPostAdapter);

        return view;
    }
}
