package com.example.ratingplaces.model;

import java.io.Serializable;

public class HPlaces implements Serializable {

    private String hPlaceName;
    private String country;
    private String describtion;
    private int imageReference;
    private int rate;

    public HPlaces(String hPlaceName, String country, String describtion, int imageReference) {
        this.hPlaceName = hPlaceName;
        this.country = country;
        this.describtion = describtion;
        this.imageReference = imageReference;
        rate = 0;
    }

    public String gethPlaceName() {
        return hPlaceName;
    }

    public void sethPlaceName(String hPlaceName) {
        this.hPlaceName = hPlaceName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public int getImageReference() {
        return imageReference;
    }

    public void setImageReference(int imageReference) {
        this.imageReference = imageReference;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
