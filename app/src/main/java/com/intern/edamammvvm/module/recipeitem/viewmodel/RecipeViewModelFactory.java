package com.intern.edamammvvm.module.recipeitem.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.intern.edamammvvm.module.search.model.RecipeItem;

public class RecipeViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private Application mApplication;
    private RecipeItem params;

    public RecipeViewModelFactory(Application application, RecipeItem param) {
        mApplication = application;
        params = param;
    }    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new RecipeViewModel(new MutableLiveData<>(params));
    }
}
