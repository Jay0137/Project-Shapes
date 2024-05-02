package com.example.myapplication.ui.filter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentFilterBinding;


public class FilterFragment extends Fragment {

    private FragmentFilterBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FilterViewModel filterViewModel =
                new ViewModelProvider(this).get(FilterViewModel.class);

        binding = FragmentFilterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void navigateToPage1(View view) {
        // Navigate to page 1
    }

    public void navigateToPage2(View view) {
        // Navigate to page 2
    }

    public void navigateToPage3(View view) {
        // Navigate to page 3
    }

    public void navigateToPage4(View view) {
        // Navigate to page 4
    }

    public void navigateToPage5(View view) {
        // Navigate to page 5
    }


}
