package com.example.remekv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class fogadas extends AppCompatActivity {

    Spinner teamSpinner, racerSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fogadas);

        teamSpinner = findViewById(R.id.team_spinner);
        racerSpinner = findViewById(R.id.racer_spinner);


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

    }
}