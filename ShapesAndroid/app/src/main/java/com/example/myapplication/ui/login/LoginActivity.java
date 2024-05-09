package com.example.myapplication.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.ui.database.users.UserDAO;
import com.example.myapplication.ui.register.RegisterActivity;

public class LoginActivity extends Activity {

    // Assuming you have these fields in your activity_login.xml layout file
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if user is already logged in
        if (isLoggedIn()) {
            launchMainActivity();
            return;
        }

        setContentView(R.layout.fragment_login);

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
        boolean isAuthenticated = userDAO.authenticateUser(email, password);
        userDAO.close();

        // Check if authentication is successful
        if (isAuthenticated) {
            // If authentication is successful, launch MainActivity
            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
            launchMainActivity();
        } else {
            // If authentication fails, show an error message
            Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }

    // Method to navigate to RegisterFragment
    public void navigateToRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    // Method to check if the user is logged in (replace with your authentication logic)
    private boolean isLoggedIn() {
        // You can implement your logic here to check if the user is already logged in
        // For demonstration purposes, always return false
        SharedPreferences sharedPreferences = getSharedPreferences("user_session", MODE_PRIVATE);

        // Check if there is any stored user data (assuming a key named "logged_in" is used)
        return sharedPreferences.getBoolean("logged_in", false);
    }

    // Method to launch MainActivity
    private void launchMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); // Finish LoginFragment so that pressing back won't return to it
    }
}
