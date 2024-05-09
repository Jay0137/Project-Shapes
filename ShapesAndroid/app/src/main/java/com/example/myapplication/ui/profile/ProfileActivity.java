package com.example.myapplication.ui.profile;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
//import com.example.myapplication.ui.database.users.UserDAO;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);
        // Initialize TextViews
      //  nameTextView = findViewById(R.id.text_user_name);
     //   usernameTextView = findViewById(R.id.text_username);

        // Retrieve user information from the database
     //   UserDAO userDAO = new UserDAO(this);
     //   userDAO.open();
     //   Cursor cursor = userDAO.getUserByUsername("current_user"); // Replace "current_user" with the actual username of the logged-in user
     //   if (cursor != null && cursor.moveToFirst()) {
           // String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
          //  String username = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_USERNAME));
          //  String email = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_EMAIL));

            // Display user information in TextViews
         //   nameTextView.setText(name);
         //   usernameTextView.setText(username);
         //   emailTextView.setText(email);
      //  } else {
            // Error handling: unable to retrieve user information
      //      Toast.makeText(this, "Error: Unable to retrieve user information", Toast.LENGTH_SHORT).show();
     //   }
      //  if (cursor != null) {
      //      cursor.close();
      //  }
      //  userDAO.close();
    }

    // Method to handle back button click
    public void Back(View view) {
        onBackPressed();
    }
}
