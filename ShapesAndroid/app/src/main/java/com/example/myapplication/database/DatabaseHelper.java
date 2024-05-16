package com.example.myapplication.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "ShapesDB";

    // Table name
    public static final String TABLE_NAME = "users";

    // Table Columns
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_CREATED_AT = "created_at"; // New column for creation date
    public static final String COLUMN_PROFILE_PICTURE = "profile_picture"; // New column for profile picture
    public static final String COLUMN_BIO = "bio"; // New column for bio

    public void open() {
        super.getWritableDatabase();
    }

    // Close the database
    public void close() {
        super.close();
    }

    // Create table SQL query
    private static final String CREATE_TABLE_USERS =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_USERNAME + " TEXT,"
                    + COLUMN_EMAIL + " TEXT,"
                    + COLUMN_PASSWORD + " TEXT,"
                    + COLUMN_PROFILE_PICTURE + " TEXT," // Profile picture column
                    + COLUMN_BIO + " TEXT," // Bio column
                    + COLUMN_CREATED_AT + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create users table
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public String getUserName(int userId) {
        SQLiteDatabase db = this.getReadableDatabase();
        String username = null;

        // Define the query to fetch username based on user ID
        String query = "SELECT " + COLUMN_USERNAME + " FROM " + TABLE_NAME +
                " WHERE " + COLUMN_ID + " = ?";

        // Define the selection arguments
        String[] selectionArgs = { String.valueOf(userId) };

        // Execute the query
        Cursor cursor = db.rawQuery(query, selectionArgs);

        try {
            // Check if the cursor has data
            if (cursor.moveToFirst()) {
                // Extract username from the cursor
                int columnIndex = cursor.getColumnIndex(COLUMN_USERNAME);
                if (columnIndex != -1) {
                    username = cursor.getString(columnIndex);
                } else {
                    // Log an error if the column index is -1
                    Log.e("DatabaseHelper", "Column not found: " + COLUMN_USERNAME);
                }
            } else {
                // Log a message if no data is found for the given user ID
                Log.e("DatabaseHelper", "No data found for user ID: " + userId);
            }
        } catch (Exception e) {
            // Log any exception that occurs
            Log.e("DatabaseHelper", "Error retrieving username", e);
        } finally {
            // Close the cursor and database connection
            cursor.close();
            db.close();
        }

        // Return the retrieved username
        return username;
    }
}
