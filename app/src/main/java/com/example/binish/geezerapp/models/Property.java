package com.example.binish.geezerapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Property {
    @SerializedName("name")
    String name;
    @SerializedName("monthly_rental")
    int monthly_rental;
    @SerializedName("full_address")
    String full_address;
    @SerializedName("zipcode")
    String zipcode;
    @SerializedName("street")
    String street;
    @SerializedName("type")
    String type;
    @SerializedName("num_bedrooms")
    int num_bedrooms;
    @SerializedName("num_bathrooms")
    int num_bathrooms;
    @SerializedName("size_sqft")
    int size_sqft;
    @SerializedName("year_built")
    int year_built;
    @SerializedName("parking")
    String parking;
    @SerializedName("furnishing")
    String furnishing;
    @SerializedName("description")
    String description;
    @SerializedName("max_tenants")
    int max_tenants;
    @SerializedName("availability")
    String availability;
    @SerializedName("visibility")
    boolean visibility;
    @SerializedName("location")
    Location location;
    @SerializedName("is_homepage_featured")
    String is_homepage_featured;
    @SerializedName("amenities")
    ArrayList<String> amenities;
    @SerializedName("lease_terms")
    ArrayList<String> lease_terms;
    @SerializedName("deposit_amount")
    int deposit_amount;
    @SerializedName("status")
    String status;
    @SerializedName("other_photos")
    ArrayList<String> other_photos;
    @SerializedName("images")
    ArrayList<String> images;
    @SerializedName("property_id")
    String property_id;
    @SerializedName("special")
    String special;
    @SerializedName("amenities_featureing")
    ArrayList<String> amenities_featuring;
    @SerializedName("amenities_other")
    ArrayList<String> amenities_other;
    @SerializedName("wishlisted")
    boolean wishlisted;
    @SerializedName("media")
    Media medias;
    @SerializedName("photo-large")
    String photo_large;
    @SerializedName("photo-small")
    String photo_small;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonthly_rental() {
        return monthly_rental;
    }

    public void setMonthly_rental(int monthly_rental) {
        this.monthly_rental = monthly_rental;
    }

    public String getFull_address() {
        return full_address;
    }

    public void setFull_address(String full_address) {
        this.full_address = full_address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNum_bedrooms() {
        return num_bedrooms;
    }

    public void setNum_bedrooms(int num_bedrooms) {
        this.num_bedrooms = num_bedrooms;
    }

    public int getNum_bathrooms() {
        return num_bathrooms;
    }

    public void setNum_bathrooms(int num_bathrooms) {
        this.num_bathrooms = num_bathrooms;
    }

    public int getSize_sqft() {
        return size_sqft;
    }

    public void setSize_sqft(int size_sqft) {
        this.size_sqft = size_sqft;
    }

    public int getYear_built() {
        return year_built;
    }

    public void setYear_built(int year_built) {
        this.year_built = year_built;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getFurnishing() {
        return furnishing;
    }

    public void setFurnishing(String furnishing) {
        this.furnishing = furnishing;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMax_tenants() {
        return max_tenants;
    }

    public void setMax_tenants(int max_tenants) {
        this.max_tenants = max_tenants;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getIs_homepage_featured() {
        return is_homepage_featured;
    }

    public void setIs_homepage_featured(String is_homepage_featured) {
        this.is_homepage_featured = is_homepage_featured;
    }

    public ArrayList<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(ArrayList<String> amenities) {
        this.amenities = amenities;
    }

    public ArrayList<String> getLease_terms() {
        return lease_terms;
    }

    public void setLease_terms(ArrayList<String> lease_terms) {
        this.lease_terms = lease_terms;
    }

    public int getDeposit_amount() {
        return deposit_amount;
    }

    public void setDeposit_amount(int deposit_amount) {
        this.deposit_amount = deposit_amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getOther_photos() {
        return other_photos;
    }

    public void setOther_photos(ArrayList<String> other_photos) {
        this.other_photos = other_photos;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public String getProperty_id() {
        return property_id;
    }

    public void setProperty_id(String property_id) {
        this.property_id = property_id;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public ArrayList<String> getAmenities_featuring() {
        return amenities_featuring;
    }

    public void setAmenities_featuring(ArrayList<String> amenities_featureing) {
        this.amenities_featuring = amenities_featureing;
    }

    public ArrayList<String> getAmenities_other() {
        return amenities_other;
    }

    public void setAmenities_other(ArrayList<String> amenities_other) {
        this.amenities_other = amenities_other;
    }

    public boolean getWishlisted() {
        return wishlisted;
    }

    public void setWishlisted(boolean wishlisted) {
        this.wishlisted = wishlisted;
    }

    public Media getMedias() {
        return medias;
    }

    public void setMedias(Media medias) {
        this.medias = medias;
    }

    public String getPhoto_large() {
        return photo_large;
    }

    public void setPhoto_large(String photo_large) {
        this.photo_large = photo_large;
    }

    public String getPhoto_small() {
        return photo_small;
    }

    public void setPhoto_small(String photo_small) {
        this.photo_small = photo_small;
    }
}
