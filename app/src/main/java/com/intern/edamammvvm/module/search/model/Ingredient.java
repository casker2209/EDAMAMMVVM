package com.intern.edamammvvm.module.search.model;

import com.google.gson.annotations.SerializedName;

public class Ingredient {
    @SerializedName("text")
    private String text;
    @SerializedName("quantity")
    private String quantity;
    @SerializedName("image")
    private String imageUrl;

    public Ingredient(String text, String quantity, String imageUrl) {
        this.text = text;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
