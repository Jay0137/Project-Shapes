package com.example.myapplication.ui.addpost;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentAddPostBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddPostFragment extends Fragment {

    private FragmentAddPostBinding binding;
    private AddPostViewModel addPostViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addPostViewModel = new ViewModelProvider(this).get(AddPostViewModel.class);

        binding = FragmentAddPostBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final EditText postEditText = binding.editTextPost;
        FloatingActionButton addButton = binding.fabAddPost;

        addButton.setOnClickListener(v -> {
            String postText = postEditText.getText().toString();
            if (!postText.isEmpty()) {
                // Create a post using the ViewModel
                addPostViewModel.createPost(postText);
                // Clear the EditText after creating the post
                postEditText.setText("");
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
