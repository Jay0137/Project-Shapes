package com.example.myapplication.ui.watcher;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.EditText;

public class EmailTextWatcher implements TextWatcher {
    private EditText editText;

    public EmailTextWatcher(EditText editText) {
        this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable editable) {
        String text = editText.getText().toString();
        if (!isValidEmail(text)) {
            editText.setError("Please enter a valid email address");
        } else {
            editText.setError(null);
        }
    }

    private boolean isValidEmail(CharSequence target) {
        return target != null && Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
