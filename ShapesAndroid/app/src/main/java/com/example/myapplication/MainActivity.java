package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.database.SessionManager;
import com.example.myapplication.ui.login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    private NavController navController;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(this);

        // Log session status
        Log.d("MainActivity", "Session active: " + sessionManager.isSessionActive());

        // Check if session is active and email is logged in
        if (sessionManager.isSessionActive() && sessionManager.isLoggedInWithEmail()) {
            // Call setupNavigation method
            setupNavigation();
        } else {
            Log.d("MainActivity", "Redirecting to login");
            // Redirect to LoginActivity
            redirectToLogin();
        }
    }


    // Method to set up navigation using NavController and BottomNavigationView
    private void setupNavigation() {
        // Find the NavHostFragment
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_main);

        if (navHostFragment != null) {
            // Get the NavController from the NavHostFragment
            navController = navHostFragment.getNavController();

            // Set up BottomNavigationView with NavController
            BottomNavigationView bottomNav = findViewById(R.id.nav_view);
            NavigationUI.setupWithNavController(bottomNav, navController);
        } else {
            // If NavHostFragment is null, redirect to login
            redirectToLogin();
        }
    }

    // Method to redirect to LoginActivity
    private void redirectToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        // Clear the back stack to prevent the user from returning to the MainActivity after login
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        // Finish the current activity to prevent the user from navigating back to it after login
        finish();
    }
}
