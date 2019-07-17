package com.example.binish.geezerapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.binish.geezerapp.models.AdvanceSearchBody;
import com.example.binish.geezerapp.models.DefaultDisplay;
import com.example.binish.geezerapp.models.Parameters;
import com.example.binish.geezerapp.models.Property;
import com.example.binish.geezerapp.models.Result;
import com.example.binish.geezerapp.models.SearchBody;
import com.example.binish.geezerapp.repositories.GetProperty;
import com.example.binish.geezerapp.repositories.GetSearchParameters;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GetData extends ViewModel {
    String TAG = "ParameterRetrofit";
    private MutableLiveData<Parameters> parameters;
    private MutableLiveData<Result> result;
    public GetData(){
        GetSearchParameters getSearchParameters = GetSearchParameters.getInstance();
        parameters = getSearchParameters.getParameters();
    }

    public LiveData<Parameters> getParameters(){
        return parameters;
    }

    public void setProperty(SearchBody searchBody){
        GetProperty getProperty = GetProperty.getInstance();
        result = getProperty.getParameters(searchBody);
    }
    public LiveData<Result> getProperty(){
        return result;
    }

    public void setPropertyAdvance(AdvanceSearchBody advanceSearchBody){
        GetProperty getProperty = GetProperty.getInstance();
        result = getProperty.getAdvanceParameters(advanceSearchBody);
    }

    public void setPropertyAll(DefaultDisplay defaultDisplay){
        GetProperty getProperty = GetProperty.getInstance();
        result = getProperty.getAll(defaultDisplay);
    }
}
