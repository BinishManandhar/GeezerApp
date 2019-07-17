package com.example.binish.geezerapp.models;

import com.google.gson.annotations.SerializedName;

public class DefaultDisplay {
    @SerializedName("sort_by")
    String sort_by;
    @SerializedName("result_size")
    int result_size;
    @SerializedName("skip")
    int skip=0;

    public String getSort_by() {
        return sort_by;
    }

    public void setSort_by(String sort_by) {
        this.sort_by = sort_by;
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
}
