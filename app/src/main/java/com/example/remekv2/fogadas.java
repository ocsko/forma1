package com.example.remekv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class fogadas extends AppCompatActivity {

    Spinner teamSpinner, racerSpinner, locationSpinner;
    Button fogadasButton;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fogadas);

        teamSpinner = findViewById(R.id.team_spinner);
        racerSpinner = findViewById(R.id.racer_spinner);
        locationSpinner = findViewById(R.id.location_spinner);
        fogadasButton = findViewById(R.id.fogadasButton);
        backButton = findViewById(R.id.imageBackButton);

        String[] locations = new String[]{"Bahrein", "Szaúd-Arábia", "Ausztrália", "San-Marino", "USA(Miami)", "Spanyolország", "Monaco", "Azerbajdzsán", "Kanada", "Egyesült Királyság", "Ausztria", "Franciaország", "Magyarország", "Belgium", "Hollandia", "Olaszország", "Szingapúr", "Japán", "USA(Austin)", "Mexikó", "Brazília", "Egyesült Arab Emírségek"};
        final ArrayAdapter<String> locationsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, locations);
        locationSpinner.setAdapter(locationsAdapter);

        String[] teams = new String[]{"Red Bull Racing", "Mercedes-AMG", "McLaren-Mercedes", "Williams-Mercedes", "Ferrari", "Haas-Ferrari",
                "Alfa Romeo Racing", "AlphaTauri-Red Bull", "Alpine-Renault", "Aston Martin"};
        final ArrayAdapter<String> teamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, teams);
        teamSpinner.setAdapter(teamsAdapter);

        String[] redBullRacers = new String[]{"Max Verstappen", "Sergio Pérez"};
        final ArrayAdapter<String> redBullAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, redBullRacers);

        String[] alphatauriRacers = new String[]{"Pierre Gasly", "Yuki Tsunoda"};
        final ArrayAdapter<String> alphatauriAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alphatauriRacers);

        String[] mercedesAmgRacers = new String[]{"Lewis Hamilton", "George Russell"};
        final ArrayAdapter<String> mercedesAmgAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, mercedesAmgRacers);

        String[] mcLarenRacers = new String[]{"Daniel Ricardo", "Lando Norris"};
        final ArrayAdapter<String> mcLarenAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, mcLarenRacers);

        String[] williamsRacers = new String[]{"Alex Albon", "Nicholas Latifi"};
        final ArrayAdapter<String> williamsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, williamsRacers);

        String[] ferrariRacers = new String[]{"Carlos Sainz Jr.", "Charles Leclerc"};
        final ArrayAdapter<String> ferrariAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ferrariRacers);

        String[] haasRacers = new String[]{"Mick Schumacher", "Kevin Magnussen"};
        final ArrayAdapter<String> haasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, haasRacers);

        String[] alfaromeoRacers = new String[]{"Valtteri Bottas", "Guanyu Zhou"};
        final ArrayAdapter<String> alfaromeoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alfaromeoRacers);

        String[] alpineRacers = new String[]{"Fernando Alonso", "Esteban Ocon"};
        final ArrayAdapter<String> alpineAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alpineRacers);

        String[] astonRacers = new String[]{"Sebastian Vettel", "Lance Stroll"};
        final ArrayAdapter<String> astonAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, astonRacers);

        teamSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String spinnerValue = teamSpinner.getSelectedItem().toString();
                if (spinnerValue.equals("Red Bull Racing")) {
                    racerSpinner.setAdapter(redBullAdapter);

                } else if (spinnerValue.equals("AlphaTauri-Red Bull")){
                    racerSpinner.setAdapter(alphatauriAdapter);

                }else if (spinnerValue.equals("Mercedes-AMG")){
                    racerSpinner.setAdapter(mercedesAmgAdapter);

                }else if (spinnerValue.equals("McLaren-Mercedes")){
                    racerSpinner.setAdapter(mcLarenAdapter);

                }else if (spinnerValue.equals("Ferrari")) {
                    racerSpinner.setAdapter(ferrariAdapter);

                }else if (spinnerValue.equals("Williams-Mercedes")){
                    racerSpinner.setAdapter(williamsAdapter);

                }else if (spinnerValue.equals("Haas-Ferrari")){
                    racerSpinner.setAdapter(haasAdapter);

                }else if (spinnerValue.equals("Alfa Romeo Racing")){
                    racerSpinner.setAdapter(alfaromeoAdapter);

                }else if (spinnerValue.equals("Alpine-Renault")){
                    racerSpinner.setAdapter(alpineAdapter);

                }else if (spinnerValue.equals("Aston Martin")){
                    racerSpinner.setAdapter(astonAdapter);
                }


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        fogadasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = locationSpinner.getSelectedItem().toString();
                String team = teamSpinner.getSelectedItem().toString();
                String racer = racerSpinner.getSelectedItem().toString();

                if(!location.equals("")) {
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[3];
                            field[0] = "race";
                            field[1] = "team";
                            field[2] = "driver";
                            //Creating array for data
                            String[] data = new String[3];
                            data[0] = location;
                            data[1] = team;
                            data[2] = racer;
                            //PutData putData = new PutData("http://localhost/registerlogin/signup.php", "POST", field, data);
                            PutData putData = new PutData("http://192.168.0.17/forma1php/bet.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if(result.equals("Bet Success")){
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }else{
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                    Log.i("PutData", result);
                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(), "All fields required!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}