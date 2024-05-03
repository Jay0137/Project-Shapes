package com.example.myapplication.ui.filter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.ui.setting.SettingFragment;

public class FilterFragment extends Fragment {

    public FilterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter, container, false);

        Button settingsButton = view.findViewById(R.id.button_settings);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsPage();
            }
        });

        // Add similar click listeners for other buttons

        return view;
    }

    private void openSettingsPage() {
        // Navigate to the Settings activity
        Intent intent = new Intent(getActivity(), SettingFragment.class);
        startActivity(intent);
    }
}
