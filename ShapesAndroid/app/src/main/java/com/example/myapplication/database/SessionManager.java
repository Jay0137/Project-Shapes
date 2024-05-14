package com.example.myapplication.database;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;

public class SessionManager {
    public SharedPreferences sharedPreferences;
    private static final String USER_ID_KEY = "user_id";

    public SessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences("user_session", Context.MODE_PRIVATE);
    }

    public String generateSessionToken() {
        return UUID.randomUUID().toString();
    }

    public boolean isSessionActive() {
        return sharedPreferences.contains("session_token");
    }

    public void logout() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("session_token");
        editor.remove("user_id"); // Remove user id when logging out
        editor.apply();
    }


    public void saveSessionTokenForUser(long userId, String sessionToken) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_id", String.valueOf(userId)); // Store user id with session token
        editor.putString("session_token", sessionToken);
        editor.apply();
    }

    public boolean isLoggedInWithEmail() {
        // Check if the session token exists in SharedPreferences
        return sharedPreferences.contains("session_token");
    }

    public String getActiveEmail() {
        return sharedPreferences.getString("active_email", "");
    }

    public int getUserId() {
        // Retrieve the user ID from SharedPreferences
        String userIdString = sharedPreferences.getString(USER_ID_KEY, null);

        // Convert the string to an integer
        if (userIdString != null) {
            try {
                return Integer.parseInt(userIdString);
            } catch (NumberFormatException e) {
                // Handle parsing error
                e.printStackTrace();
            }
        }

        // Return a default value or handle the case when the user ID is not available
        return -1; // or whatever default value you choose
    }
}
