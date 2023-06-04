package com.improve10x.sristores.models;

import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Product {

    private Integer id;
    private String title;
    private Float price;
    @SerializedName("images")
    private ArrayList<String> imageUrls;

    public ArrayList<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(ArrayList<String> imageUrls) {
        this.imageUrls = imageUrls;
    }


    private String description;
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
