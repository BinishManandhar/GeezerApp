package com.example.binish.geezerapp.repositories;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.binish.geezerapp.models.Parameters;
import com.example.binish.geezerapp.network.RetrofitInstance;
import com.example.binish.geezerapp.network.RetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetSearchParameters {
    String TAG = "ParameterRetrofit";
    private static GetSearchParameters instance;
    RetrofitInterface service;
    MutableLiveData<Parameters> liveParameters = new MutableLiveData<>();

    public static GetSearchParameters getInstance(){
        if(instance==null) {
            instance = new GetSearchParameters();
        }
        return instance;
    }

    private GetSearchParameters(){
        service = RetrofitInstance.getRetrofitInstance().create(RetrofitInterface.class);
        retrofit2.Call<Parameters> call = service.getParameters();
        call.enqueue(new Callback<Parameters>() {
            @Override
            public void onResponse(Call<Parameters> call, Response<Parameters> response) {
                Parameters parameters = response.body();
                liveParameters.setValue(parameters);
            }

            @Override
            public void onFailure(Call<Parameters> call, Throwable t) {
                Log.i(TAG, "onFailure: "+t);
            }
        });

    }
    public MutableLiveData<Parameters> getParameters(){
        return liveParameters;
    }
}
