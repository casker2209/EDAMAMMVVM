package com.intern.edamammvvm.module.search.model;

import androidx.lifecycle.MutableLiveData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SearchQuery implements Serializable {
    private List<String> dietQuery;
    private List<String> healthQuery;
    private List<String> cuisineQuery;
    private List<String> mealType;
    private List<String> dishType;

    public SearchQuery(){
        dietQuery = new ArrayList<>();
        healthQuery = new ArrayList<>();
        cuisineQuery = new ArrayList<>();
        mealType = new ArrayList<>();
        dishType = new ArrayList<>();
    }

    public SearchQuery(List<String> dietQuery, List<String> healthQuery, List<String> cuisineQuery, List<String> mealType, List<String> dishType) {
        this.dietQuery = dietQuery;
        this.healthQuery = healthQuery;
        this.cuisineQuery = cuisineQuery;
        this.mealType = mealType;
        this.dishType = dishType;
    }

    public List<String> getDietQuery() {
        return dietQuery;
    }

    public void setDietQuery(List<String> dietQuery) {
        this.dietQuery = dietQuery;
    }

    public List<String> getHealthQuery() {
        return healthQuery;
    }

    public void setHealthQuery(List<String> healthQuery) {
        this.healthQuery = healthQuery;
    }

    public List<String> getCuisineQuery() {
        return cuisineQuery;
    }

    public void setCuisineQuery(List<String> cuisineQuery) {
        this.cuisineQuery = cuisineQuery;
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
}
