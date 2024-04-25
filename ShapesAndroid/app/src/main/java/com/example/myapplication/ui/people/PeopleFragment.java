package com.example.myapplication.ui.people;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentPeopleBinding;

public class PeopleFragment extends Fragment {

    private FragmentPeopleBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PeopleViewModel peopleViewModel =
                new ViewModelProvider(this).get(PeopleViewModel.class);

        binding = FragmentPeopleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textPeople;
        peopleViewModel.getText().observe(getViewLifecycleOwner(), text -> {
            // Update the UI here
            textView.setText(text);
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
