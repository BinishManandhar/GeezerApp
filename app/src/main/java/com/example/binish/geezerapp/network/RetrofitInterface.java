package com.example.binish.geezerapp.network;

import com.example.binish.geezerapp.models.Parameters;
import com.example.binish.geezerapp.models.Property;
import com.example.binish.geezerapp.models.Result;
import com.example.binish.geezerapp.models.SearchBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface {
    @GET("/parameters/search")
    Call<Parameters> getParameters();

    @POST("/search")
    Call<Result> searchProperty(@Body SearchBody searchBody);
}
