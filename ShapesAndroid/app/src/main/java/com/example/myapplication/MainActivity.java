package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.ui.login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if the user is logged in
        if (!isLoggedIn()) {
            // If not logged in, navigate to the login page
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
            finish(); // Finish the MainActivity so that pressing back won't return to it
            return; // Exit onCreate method to prevent further execution
        }

        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Configure the IDs of top-level destinations for AppBarConfiguration
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_explore, R.id.navigation_add_post,
                R.id.navigation_people, R.id.navigation_filter)
                .build();

        // Find the NavHostFragment
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        // Set up the ActionBar with NavController and AppBarConfiguration
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // Set up the BottomNavigationView with NavController
        NavigationUI.setupWithNavController(navView, navController);
    }
}
