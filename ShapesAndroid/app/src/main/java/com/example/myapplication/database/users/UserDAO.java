package com.example.myapplication.database.users;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myapplication.database.DatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UserDAO {

    private SQLiteDatabase database;
    private final DatabaseHelper dbHelper;

    public UserDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long addUser(String name, String username, String email, String password) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, name);
        values.put(DatabaseHelper.COLUMN_USERNAME, username);
        values.put(DatabaseHelper.COLUMN_EMAIL, email);
        values.put(DatabaseHelper.COLUMN_PASSWORD, password);
        values.put(DatabaseHelper.COLUMN_CREATED_AT, getCurrentDateTime());
        return database.insert(DatabaseHelper.TABLE_NAME, null, values);
    }

    public Cursor getUserByUsername(String username) {
        String[] projection = {
                DatabaseHelper.COLUMN_ID,
                DatabaseHelper.COLUMN_NAME,
                DatabaseHelper.COLUMN_USERNAME,
                DatabaseHelper.COLUMN_EMAIL,
                DatabaseHelper.COLUMN_PASSWORD
        };
        String selection = DatabaseHelper.COLUMN_USERNAME + "=?";
        String[] selectionArgs = {username};
        return database.query(
                DatabaseHelper.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
    }

    private String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    public boolean authenticateUser(String email, String password) {
        String[] projection = {
                DatabaseHelper.COLUMN_ID,
                DatabaseHelper.COLUMN_NAME,
                DatabaseHelper.COLUMN_USERNAME,
                DatabaseHelper.COLUMN_EMAIL,
                DatabaseHelper.COLUMN_PASSWORD
        };

        String selection = DatabaseHelper.COLUMN_EMAIL + "=? AND " + DatabaseHelper.COLUMN_PASSWORD + "=?";
        String[] selectionArgs = {email, password};

        Cursor cursor = database.query(
                DatabaseHelper.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        boolean isAuthenticated = cursor != null && cursor.getCount() > 0;

        if (cursor != null) {
            cursor.close();
        }

        return isAuthenticated;
    }

    public long getUserIdByEmail(String email) {
        String[] projection = {DatabaseHelper.COLUMN_ID};
        String selection = DatabaseHelper.COLUMN_EMAIL + "=?";
        String[] selectionArgs = {email};

        Cursor cursor = database.query(
                DatabaseHelper.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        long userId = -1; // Default value if email is not found

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_ID);
                if (columnIndex != -1) {
                    userId = cursor.getLong(columnIndex);
                }
            }
            cursor.close();
        }

        return userId;
    }

    public UserDetails getUserDetailsByEmail(String email) {
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_NAME,
                new String[]{DatabaseHelper.COLUMN_USERNAME, DatabaseHelper.COLUMN_CREATED_AT, DatabaseHelper.COLUMN_BIO},
                DatabaseHelper.COLUMN_EMAIL + "=?",
                new String[]{email},
                null,
                null,
                null
        );

        UserDetails userDetails = null;
        if (cursor != null) {
            Log.d("UserDAO", "Cursor count: " + cursor.getCount());
            if (cursor.moveToFirst()) {
                int columnIndexUsername = cursor.getColumnIndex(DatabaseHelper.COLUMN_USERNAME);
                int columnIndexCreatedAt = cursor.getColumnIndex(DatabaseHelper.COLUMN_CREATED_AT);
                int columnIndexBio = cursor.getColumnIndex(DatabaseHelper.COLUMN_BIO);
                Log.d("UserDAO", "Column index for username: " + columnIndexUsername);
                Log.d("UserDAO", "Column index for created_at: " + columnIndexCreatedAt);
                Log.d("UserDAO", "Column index for bio: " + columnIndexBio);
                if (columnIndexUsername >= 0 && columnIndexCreatedAt >= 0 && columnIndexBio >= 0) {
                    String username = cursor.getString(columnIndexUsername);
                    String createdAt = cursor.getString(columnIndexCreatedAt);
                    String bio = cursor.getString(columnIndexBio);
                    userDetails = new UserDetails(username, createdAt, "", bio); // Assuming profile picture is not used in this context
                } else {
                    Log.e("UserDAO", "Column index is invalid");
                }
            }
            cursor.close();
        }
        return userDetails;
    }





}
