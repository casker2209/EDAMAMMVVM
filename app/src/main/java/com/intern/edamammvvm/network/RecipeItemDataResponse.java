package com.intern.edamammvvm.network;

import com.google.gson.annotations.SerializedName;
import com.intern.edamammvvm.module.search.model.RecipeItem;

import java.util.List;

public class RecipeItemDataResponse {
    @SerializedName("recipe")
    RecipeItem item;

    public RecipeItemDataResponse(RecipeItem item){
        this.item = item;
    }
    public RecipeItem getItem() {
        return item;
    }

    public void setItem(RecipeItem item) {
        this.item = item;
    }
}
