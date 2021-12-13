package com.intern.edamammvvm.module.search.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class RecipeItem implements Serializable {
    @SerializedName("image")
    private String image;
    @SerializedName("dietLabels")
    private List<String> dietLabels;
    @SerializedName("healthLabels")
    private List<String> healthLabels;
    @SerializedName("shareAs")
    private String webUrl;
    @SerializedName("label")
    private String label;
    @SerializedName("ingredients")
    private List<Ingredient> ingredientList;
    @SerializedName("cuisineType")
    private List<String> cuisineType;
    @SerializedName("mealType")
    private List<String> mealType;
    @SerializedName("dishType")
    private List<String> dishType;
    @SerializedName("calories")
    private float calories;
    @SerializedName("totalWeight")
    private float totalWeight;
    @SerializedName("totalTime")
    private float totalTime;

    public RecipeItem(String image, List<String> dietLabels, List<String> healthLabels, String label, List<Ingredient> ingredientList, List<String> cuisineType, List<String> mealType, List<String> dishType, float calories, float totalWeight, float totalTime,String webUrl) {
        this.image = image;
        this.dietLabels = dietLabels;
        this.healthLabels = healthLabels;
        this.label = label;
        this.ingredientList = ingredientList;
        this.cuisineType = cuisineType;
        this.mealType = mealType;
        this.dishType = dishType;
        this.calories = calories;
        this.totalWeight = totalWeight;
        this.totalTime = totalTime;
        this.webUrl = webUrl;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getDietLabels() {
        return dietLabels;
    }

    public void setDietLabels(List<String> dietLabels) {
        this.dietLabels = dietLabels;
    }

    public List<String> getHealthLabels() {
        return healthLabels;
    }

    public void setHealthLabels(List<String> healthLabels) {
        this.healthLabels = healthLabels;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public List<String> getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(List<String> cuisineType) {
        this.cuisineType = cuisineType;
    }

    public List<String> getMealType() {
        return mealType;
    }

    public void setMealType(List<String> mealType) {
        this.mealType = mealType;
    }

    public List<String> getDishType() {
        return dishType;
    }

    public void setDishType(List<String> dishType) {
        this.dishType = dishType;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public float getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(float totalWeight) {
        this.totalWeight = totalWeight;
    }

    public float getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(float totalTime) {
        this.totalTime = totalTime;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
}
