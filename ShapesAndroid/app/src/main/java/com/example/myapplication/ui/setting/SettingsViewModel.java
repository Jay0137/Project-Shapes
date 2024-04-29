package com.example.myapplication.ui.setting;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {

    private MutableLiveData<Boolean> darkModeEnabled = new MutableLiveData<>();

    public LiveData<Boolean> getDarkModeEnabled() {
        return darkModeEnabled;
    }

    public void setDarkModeEnabled(boolean isEnabled) {
        darkModeEnabled.setValue(isEnabled);
        // Save the updated setting to preferences or database
    }

    // Example method for loading initial settings from preferences or database
    public void loadSettings() {
        // Load dark mode setting from preferences or database
        boolean darkModeEnabled = false; // Load from preferences or database
        this.darkModeEnabled.setValue(darkModeEnabled);
    }
}
