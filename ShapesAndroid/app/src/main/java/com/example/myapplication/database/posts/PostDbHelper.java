package com.example.myapplication.database.posts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PostDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "posts.db";
    private static final int DATABASE_VERSION = 2; // Increment version to trigger upgrade

    private static final String SQL_CREATE_POST_TABLE =
            "CREATE TABLE " + PostContract.PostEntry.TABLE_NAME + " (" +
                    PostContract.PostEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    PostContract.PostEntry.COLUMN_USER_ID + " INTEGER," +
                    PostContract.PostEntry.COLUMN_USERNAME + " TEXT," + // Add username column
                    PostContract.PostEntry.COLUMN_TEXT + " TEXT," +
                    PostContract.PostEntry.COLUMN_IMAGE_PATH + " TEXT," +
                    PostContract.PostEntry.COLUMN_DATE + " TEXT)";

    public PostDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_POST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrade if needed
        // For simplicity, we're dropping the existing table and recreating it
        db.execSQL("DROP TABLE IF EXISTS " + PostContract.PostEntry.TABLE_NAME);
        onCreate(db);
    }
}
