package com.intern.edamammvvm.network;

import com.google.gson.annotations.SerializedName;
import com.intern.edamammvvm.module.search.model.RecipeItem;

import java.util.List;

public class RecipeItemResponse {
    @SerializedName("hits")
    List<RecipeItemDataResponse> recipeItemList;

    public List<RecipeItemDataResponse> getRecipeItemList() {
        return recipeItemList;
    }

    public void setRecipeItemList(List<RecipeItemDataResponse> recipeItemList) {
        this.recipeItemList = recipeItemList;
    }
}
