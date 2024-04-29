package com.example.myapplication.ui.setting;

import android.os.Bundle;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.myapplication.R;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class SettingsFragment extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_settings); // Make sure to initialize darkModeSwitch here

        SwitchMaterial switchBtn = findViewById(R.id.SwitchMode);

        // switch theme mode per user wishes
        // setting onCheckedListener on switch
        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged (CompoundButton buttonView, boolean isChecked){

                // checking if the switch is turned on
                if (isChecked) {

                    // setting theme to night mode
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }

                // if the above condition turns false
                // it means switch is turned off
                // by-default the switch will be off
                else {

                    // setting theme to light theme
                    AppCompatDelegate.setDefaultNightMode (AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }
}

