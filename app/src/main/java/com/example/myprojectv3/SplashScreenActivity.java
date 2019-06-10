package com.example.myprojectv3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //rediriger vers la page principale après un delay de 3s
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // demarrer une page
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        // handler post delay
        new Handler().postDelayed(runnable, 2000);

    }
}
