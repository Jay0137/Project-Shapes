package com.example.myapplication;

import android.content.Intent;
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
    private AppBarConfiguration appBarConfiguration;

    private boolean userLoggedIn = false; // Flag to track user login status

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if user is logged in
        if (!userLoggedIn) {
            // If user is not logged in, navigate to LoginActivity or any other authentication activity
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish(); // Finish the MainActivity so user cannot navigate back without login
            return;
        }

        // Find the NavHostFragment
        NavHostFragment navHostFragment = (NavHostFragment)
                getSupportFragmentManager().findFragmentById(R.id.nav_host_main);

        if (navHostFragment != null) {
            // Get the NavController from the NavHostFragment
            navController = navHostFragment.getNavController();

            // Set up the ActionBar with NavController and AppBarConfiguration
            appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
            // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration); // Remove this line

            // Set up BottomNavigationView with NavController
            BottomNavigationView bottomNav = findViewById(R.id.nav_view);
            NavigationUI.setupWithNavController(bottomNav, navController);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        // return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp(); // Remove this line
        return false; // Disable navigation up
    }
}
