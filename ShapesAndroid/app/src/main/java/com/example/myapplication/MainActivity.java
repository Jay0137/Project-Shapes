package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.ui.login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     
        // Check if the user is logged in
        if (!isLoggedIn()) {
            redirectToLogin();

        } else {
            // If logged in, proceed with setting up the navigation
            setupNavigation();
            System.out.println("logged in");
        }
    }


    // Method to set up navigation using NavController and BottomNavigationView
    private void setupNavigation() {
        // Find the NavHostFragment
        NavHostFragment navHostFragment = (NavHostFragment)
                getSupportFragmentManager().findFragmentById(R.id.nav_host_main);

        if (navHostFragment != null) {
            // Get the NavController from the NavHostFragment
            navController = navHostFragment.getNavController();

            // Set up BottomNavigationView with NavController
            BottomNavigationView bottomNav = findViewById(R.id.nav_view);
            NavigationUI.setupWithNavController(bottomNav, navController);
        }
    }

    // Method to check if the user is logged in
    private boolean isLoggedIn() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_session", MODE_PRIVATE);
        // Check if the user is logged in by checking if the "user_id" key exists
        return sharedPreferences.contains("user_id");
    }

    // Method to redirect to the login page
    private void redirectToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        // Finish the current activity to prevent the user from navigating back to it after logging in
        finish();
    }

}
