package com.example.myprojectv3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GerritAPI {

    //Specify the request type and pass the relative URL//

    @GET("/api/v2/pokemon/ditto/")

    //Wrap the response in a Call object with the type of the expected result//

    Call<List<RetroUsers>> getAllUsers();
}
