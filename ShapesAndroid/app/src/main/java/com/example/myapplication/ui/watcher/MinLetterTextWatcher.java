package com.example.myapplication.ui.watcher;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
public class MinLetterTextWatcher implements TextWatcher {
    private EditText editText;
    private int minLetters;
    private int maxLetters;

    public MinLetterTextWatcher(EditText editText, int minLetters, int maxLetters) {
        this.editText = editText;
        this.minLetters = minLetters;
        this.maxLetters = maxLetters;
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
        if (text.length() < minLetters) {
            editText.setError("Minimum " + minLetters + " letters required");
        } else if (text.length() > maxLetters) {
            editText.setError("Maximum " + maxLetters + " letters allowed");
        } else {
            editText.setError(null);
        }
    }
}
