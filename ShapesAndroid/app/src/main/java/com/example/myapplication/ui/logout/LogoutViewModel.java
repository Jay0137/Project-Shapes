package com.example.myapplication.ui.logout;

import androidx.lifecycle.ViewModel;

public class LogoutViewModel extends ViewModel {

    public void logout() {
        // Here you would implement the logic to log out the user
        // For simplicity, let's just show a toast indicating success
        showToast("Logged out successfully!");
        // You can also perform any other necessary cleanup or navigation here
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
