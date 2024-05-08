package com.example.myapplication.ui.liked;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class LikedActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_liked);
    }

    // Method to handle back button click
    public void Back(View view) {
        onBackPressed();
    }
}
