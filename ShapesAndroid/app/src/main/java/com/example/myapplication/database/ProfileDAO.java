package com.example.myapplication.database;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.DatabaseHelper;

public class ProfileDAO {

    private DatabaseHelper dbHelper;

    public ProfileDAO(DatabaseHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @SuppressLint("Range")
    public Profile getUserById(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = null;
        Profile profile = null;
        try {
            cursor = db.query(DatabaseHelper.TABLE_NAME, null,
                    DatabaseHelper.COLUMN_ID + "=?", new String[]{String.valueOf(id)},
                    null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                profile = new Profile();
                profile.setId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID)));
                profile.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME)));
                profile.setUsername(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_USERNAME)));
                profile.setEmail(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_EMAIL)));
                profile.setPassword(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PASSWORD)));
                profile.setProfilePicture(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PROFILE_PICTURE)));
                profile.setBio(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_BIO)));
                profile.setCreatedAt(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CREATED_AT)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            // Don't close the database here; it's a shared resource and should be managed outside this method
        }
        return profile;
    }
}
