package com.example.myprojectv3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Retrofit client class

public class Controller {

    private static Retrofit retrofit;

//Define the base URL//

    private static final String BASE_URL = "https://restcountries.eu/rest/v2/";

//Create the Retrofit instance//

    public static Retrofit getRetrofitInstance() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)

//Add the converter//

                    .addConverterFactory(GsonConverterFactory.create())

//Build the Retrofit instance//

                    .build();
        }

        GerritAPI restApi = retrofit.create(GerritAPI.class);

        Call<List<RetroUsers>> call = restApi.getAllCountries();

        return retrofit;
    }
}