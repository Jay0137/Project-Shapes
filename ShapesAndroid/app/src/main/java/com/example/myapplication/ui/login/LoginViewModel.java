package com.example.myapplication.ui.login;

import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    public void login(String username, String password) {
        // Here you would implement the logic to authenticate the user
        // For simplicity, let's just show a toast indicating success/failure
        if (isValidCredentials(username, password)) {
            // Authentication successful
            // You can navigate to the next screen or perform other actions here
            showToast("Login successful!");
        } else {
            // Authentication failed
            showToast("Invalid username or password.");
        }
    }

    private boolean isValidCredentials(String username, String password) {
        // Here you would validate the credentials against your authentication mechanism
        // This is a placeholder method; you should replace it with your actual authentication logic
        return username.equals("example") && password.equals("password");
    }

    private void showToast(String message) {
        // This method is used to show a toast message
        // You can replace this with any other UI feedback mechanism you prefer
        // For simplicity, I'm just showing a toast here
        // Note: This method should ideally be called on the UI thread
        // If you're not sure about the thread context, consider using LiveData for communication between ViewModel and Fragment
        // or use runOnUiThread() to post the toast on the UI thread
        // For example: getActivity().runOnUiThread(() -> Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show());
        Toast.makeText(MyApplication.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
