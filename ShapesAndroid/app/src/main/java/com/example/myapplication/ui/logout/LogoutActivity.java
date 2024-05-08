package com.example.myapplication.ui.logout;

import android.content.Intent;
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

            // Redirect the user to the login page
            Intent intent = new Intent(LogoutActivity.this, LoginActivity.class);
            // Clear the back stack to prevent the user from returning to the previous screens after logout
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    });
    }

    // Method to handle back button click
    public void Back(View view) {
        onBackPressed();
    }

}

