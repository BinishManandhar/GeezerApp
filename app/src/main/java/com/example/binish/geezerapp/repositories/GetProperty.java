package com.example.binish.geezerapp.repositories;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.binish.geezerapp.models.AdvanceSearchBody;
import com.example.binish.geezerapp.models.Property;
import com.example.binish.geezerapp.models.Result;
import com.example.binish.geezerapp.models.SearchBody;
import com.example.binish.geezerapp.network.RetrofitInstance;
import com.example.binish.geezerapp.network.RetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetProperty {
    String TAG = "ParameterRetrofit";
    private static GetProperty instance;
    RetrofitInterface service;
    MutableLiveData<Result> liveResult = new MutableLiveData<>();

    public static GetProperty getInstance(){
        if(instance==null) {
            instance = new GetProperty();
        }
        return instance;
    }

    public MutableLiveData<Result> getParameters(SearchBody searchBody){
        service = RetrofitInstance.getRetrofitInstance().create(RetrofitInterface.class);
        retrofit2.Call<Result> call = service.searchProperty(searchBody);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                liveResult.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
        return liveResult;
    }

    public MutableLiveData<Result> getAdvanceParameters(AdvanceSearchBody searchBody){
        service = RetrofitInstance.getRetrofitInstance().create(RetrofitInterface.class);
        retrofit2.Call<Result> call = service.searchAdvanceProperty(searchBody);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                liveResult.setValue(response.body());
                Log.i(TAG, "onResponse: "+response.body().getNum_matched());

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
        return liveResult;
    }


}
