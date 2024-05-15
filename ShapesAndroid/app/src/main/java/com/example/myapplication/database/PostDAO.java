package com.example.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.model.Post;

import java.util.ArrayList;
import java.util.List;

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

    public List<Post> getAllPosts() {
        open(); // Open the database connection
        List<Post> posts = new ArrayList<>();
        Cursor cursor = database.query(
                PostContract.PostEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
        if (cursor != null) {
            int userIdIndex = cursor.getColumnIndex(PostContract.PostEntry.COLUMN_USER_ID);
            int textIndex = cursor.getColumnIndex(PostContract.PostEntry.COLUMN_TEXT);
            int imagePathIndex = cursor.getColumnIndex(PostContract.PostEntry.COLUMN_IMAGE_PATH);
            int dateIndex = cursor.getColumnIndex(PostContract.PostEntry.COLUMN_DATE);

            while (cursor.moveToNext()) {
                int userId = cursor.getInt(userIdIndex);
                String text = cursor.getString(textIndex);
                String imagePath = cursor.getString(imagePathIndex);
                String date = cursor.getString(dateIndex);
                Post post = new Post(userId, text, imagePath, date);
                posts.add(post);
            }
            cursor.close();
        }
        close(); // Close the database connection
        return posts;
    }




}
