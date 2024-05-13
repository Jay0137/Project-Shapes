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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.database.SessionManager;

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



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
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

    /* Handle the upload button click
     * Upload the selected image and text to the server
     * and make a toast to indicate success or failure
     * and if successful, navigate back to the home fragment
     * if it is not successful, show an error message and stay in the same fragment
     */

}
