package com.example.binish.geezerapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Result {
    @SerializedName("num_matched")
    int num_matched;
    @SerializedName("result_size")
    int result_size;
    @SerializedName("skip")
    int skip;
    @SerializedName("properties")
    ArrayList<Property> properties;

    public int getNum_matched() {
        return num_matched;
    }

    public void setNum_matched(int num_matched) {
        this.num_matched = num_matched;
    }

    public int getResult_size() {
        return result_size;
    }

    public void setResult_size(int result_size) {
        this.result_size = result_size;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }
}
