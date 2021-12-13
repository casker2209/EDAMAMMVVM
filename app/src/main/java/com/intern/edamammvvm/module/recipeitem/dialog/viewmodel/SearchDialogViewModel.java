package com.intern.edamammvvm.module.recipeitem.dialog.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.MutableLiveData;

import com.intern.edamammvvm.module.search.model.SearchQuery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SearchDialogViewModel extends BaseObservable implements Serializable {
    private MutableLiveData<List<String>> dietQuery;
    private MutableLiveData<List<String>> healthQuery;
    private MutableLiveData<List<String>> cuisineQuery;
    private MutableLiveData<List<String>> mealType;
    private MutableLiveData<List<String>> dishType;



    public SearchDialogViewModel() {
        dietQuery = new MutableLiveData<>(new ArrayList<>());
        healthQuery = new MutableLiveData<>(new ArrayList<>());
        cuisineQuery = new MutableLiveData<>(new ArrayList<>());
        mealType = new MutableLiveData<>(new ArrayList<>());
        dishType = new MutableLiveData<>(new ArrayList<>());
    }

    public SearchDialogViewModel(SearchQuery searchQuery) {
        dietQuery = new MutableLiveData<>(searchQuery.getDietQuery());
        healthQuery = new MutableLiveData<>(searchQuery.getHealthQuery());
        cuisineQuery = new MutableLiveData<>(searchQuery.getCuisineQuery());
        mealType = new MutableLiveData<>(searchQuery.getMealType());
        dishType = new MutableLiveData<>(searchQuery.getDishType());
    }

    public void onCheck(CharSequence boxView,MutableLiveData<List<String>> list,Boolean bool){
        String checkbox = boxView.toString();
        if(bool){
            if(!list.getValue().contains(checkbox)){
                add(list,checkbox);
            }
        }
        else{
            if(list.getValue().contains(checkbox)) remove(list,checkbox);
        }
    }

    public MutableLiveData<List<String>> getDietQuery() {
        return dietQuery;
    }

    public void setDietQuery(MutableLiveData<List<String>> dietQuery) {
        this.dietQuery = dietQuery;
    }

    public MutableLiveData<List<String>> getHealthQuery() {
        return healthQuery;
    }

    public void setHealthQuery(MutableLiveData<List<String>> healthQuery) {
        this.healthQuery = healthQuery;
    }

    public MutableLiveData<List<String>> getCuisineQuery() {
        return cuisineQuery;
    }

    public void setCuisineQuery(MutableLiveData<List<String>> cuisineQuery) {
        this.cuisineQuery = cuisineQuery;
    }

    public MutableLiveData<List<String>> getMealType() {
        return mealType;
    }

    public void setMealType(MutableLiveData<List<String>> mealType) {
        this.mealType = mealType;
    }

    public MutableLiveData<List<String>> getDishType() {
        return dishType;
    }

    public void setDishType(MutableLiveData<List<String>> dishType) {
        this.dishType = dishType;
    }

    private void remove(MutableLiveData<List<String>> listMutable, String checkbox) {
        List<String> list = listMutable.getValue();
        list.remove(checkbox);
        listMutable.setValue(list);
    }

    private void add(MutableLiveData<List<String>> listMutable,String checkbox){
        List<String> list = listMutable.getValue();
        list.add(checkbox);
        listMutable.setValue(list);
    }
    public Boolean contain(MutableLiveData<List<String>> liveData,String checkbox){
        return liveData.getValue().contains(checkbox);
    }

    public SearchQuery getQuery(){
        return new SearchQuery(getDietQuery().getValue(),getHealthQuery().getValue(),getCuisineQuery().getValue(),getDishType().getValue(),getMealType().getValue());
    }
}
