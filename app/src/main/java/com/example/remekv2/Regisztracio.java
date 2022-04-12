package com.example.remekv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Regisztracio  extends AppCompatActivity {

    TextInputEditText textInputEditTextUsername, textInputEditTextPassword, textInputEditTextFullName, textInputEditTextEmail, textInputEditTextBornDate, textInputEditTextCardNumber;
    Button registerButton;
    FelhasznaloRegisztracio felhasznaloRegisztracio;
    TextView loginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisztracio);
        felhasznaloRegisztracio = new FelhasznaloRegisztracio();

        textInputEditTextUsername = findViewById(R.id.Username);
        textInputEditTextPassword = findViewById(R.id.Password);
        textInputEditTextFullName = findViewById(R.id.FullName);
        textInputEditTextEmail = findViewById(R.id.Email);
        textInputEditTextBornDate = findViewById(R.id.BornDate);
        textInputEditTextCardNumber = findViewById(R.id.CardNumber);

        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User(String.valueOf(textInputEditTextUsername.getText())
                        ,String.valueOf(textInputEditTextPassword.getText())
                        ,String.valueOf(textInputEditTextFullName.getText())
                        ,String.valueOf(textInputEditTextEmail.getText())
                        ,String.valueOf(textInputEditTextBornDate.getText())
                        ,String.valueOf(textInputEditTextCardNumber.getText()));

                felhasznaloRegisztracio.adatFeltoltes(user);
                Intent intent = new Intent(getApplicationContext(),bejelentkezes.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
