package com.example.myapplication.database;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;

public class SessionManager {
    public SharedPreferences sharedPreferences;

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
        // Retrieve user id from SharedPreferences
        // Default value -1 indicates user id not found
        return sharedPreferences.getInt("user_id", -1);
    }
}
