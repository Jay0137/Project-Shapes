package com.example.myapplication.ui.profile;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.DatabaseHelper;
import com.example.myapplication.R;
import com.example.myapplication.database.Profile;
import com.example.myapplication.database.ProfileDAO;

public class ProfileActivity extends AppCompatActivity {

    public ImageView profileImageView;
    public TextView usernameTextView;
    public TextView bioTextView;
    public TextView createdAtTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);

        profileImageView = findViewById(R.id.image_profile);
        usernameTextView = findViewById(R.id.text_username);
        bioTextView = findViewById(R.id.text_bio);
        createdAtTextView = findViewById(R.id.text_DateCreated);

        // Fetch profile information from the database
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        ProfileDAO profileDAO = new ProfileDAO(dbHelper);

        // Get current user's ID from session
        int currentUserId = getCurrentUserId();

        // Get profile information of the current user
        Profile currentUserProfile = profileDAO.getUserById(currentUserId);

// Update UI with the current user's information
        if (currentUserProfile != null) {

            // Set profile picture
            ImageView profileImageView = findViewById(R.id.image_profile);
            int profileImageResource = getResources().getIdentifier(currentUserProfile.getProfilePicture(), "drawable", getPackageName());
            if (profileImageResource != 0) {
                profileImageView.setImageResource(profileImageResource);
            }

            // Set username
            TextView usernameTextView = findViewById(R.id.text_username);
            usernameTextView.setText(currentUserProfile.getUsername());

            // Set bio
            TextView bioTextView = findViewById(R.id.text_bio);
            bioTextView.setText(currentUserProfile.getBio());

            

        }
    }

    private int getCurrentUserId() {
        // Implement logic to get the current user ID
        // For example, if you're using SharedPreferences to store the current user ID:
        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        return sharedPreferences.getInt("current_user_id", 0); // Return 0 if not found
    }

    // Method to handle back button click
    public void Back(View view) {
        onBackPressed();
    }
}
