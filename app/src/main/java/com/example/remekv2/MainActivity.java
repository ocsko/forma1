package com.example.remekv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnFogadas;
    Button btnEddigiFogadasok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFogadas = findViewById(R.id.buttonFogadas);
        btnEddigiFogadasok = findViewById(R.id.buttonEddigFogadasok);

        btnFogadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), fogadas.class);
                startActivity(intent);
                finish();
            }
        });

        btnEddigiFogadasok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), eddigifogadasok.class);
                startActivity(intent);
                finish();
            }
        });


    }

}