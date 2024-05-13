package com.example.myapplication.ui.upload;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.database.PostDAO;
import com.example.myapplication.database.SessionManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UploadPostFragment extends Fragment {
    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView imageView;
    private Activity activity;
    private EditText editTextPost;
    private Uri imageUri; // Uri to store the selected image


    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_post, container, false);

        editTextPost = rootView.findViewById(R.id.editTextPost);
        imageView = rootView.findViewById(R.id.upload);
        FloatingActionButton uploadButton = rootView.findViewById(R.id.AddPost);



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Upload button clicked");
                uploadPost();
            }
        });

        return rootView;
    }

    private int getUserId() {
        // Assuming you have a SessionManager class to manage user sessions
        SessionManager sessionManager = new SessionManager(getActivity().getApplicationContext());

        // Get the user id from the session manager
        int userId = sessionManager.getUserId();

        return userId;
    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    // Handle the result of the image selection
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            // Set the selected image to the ImageView
            imageView.setImageURI(imageUri);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        // Clear EditText content when the fragment's view is destroyed
        editTextPost.setText("");
    }

    private void uploadPost() {
        // Check if both imageUri and editTextPost are not null or empty
        if (imageUri != null && !editTextPost.getText().toString().isEmpty()) {
            // Create an instance of the PostDAO class
            PostDAO postDAO = new PostDAO(getActivity().getApplicationContext());

            // Open the database connection
            postDAO.open();

            // Call the insertPost method on the instance with the current date
            String currentDate = getCurrentDate();
            boolean insertSuccess = postDAO.insertPost(getUserId(), imageUri.toString(), editTextPost.getText().toString(), currentDate);

            // Close the database connection
            postDAO.close();

            if (insertSuccess) {
                // Show success message
                Toast.makeText(activity, "Post created successfully", Toast.LENGTH_SHORT).show();

                // Clear the EditText content
                editTextPost.setText("");
            } else {
                // Show failure message
                Toast.makeText(activity, "Failed to create post", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Show a message indicating that both image and text are required
            Toast.makeText(activity, "Please select an image and enter text", Toast.LENGTH_SHORT).show();
        }
    }

    private String getCurrentDate() {
        // Create a SimpleDateFormat object with the desired date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        // Get the current date and time
        Date currentDate = new Date();

        // Format the current date using the SimpleDateFormat object
        String formattedDate = dateFormat.format(currentDate);

        return formattedDate;
    }

}
