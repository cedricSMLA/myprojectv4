package com.example.myprojectv3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);

        //Create a handler for the RetrofitInstance interface//
        GerritAPI service = Controller.getRetrofitInstance().create(GerritAPI.class);

        Call<List<RetroUsers>> call = service.getAllCountries();

        //Execute the request asynchronously//
        call.enqueue(new Callback<List<RetroUsers>>() {

            @Override

            //Handle a successful response//
            public void onResponse(Call<List<RetroUsers>> call, Response<List<RetroUsers>> response) {
                loadDataList(response.body());
            }

            @Override
            //Handle execution failures//
            public void onFailure(Call<List<RetroUsers>> call, Throwable throwable) {

                //If the request fails, then display the following toast//
                Toast.makeText(MainActivity.this, "Unable to load countries", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Display the retrieved data as a list//
    private void loadDataList(List<RetroUsers> usersList) {

        //Get a reference to the RecyclerView//
        recyclerView = findViewById(R.id.myRecyclerView);
        mAdapter = new MyAdapter(usersList, new OnItemClickListener() {
            @Override
            public void onItemClick(RetroUsers item) {
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);

                intent.putExtra("Region", item.getRegion());
                intent.putExtra("Capital", item.getCapital());
                //
                //

                startActivity(intent);
            }
        });

        //Use a LinearLayoutManager with default vertical orientation//
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        //Set the Adapter to the RecyclerView//
        recyclerView.setAdapter(mAdapter);
    }

}
