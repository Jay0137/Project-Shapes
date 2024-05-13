package com.example.myapplication.ui.profile;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.database.SessionManager;
import com.example.myapplication.database.UserDAO;
import com.example.myapplication.database.UserDetails;

public class ProfileActivity extends AppCompatActivity {

    public ImageView profileImageView;
    public TextView usernameTextView;
    public TextView bioTextView;
    public TextView createdAtTextView;
    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);

        // Initialize views
        profileImageView = findViewById(R.id.image_profile);
        usernameTextView = findViewById(R.id.text_username);
        bioTextView = findViewById(R.id.text_bio);
        createdAtTextView = findViewById(R.id.text_DateCreated);

        // Initialize UserDAO
        userDAO = new UserDAO(this);

        // Retrieve user details
        UserDetails userDetails = getUserDetailsFromDatabase();

        // Check if userDetails is not null
        if (userDetails != null) {
            // Set user information to views
            usernameTextView.setText(userDetails.getUsername());
            bioTextView.setText(userDetails.getBio());
            createdAtTextView.setText(userDetails.getCreatedAt());
        }
    }

    // Method to retrieve user details from the database
    private UserDetails getUserDetailsFromDatabase() {
        // Assuming you have a method in your UserDAO class to retrieve user details
        // For example:
        String activeEmail = new SessionManager(this).getActiveEmail();
        if (userDAO != null) {
            userDAO.open();
            UserDetails userDetails = userDAO.getUserDetailsByEmail(activeEmail);
            userDAO.close();
            return userDetails;
        } else {
            return null;
        }
    }

    // Method to handle back button click
    public void Back(View view) {
        onBackPressed();
    }
}
