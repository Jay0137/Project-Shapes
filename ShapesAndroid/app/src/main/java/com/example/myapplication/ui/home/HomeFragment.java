package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.PostAdapter;
import com.example.myapplication.model.Post;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    private RecyclerView recyclerViewPosts;
    private PostAdapter postAdapter;
    private List<Post> postList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewPosts = view.findViewById(R.id.recyclerViewPosts);
        recyclerViewPosts.setLayoutManager(new LinearLayoutManager(getActivity()));
        postList = new ArrayList<>(); // Initialize your list of posts

        // Initialize adapter and pass the list of posts
        postAdapter = new PostAdapter(getActivity(), postList);
        recyclerViewPosts.setAdapter(postAdapter);

        return view;
    }
    //////////////////////////////////////////








    /*

    private List<Post> postList;
    private PostAdapter postAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize RecyclerView
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Initialize PostAdapter and set it to RecyclerView
        postList = new ArrayList<>();
        postAdapter = new PostAdapter(postList);
        recyclerView.setAdapter(postAdapter);

        // Fetch posts and update the adapter
        fetchPosts();

        return root;
    }

    private void fetchPosts() {
        // You need to implement the logic to fetch posts from your database or backend
        // For example, if you have a PostDAO class to fetch posts from the database:
        PostDAO postDAO = new PostDAO(getActivity());
        postDAO.open();
        postList.addAll(postDAO.getAllPosts()); // Assuming getAllPosts() returns a list of posts
        postDAO.close();

        // Notify the adapter that the dataset has changed
        postAdapter.notifyDataSetChanged();
    }
    */
}
