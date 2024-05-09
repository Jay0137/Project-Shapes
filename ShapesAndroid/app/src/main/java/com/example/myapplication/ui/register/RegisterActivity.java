package com.example.myapplication.ui.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.ui.database.users.UserDAO;
import com.example.myapplication.ui.login.LoginActivity;
import com.example.myapplication.ui.watcher.EmailTextWatcher;
import com.example.myapplication.ui.watcher.MinLetterTextWatcher;

import java.util.UUID;

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

                // Validate user inputs (you can add more validation here)

                // Check if any field is empty
                if (name.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Generate a random and unique ID for the user
                String userId = UUID.randomUUID().toString();

                // Add the user to the database along with the generated ID
                UserDAO userDAO = new UserDAO(RegisterActivity.this);
                userDAO.open();
                long result = userDAO.addUser(userId, name, username, email, password);
                userDAO.close();

                // Check if the user was successfully added to the database
                if (result != -1) {
                    // Display success message and navigate to LoginActivity
                    Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                    navigateToLogin(v);
                } else {
                    // Display error message if user registration failed
                    Toast.makeText(RegisterActivity.this, "Failed to register user", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    // Method to navigate to LoginActivity
    public void navigateToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
