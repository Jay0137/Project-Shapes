package com.example.myapplication.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.database.SessionManager;
import com.example.myapplication.database.UserDAO;
import com.example.myapplication.ui.register.RegisterActivity;

public class LoginActivity extends Activity {

    // Assuming you have these fields in your activity_login.xml layout file
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(this);

        // Check if user is already logged in
        if (sessionManager.isSessionActive()) {
            launchMainActivity();
            return;
        }

        // Initialize EditText and Button
        emailEditText = findViewById(R.id.Email);
        passwordEditText = findViewById(R.id.Password);
        loginButton = findViewById(R.id.ButtonLogin);

        // Set click listener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get username and password from EditText fields
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Perform login authentication
                authenticateUser(email, password);
            }
        });
    }

    // Placeholder method for authentication logic
    private void authenticateUser(String email, String password) {
        // Check if the user exists in the database and if the provided email and password are correct
        UserDAO userDAO = new UserDAO(LoginActivity.this);
        userDAO.open();

        // Check if the email exists in the database
        long emailId = userDAO.getUserIdByEmail(email);
        if (emailId != -1) { // Email exists
            // Check if the provided password matches the password for the given email
            boolean isAuthenticated = userDAO.authenticateUser(email, password);

            if (isAuthenticated) { // Password is correct
                // Generate session token
                String sessionToken = sessionManager.generateSessionToken();

                // Link session token to user ID and save it
                sessionManager.saveSessionTokenForUser(emailId, sessionToken);

                // If authentication is successful, launch MainActivity
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                launchMainActivity();
            } else {
                // If password is incorrect, show an error message
                Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
            }
        } else {
            // If email doesn't exist, show an error message
            Toast.makeText(LoginActivity.this, "Email doesn't exist", Toast.LENGTH_SHORT).show();
        }

        userDAO.close();
    }



    // Method to launch MainActivity
    private void launchMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        // finish(); // Finish LoginActivity so that pressing back won't return to it
    }

    // Method to navigate to RegisterFragment
    public void navigateToRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
