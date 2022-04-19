package com.example.remekv2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Regisztracio  extends AppCompatActivity {

    TextInputEditText textInputEditTextUsername, textInputEditTextPassword, textInputEditTextFullName, textInputEditTextEmail, textInputEditTextBornDate, textInputEditTextCardNumber;
    Button registerButton;
    TextView loginText, loginTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisztracio);

        textInputEditTextUsername = findViewById(R.id.username);
        textInputEditTextPassword = findViewById(R.id.password);
        textInputEditTextFullName = findViewById(R.id.fullname);
        textInputEditTextEmail = findViewById(R.id.email);
        textInputEditTextBornDate = findViewById(R.id.borndate);
        textInputEditTextCardNumber = findViewById(R.id.cardnumber);

        registerButton = findViewById(R.id.registerButton);
        loginTV = findViewById(R.id.loginTextView);

        loginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), bejelentkezes.class);
                startActivity(intent);
                finish();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User(String.valueOf(textInputEditTextUsername.getText())
                        ,String.valueOf(textInputEditTextPassword.getText())
                        ,String.valueOf(textInputEditTextFullName.getText())
                        ,String.valueOf(textInputEditTextEmail.getText())
                        ,String.valueOf(textInputEditTextBornDate.getText())
                        ,String.valueOf(textInputEditTextCardNumber.getText()));

                if (!user.getUsername().equals("") &&
                        !user.getPassword().equals("") &&
                        !user.getFullName().equals("") &&
                        !user.getEmail().equals("") &&
                        !user.getBornDate().equals("") &&
                        !user.getCardNumber().equals("")) {
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable(){
                        @Override
                        public void run() {
                            String[] field = new String[6];
                            field[0] = "username";
                            field[1] = "password";
                            field[2] = "FullName";
                            field[3] = "Email";
                            field[4] = "BornDate";
                            field[5] = "CardNumber";

                            String[] data = new String[6];
                            data[0] =  user.getUsername();
                            data[1] = user.getPassword();
                            data[2] = user.getFullName();
                            data[3] = user.getEmail();
                            data[4] = String.valueOf(user.getBornDate());
                            data[5] = String.valueOf(user.getCardNumber());

                            PutData putData = new PutData("http://192.168.0.17/forma1php/register.php", "POST", field, data);

                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if(result.equals("Sign Up Success")) {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(),bejelentkezes.class);
                                        startActivity(intent);
                                        finish();
                                    }else {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                    Log.i("PutData", result);


                                }
                            }

                        }


                    });

                }
                else {
                    Toast.makeText(getApplicationContext(), "All fields required!", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }


}
