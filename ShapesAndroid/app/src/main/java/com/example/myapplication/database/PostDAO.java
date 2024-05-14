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

   /* public List<Post> getAllPosts() {
        List<Post> postList = new ArrayList<>();

        // Define a query to select all posts
        String query = "SELECT * FROM " + PostContract.PostEntry.TABLE_NAME;

        // Open database connection
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Execute the query
        Cursor cursor = db.rawQuery(query, null);

        // Iterate over the cursor to extract post data
        if (cursor != null && cursor.moveToFirst()) {
            do {
                // Extract post data from cursor
                String userId = cursor.getString(cursor.getColumnIndex(PostContract.PostEntry.COLUMN_USER_ID));
                String text = cursor.getString(cursor.getColumnIndex(PostContract.PostEntry.COLUMN_TEXT));
                String imagePath = cursor.getString(cursor.getColumnIndex(PostContract.PostEntry.COLUMN_IMAGE_PATH));
               // String date = cursor.getString(cursor.getColumnIndex(PostContract.PostEntry.COLUMN_DATE));
                // boolean liked = cursor.getInt(cursor.getColumnIndex(PostContract.PostEntry.COLUMN_LIKED)) == 1;
                // boolean saved = cursor.getInt(cursor.getColumnIndex(PostContract.PostEntry.COLUMN_SAVED)) == 1;

                // Create a new Post object and add it to the list
                Post post = new Post(userId, text, imagePath);
                postList.add(post);
            } while (cursor.moveToNext());

            // Close the cursor
            cursor.close();
        }

        // Close database connection
        db.close();

        return postList;
    }

    */

}
