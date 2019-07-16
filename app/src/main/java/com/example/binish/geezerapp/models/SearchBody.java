package com.example.binish.geezerapp.models;

import com.google.gson.annotations.SerializedName;

public class SearchBody {
    @SerializedName("keyword")
    String keyword;
    @SerializedName("sort_by")
    String sort_by="price_asc";
    @SerializedName("result_size")
    String result_size="10";
    @SerializedName("skip")
    int skip;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSort_by() {
        return sort_by;
    }

    public void setSort_by(String sort_by) {
        this.sort_by = sort_by;
    }

    public String getResult_size() {
        return result_size;
    }

    public void setResult_size(String result_size) {
        this.result_size = result_size;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }
}
