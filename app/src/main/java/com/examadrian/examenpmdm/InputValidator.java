package com.examadrian.examenpmdm;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class InputValidator {
    public static void validarCampoVacio(TextInputLayout campo, String mensajeError) {
        EditText editText = campo.getEditText();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                campo.setError(charSequence.toString().isEmpty() ? mensajeError : null);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }
    public  static boolean validateInputs(List<TextInputLayout> inputLayouts, View.OnClickListener context){
        boolean isValid = true;
        for (TextInputLayout inputLayout : inputLayouts){
            String text = inputLayout.getEditText().getText().toString();
            if (TextUtils.isEmpty(text)){
                inputLayout.setError("Por favor, completa este campo");
                isValid = false;
            } else {
                inputLayout.setError(null);
            }
        }
        return isValid;
    }
}
