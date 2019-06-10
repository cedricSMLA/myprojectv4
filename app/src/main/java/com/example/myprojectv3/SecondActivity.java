package com.example.myprojectv3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Gson gson = new Gson();
        String strObj = getIntent().getStringExtra("key");
        Change products = gson.fromJson(strObj, Change.class);
    }
}
