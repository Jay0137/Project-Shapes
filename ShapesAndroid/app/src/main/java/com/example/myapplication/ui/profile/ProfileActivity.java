package com.example.myapplication.ui.profile;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.DatabaseHelper;
import com.example.myapplication.R;
import com.example.myapplication.database.Profile;

public class ProfileActivity extends AppCompatActivity {

    private ImageView profileImageView;
    private TextView usernameTextView;
    private TextView bioTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);

        profileImageView = findViewById(R.id.image_profile);
        usernameTextView = findViewById(R.id.text_user_name);
        bioTextView = findViewById(R.id.text_bio);

        // Assuming you have access to the username
        String username = "example_username"; // Replace with actual username

        // Fetch profile information from the database
        DatabaseHelper profileView = new DatabaseHelper(this);
        try {
            profileView.open(); // Open the database
            Profile profile = profileView.getUserByUsername(username);

            // Update UI with profile information
            if (profile != null) {
                // Set profile picture
                if (profile.getProfilePicture() != null && !profile.getProfilePicture().isEmpty()) {
                    // Load profile picture into ImageView (assuming you have the profile picture path or URL)
                    // profileImageView.setImageURI(Uri.parse(profile.getProfilePicture()));
                }

                // Set username
                usernameTextView.setText(username);

                // Set bio
                if (profile.getBio() != null && !profile.getBio().isEmpty()) {
                    bioTextView.setText(profile.getBio());
                } else {
                    bioTextView.setText(getString(R.string.no_bio_available));
                }
            } else {
                Toast.makeText(this, "Profile not found", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            profileView.close(); // Close the database
        }
    }

    // Method to handle back button click
    public void Back(View view) {
        onBackPressed();
    }

    // need some heavy work to do
}
