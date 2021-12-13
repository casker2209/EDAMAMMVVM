package com.intern.edamammvvm.module.recipeitem.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.intern.edamammvvm.module.search.model.RecipeItem;

public class RecipeViewModel extends ViewModel {
    MutableLiveData<RecipeItem> recipeItem;

    public RecipeViewModel(MutableLiveData<RecipeItem> recipeItem) {
        this.recipeItem = recipeItem;
    }

    public MutableLiveData<RecipeItem> getRecipeItem() {
        return recipeItem;
    }

    public void setRecipeItem(RecipeItem recipeItem) {
        this.recipeItem = new MutableLiveData<>(recipeItem);
    }


}
