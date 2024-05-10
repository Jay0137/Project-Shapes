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
        editor.apply();
    }
}
