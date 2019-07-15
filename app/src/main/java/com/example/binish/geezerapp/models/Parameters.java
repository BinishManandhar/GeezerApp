package com.example.binish.geezerapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Parameters {
    @SerializedName("streets")
    ArrayList<String> streets;
    @SerializedName("price_ranges")
    ArrayList<PriceRange> price_ranges;
    @SerializedName("num_bedrooms")
    ArrayList<String> num_bedrooms;
    @SerializedName("num_bathrooms")
    ArrayList<String> num_bathrooms;
    @SerializedName("types")
    ArrayList<String> types;
    @SerializedName("furnishing")
    ArrayList<String> furnishing;
    @SerializedName("facilities")
    ArrayList<String> facilities;
    @SerializedName("transport")
    ArrayList<String> transport;
    @SerializedName("popular_keywords")
    ArrayList<String> popular_keywords;

    public ArrayList<String> getStreets() {
        return streets;
    }

    public void setStreets(ArrayList<String> streets) {
        this.streets = streets;
    }

    public ArrayList<PriceRange> getPrice_ranges() {
        return price_ranges;
    }

    public void setPrice_ranges(ArrayList<PriceRange> price_ranges) {
        this.price_ranges = price_ranges;
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

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public ArrayList<String> getFurnishing() {
        return furnishing;
    }

    public void setFurnishing(ArrayList<String> furnishing) {
        this.furnishing = furnishing;
    }

    public ArrayList<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(ArrayList<String> facilities) {
        this.facilities = facilities;
    }

    public ArrayList<String> getTransport() {
        return transport;
    }

    public void setTransport(ArrayList<String> transport) {
        this.transport = transport;
    }

    public ArrayList<String> getPopular_keywords() {
        return popular_keywords;
    }

    public void setPopular_keywords(ArrayList<String> popular_keywords) {
        this.popular_keywords = popular_keywords;
    }
}
