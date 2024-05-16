package com.example.myapplication.ui.register;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.database.users.UserDAO;
import com.example.myapplication.ui.login.LoginActivity;
import com.example.myapplication.ui.watcher.EmailTextWatcher;
import com.example.myapplication.ui.watcher.MinLetterTextWatcher;

public class RegisterActivity extends Activity {

    private EditText nameEditText, usernameEditText, emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize views
        nameEditText = findViewById(R.id.Name);
        usernameEditText = findViewById(R.id.Username);
        emailEditText = findViewById(R.id.Email);
        passwordEditText = findViewById(R.id.Password);

        // Add TextWatchers to enforce minimum letters
        nameEditText.addTextChangedListener(new MinLetterTextWatcher(nameEditText, 1, 8));
        usernameEditText.addTextChangedListener(new MinLetterTextWatcher(usernameEditText, 1, 8));
        emailEditText.addTextChangedListener(new EmailTextWatcher(emailEditText));
        passwordEditText.addTextChangedListener(new MinLetterTextWatcher(passwordEditText, 8, 16));

        Button signUpButton = findViewById(R.id.buttonSignUp);

        // Set click listener for sign up button
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve user inputs
                String name = nameEditText.getText().toString();
                String username = usernameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Validate user inputs
                if (name.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check if username or email already exists in the database
                if (isUsernameExists(username) && isEmailExists(email)) {
                    Toast.makeText(RegisterActivity.this, "Username and Email already exists", Toast.LENGTH_SHORT).show();
                    return;
                } else if (isUsernameExists(username)) {
                    Toast.makeText(RegisterActivity.this, "Username already exists", Toast.LENGTH_SHORT).show();
                    return;
                } else if (isEmailExists(email)) {
                    Toast.makeText(RegisterActivity.this, "Email already exists", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Add the user to the database
                UserDAO userDAO = new UserDAO(RegisterActivity.this);
                userDAO.open();
                try {
                    long result = userDAO.addUser(name, username, email, password);
                    if (result != -1) {
                        // Display success message and navigate to LoginActivity
                        Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        Log.d("RegisterActivity", "User registration successful");
                        navigateToLogin(v);
                    } else {
                        // Display error message if user registration failed
                        Toast.makeText(RegisterActivity.this, "Failed to register user", Toast.LENGTH_SHORT).show();
                        Log.e("RegisterActivity", "Failed to register user");
                    }
                } catch (SQLiteException e) {
                    // Log any SQL exceptions
                    Log.e("RegisterActivity", "Error adding user to database", e);
                    Toast.makeText(RegisterActivity.this, "Failed to register user. Please try again.", Toast.LENGTH_SHORT).show();
                } finally {
                    userDAO.close(); // Ensure database is always closed
                }
            }
        });
    }

    // Method to check if a username already exists in the database
    private boolean isUsernameExists(String username) {
        UserDAO userDAO = new UserDAO(RegisterActivity.this);
        userDAO.open();
        boolean exists = userDAO.isUsernameExists(username);
        userDAO.close();
        return exists;
    }

    // Method to check if an email already exists in the database
    private boolean isEmailExists(String email) {
        UserDAO userDAO = new UserDAO(RegisterActivity.this);
        userDAO.open();
        boolean exists = userDAO.isEmailExists(email);
        userDAO.close();
        return exists;
    }

    // Method to navigate to LoginActivity
    public void navigateToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
