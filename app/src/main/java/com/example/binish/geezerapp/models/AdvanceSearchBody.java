package com.example.binish.geezerapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AdvanceSearchBody {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice_low() {
        return price_low;
    }

    public void setPrice_low(int price_low) {
        this.price_low = price_low;
    }

    public int getPrice_high() {
        return price_high;
    }

    public void setPrice_high(int price_high) {
        this.price_high = price_high;
    }

    public ArrayList<String> getNum_bedrooms() {
        return num_bedrooms;
    }

    public void setNum_bedrooms(ArrayList<String> num_bedrooms) {
        this.num_bedrooms = num_bedrooms;
    }

    public ArrayList<String> getNum_bathrooms() {
        return num_bathrooms;
    }

    public void setNum_bathrooms(ArrayList<String> num_bathrooms) {
        this.num_bathrooms = num_bathrooms;
    }

    public int getSize_min() {
        return size_min;
    }

    public void setSize_min(int size_min) {
        this.size_min = size_min;
    }

    public int getSize_max() {
        return size_max;
    }

    public void setSize_max(int size_max) {
        this.size_max = size_max;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFurnishing() {
        return furnishing;
    }

    public void setFurnishing(String furnishing) {
        this.furnishing = furnishing;
    }

    public int getYear_built_min() {
        return year_built_min;
    }

    public void setYear_built_min(int year_built_min) {
        this.year_built_min = year_built_min;
    }

    public int getYear_built_max() {
        return year_built_max;
    }

    public void setYear_built_max(int year_built_max) {
        this.year_built_max = year_built_max;
    }

    public ArrayList<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(ArrayList<String> facilities) {
        this.facilities = facilities;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    @SerializedName("keyword")
    String keyword;
    @SerializedName("sort_by")
    String sort_by="price_asc";
    @SerializedName("result_size")
    String result_size="5";
    @SerializedName("skip")
    int skip;
    @SerializedName("location")
    String location;
    @SerializedName("price_low")
    int price_low;
    @SerializedName("price_high")
    int price_high;
    @SerializedName("num_bedrooms")
    ArrayList<String> num_bedrooms;
    @SerializedName("num_bathrooms")
    ArrayList<String> num_bathrooms;
    @SerializedName("size_min")
    int size_min;
    @SerializedName("size_max")
    int size_max;
    @SerializedName("type")
    String type;
    @SerializedName("furnishing")
    String furnishing;
    @SerializedName("year_built_min")
    int year_built_min;
    @SerializedName("year_built_max")
    int year_built_max;
    @SerializedName("facilities")
    ArrayList<String> facilities;
    @SerializedName("transport")
    String transport;
}
