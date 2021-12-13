package com.intern.edamammvvm.utils;

import com.intern.edamammvvm.module.search.model.RecipeItem;
import com.intern.edamammvvm.network.RecipeItemResponse;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import io.reactivex.Observable;

public interface RecipeAPI {
    public static final String BASE_URL = "https://api.edamam.com/api/";
    @GET("recipes/v2")
    Observable<RecipeItemResponse> getRecipeItemResponse(@Query("q") String query
    ,@Query("diet") List<String> diet,@Query("health") List<String> health,
                                                         @Query("cuisineType") List<String> cuisine,
                                                         @Query("mealType") List<String> meal,
                                                         @Query("dishType") List<String> type

    );

}
