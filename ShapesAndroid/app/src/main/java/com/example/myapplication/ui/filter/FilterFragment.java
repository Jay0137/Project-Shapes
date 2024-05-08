package com.example.myapplication.ui.filter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.example.myapplication.R;
import com.example.myapplication.ui.liked.LikedActivity;
import com.example.myapplication.ui.logout.LogoutActivity;
import com.example.myapplication.ui.profile.ProfileActivity;
import com.example.myapplication.ui.saved.SavedActivity;
import com.example.myapplication.ui.setting.SettingActivity;

public class FilterFragment extends Fragment {

    public FilterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter, container, false);

        Button settingsButton = view.findViewById(R.id.button_settings);
        Button profileButton = view.findViewById(R.id.button_profile);
        Button savedButton = view.findViewById(R.id.button_saved);
        Button likedButton = view.findViewById(R.id.button_liked);
        Button logoutButton = view.findViewById(R.id.button_logout);

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();
            }
        });

        savedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSaved();
            }
        });
        likedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLiked();
            }
        });
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogout();
            }
        });

        return view;
    }

    private void openSettings() {
        Intent intent = new Intent(getActivity(), SettingActivity.class);
        startActivity(intent);
    }

    private void openProfile() {
        Intent intent = new Intent(getActivity(), ProfileActivity.class);
        startActivity(intent);
    }

    private void openSaved() {
        Intent intent = new Intent(getActivity(), SavedActivity.class);
        startActivity(intent);
    }

    private void openLiked() {
        Intent intent = new Intent(getActivity(), LikedActivity.class);
        startActivity(intent);
    }

    private void openLogout() {
        Intent intent = new Intent(getActivity(), LogoutActivity.class);
        startActivity(intent);
    }
}
