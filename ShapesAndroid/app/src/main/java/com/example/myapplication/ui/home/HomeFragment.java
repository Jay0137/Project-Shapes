package com.example.myapplication.ui.home;

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
import com.example.myapplication.adapters.PostAdapter;
import com.example.myapplication.database.posts.PostRepository;
import com.example.myapplication.model.Post;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private PostRepository postRepository;
    private PostAdapter postAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        postRepository = new PostRepository(requireContext());

        // Initialize RecyclerView and Adapter
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        postAdapter = new PostAdapter(requireContext(), new ArrayList<>());
        recyclerView.setAdapter(postAdapter);

        // Get all posts from the repository
        List<Post> posts = postRepository.getAllPosts();

        // Update the adapter with the retrieved posts
        if (posts != null) {
            postAdapter.setPostList(posts);
        }

        return rootView;
    }
}
