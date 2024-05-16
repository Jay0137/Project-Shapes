package com.example.myapplication.ui.explore;

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
import com.example.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends Fragment {


    private PostRepository postRepository;
    private PostAdapter postAdapter;

    private List<User> userList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_explore, container, false);

        postRepository = new PostRepository(requireContext());

        // Initialize RecyclerView and Adapter
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerViewExplore);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        postAdapter = new PostAdapter(requireContext(), new ArrayList<>());
        recyclerView.setAdapter(postAdapter);

        // Get all posts from the repository
        List<Post> posts = postRepository.getAllPosts();

        // Fetch user data (this is just a dummy implementation)
        fetchUserData();

        // Update the adapter with the retrieved posts
        if (posts != null) {
            postAdapter.setPostList(posts);
        }

        return rootView;
    }

    private void fetchUserData() {
        userList = new ArrayList<>();
        // Fetch user data from the database and add to userList
        // For demonstration, I'm adding dummy users here
        userList.add(new User(1, "John Doe", "john@example.com"));
        userList.add(new User(2, "Jane Smith", "jane@example.com"));
        // Add more users as needed
    }
}