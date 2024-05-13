package com.example.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class PostDAO {
    private SQLiteDatabase database;
    private PostDbHelper dbHelper;

    public PostDAO(Context context) {
        dbHelper = new PostDbHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public boolean insertPost(int userId, String text, String imagePath, String date) {
        open(); // Open the database connection
        ContentValues values = new ContentValues();
        values.put(PostContract.PostEntry.COLUMN_USER_ID, userId);
        values.put(PostContract.PostEntry.COLUMN_TEXT, text);
        values.put(PostContract.PostEntry.COLUMN_IMAGE_PATH, imagePath);
        values.put(PostContract.PostEntry.COLUMN_DATE, date);
        long newRowId = database.insert(PostContract.PostEntry.TABLE_NAME, null, values);
        close(); // Close the database connection
        return newRowId != -1;
    }
}
