package com.example.remekv2;

import android.os.Looper;
import android.os.Handler;

import com.vishnusivadas.advanced_httpurlconnection.PutData;


public class FelhasznaloRegisztracio {
    protected void adatFeltoltes(User user) {
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
                    field[0] = "Username";
                    field[1] = "Password";
                    field[2] = "Fullname";
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

                    PutData putData = new PutData("http://25.83.130.147/forma1php/register.php", "POST", field, data);

                    if (putData.startPut()) {
                        if (putData.onComplete()) {

                        }
                    }

                }


            });

        }
        else {

        }
    }
}
