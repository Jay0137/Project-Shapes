package com.example.myapplication.ui.logout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.ui.login.LoginActivity;


public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_logout);

        Button logoutButton = findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Perform logout action
            // For example, clear user session, reset preferences, etc.

            System.out.println("Logout");
            clearSession();

            // Redirect the user to the login page
            Intent intent = new Intent(LogoutActivity.this, LoginActivity.class);
            // Clear the back stack to prevent the user from returning to the previous screens after logout
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            // Finish the current activity to prevent the user from navigating back to it after logout
            finish();
        }
    });
    }

    // Method to handle back button click
    public void Back(View view) {
        onBackPressed();
    }

    private void clearSession() {
        // Here you would put the logic to clear the user session
        // This could involve clearing shared preferences, resetting flags, etc.
        // Below is just a simple example assuming you're using SharedPreferences

        SharedPreferences preferences = getSharedPreferences("user_session", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear(); // Clear all stored data
        editor.apply();
    }

}

