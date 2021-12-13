package com.intern.edamammvvm.module.search.repository;

import com.intern.edamammvvm.module.search.model.RecipeItem;
import com.intern.edamammvvm.module.search.model.SearchQuery;
import com.intern.edamammvvm.network.RecipeItemResponse;
import com.intern.edamammvvm.utils.RetrofitClient;

import java.util.List;

import io.reactivex.Observable;

public class SearchDataRepository implements SearchDataSource {
    private static SearchDataRepository repository;
    private SearchDataSource remoteDataSource;

    private SearchDataRepository() {
        this.remoteDataSource = new SearchRemoteDataSource().getInstance();
    }

    public static SearchDataRepository getInstance(){
        if(repository != null) return repository;
        repository = new SearchDataRepository();
        return repository;
    }
    @Override
    public Observable<List<RecipeItem>> getRecipeItemResponse(String query) {
        return remoteDataSource.getRecipeItemResponse(query);
    }
    @Override
    public Observable<List<RecipeItem>> getRecipeItemResponse(String query, SearchQuery searchQuery){
        return remoteDataSource.getRecipeItemResponse(query,searchQuery);
    }
}
