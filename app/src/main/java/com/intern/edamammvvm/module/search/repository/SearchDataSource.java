package com.intern.edamammvvm.module.search.repository;

import com.intern.edamammvvm.module.search.model.RecipeItem;
import com.intern.edamammvvm.module.search.model.SearchQuery;
import com.intern.edamammvvm.network.RecipeItemResponse;

import java.util.List;

import io.reactivex.Observable;

public interface SearchDataSource {
    Observable<List<RecipeItem>> getRecipeItemResponse(String query);
    Observable<List<RecipeItem>> getRecipeItemResponse(String query, SearchQuery searchQuery);
}
