package com.intern.edamammvvm.module.search.repository;

import android.util.Log;

import com.intern.edamammvvm.module.search.model.RecipeItem;
import com.intern.edamammvvm.module.search.model.SearchQuery;
import com.intern.edamammvvm.network.RecipeItemDataResponse;
import com.intern.edamammvvm.network.RecipeItemResponse;
import com.intern.edamammvvm.utils.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SearchRemoteDataSource implements SearchDataSource {
    private static SearchRemoteDataSource instance;
    public static SearchRemoteDataSource getInstance(){
        if(instance != null) return instance;
        instance = new SearchRemoteDataSource();
        return instance;
    }
    public List<RecipeItem> handleRecipeItemResponse(RecipeItemResponse recipeItemResponse){
        List<RecipeItemDataResponse> list = recipeItemResponse.getRecipeItemList();
        List<RecipeItem> recipeItems = new ArrayList<>();
        for(RecipeItemDataResponse response: list){
            recipeItems.add(response.getItem());
        }
        return recipeItems;
    }
    @Override
    public Observable<List<RecipeItem>> getRecipeItemResponse(String query) {
        return null;
    }

    @Override
    public Observable<List<RecipeItem>> getRecipeItemResponse(String query, SearchQuery searchQuery) {
        return RetrofitClient.getRecipeAPI().getRecipeItemResponse(query,searchQuery.getDietQuery()
        ,searchQuery.getHealthQuery(),searchQuery.getCuisineQuery(),searchQuery.getMealType(),searchQuery.getDishType()
                ).subscribeOn(Schedulers.io())
                .map(this::handleRecipeItemResponse);    }
}
