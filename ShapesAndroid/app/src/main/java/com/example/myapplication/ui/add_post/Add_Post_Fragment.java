package com.example.myapplication.ui.add_post;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentAddPostBinding;

public class Add_Post_Fragment extends Fragment {

    private FragmentAddPostBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Add_Post_ViewModel addPostViewModel =
                new ViewModelProvider(this).get(Add_Post_ViewModel.class);

        binding = FragmentAddPostBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textAddPost;
        addPostViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}