package com.intern.edamammvvm.module.recipeitem.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.intern.edamammvvm.module.search.model.Ingredient;

public class IngredientViewModel extends BaseObservable {
    MutableLiveData<Ingredient> ingredient;

    public IngredientViewModel(Ingredient data) {
        this.ingredient = new MutableLiveData<>(data);
    }
    public IngredientViewModel(){

    }

    @Bindable
    public MutableLiveData<Ingredient> getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient data) {
        this.ingredient = new MutableLiveData<>(data);
        notifyPropertyChanged(BR.viewModel);
    }
}
