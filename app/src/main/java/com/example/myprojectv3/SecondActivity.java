package com.example.myprojectv3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Gson gson = new Gson();
        String strObj = getIntent().getStringExtra("key");
        Change products = gson.fromJson(strObj, Change.class);

        showExtra();
    }

    public void showExtra() {
        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);

        String region = getIntent().getStringExtra("Region");
        String capital = getIntent().getStringExtra("Capital");

        textView.setText(region);
        textView2.setText(capital);


    }
}
