package com.example.myapplication.ui.Database;
import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PostFileManager {

    private Context context;

    public PostFileManager(Context context) {
        this.context = context;
    }

    public void savePost(String postContent) {
        FileOutputStream fos = null;
        try {
            // Create a file object
            File file = new File(context.getFilesDir(), "posts.txt");
            // Open file output stream
            fos = new FileOutputStream(file, true); // Set true for appending data
            // Write the post content to the file
            fos.write(postContent.getBytes());
            // Add a new line separator
            fos.write(System.getProperty("line.separator").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the file output stream
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
