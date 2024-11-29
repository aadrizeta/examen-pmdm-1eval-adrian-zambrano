package com.examadrian.examenpmdm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.loginButton);
        TextInputLayout loginInput = findViewById(R.id.loginInput);
        TextInputLayout password = findViewById(R.id.passwordInput);
        InputValidator.validarCampoVacio(loginInput, "Debes introducir un nombre de usuario");
        InputValidator.validarCampoVacio(password, "Debes introducir una contraseña");
        SharedPreferences preferences = getSharedPreferences("Registro", Context.MODE_PRIVATE);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input =String.valueOf(loginInput.getEditText().getText());
                String passwordInput = String.valueOf(password.getEditText().getText());

                List <TextInputLayout> inputLayouts = List.of(loginInput, password);

                if (InputValidator.validateInputs(inputLayouts, this)){

                    if (passwordInput.equals("@string/password")){
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("username", input);
                        launchMain();
                    } else {
                        password.setError("Contraseña incorrecta");
                    }



                }

            }
        });

    }
    public void launchMain() {
        Intent intent = new Intent(Login.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}