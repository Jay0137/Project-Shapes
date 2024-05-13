package com.example.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class PostDao {
    private SQLiteDatabase database;
    private PostDbHelper dbHelper;

    public PostDao(Context context) {
        dbHelper = new PostDbHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long addPost(int userId, String text, String imagePath, String date) {
        ContentValues values = new ContentValues();
        values.put(PostContract.PostEntry.COLUMN_USER_ID, userId);
        values.put(PostContract.PostEntry.COLUMN_TEXT, text);
        values.put(PostContract.PostEntry.COLUMN_IMAGE_PATH, imagePath);
        values.put(PostContract.PostEntry.COLUMN_DATE, date);
        return database.insert(PostContract.PostEntry.TABLE_NAME, null, values);
    }

    public List<Post> getAllPostsByUserId(int userId) {
        List<Post> posts = new ArrayList<>();
        String[] projection = {
                PostContract.PostEntry.COLUMN_ID,
                PostContract.PostEntry.COLUMN_USER_ID,
                PostContract.PostEntry.COLUMN_TEXT,
                PostContract.PostEntry.COLUMN_IMAGE_PATH,
                PostContract.PostEntry.COLUMN_DATE
        };
        String selection = PostContract.PostEntry.COLUMN_USER_ID + " = ?";
        String[] selectionArgs = { String.valueOf(userId) };

        Cursor cursor = database.query(
                PostContract.PostEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            int postId = cursor.getInt(cursor.getColumnIndexOrThrow(PostContract.PostEntry.COLUMN_ID));
            String text = cursor.getString(cursor.getColumnIndexOrThrow(PostContract.PostEntry.COLUMN_TEXT));
            String imagePath = cursor.getString(cursor.getColumnIndexOrThrow(PostContract.PostEntry.COLUMN_IMAGE_PATH));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(PostContract.PostEntry.COLUMN_DATE));
            posts.add(new Post(postId, userId, text, imagePath, date));
        }
        cursor.close();
        return posts;
    }
}
