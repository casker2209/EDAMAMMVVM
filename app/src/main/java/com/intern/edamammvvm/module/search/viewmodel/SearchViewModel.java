package com.intern.edamammvvm.module.search.viewmodel;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.intern.edamammvvm.module.search.model.RecipeItem;
import com.intern.edamammvvm.module.search.model.SearchQuery;
import com.intern.edamammvvm.module.search.repository.SearchDataRepository;
import com.intern.edamammvvm.utils.RetrofitClient;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


public class SearchViewModel extends ViewModel {
    private CompositeDisposable compositeDisposable;
    private Disposable fetchDisposable;
    private SearchDataRepository dataRepository;
    private MutableLiveData<List<RecipeItem>> onSuccess;
    private MutableLiveData<Boolean> onFailure;
    private ObservableField<String> TextField;
    private MutableLiveData<SearchQuery> searchQuery;
    private MutableLiveData<Boolean> onLoading;
    public SearchViewModel() {
        this.compositeDisposable = new CompositeDisposable();
        this.dataRepository = SearchDataRepository.getInstance();
        TextField = new ObservableField<>();
        onSuccess = new MutableLiveData<>();
        onFailure = new MutableLiveData<>();
        searchQuery = new MutableLiveData<>(new SearchQuery());
        onLoading = new MutableLiveData<>();
    }

    public void getRecipeItem(String query){
        onLoading.setValue(true);
        if(fetchDisposable != null){
            compositeDisposable.remove(fetchDisposable);
        }
        fetchDisposable = Observable.interval(15,TimeUnit.SECONDS)
                .startWith(0L)
                .flatMap(aLong -> dataRepository.getRecipeItemResponse(query,searchQuery.getValue()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    fetchDisposable.dispose();
                    onSuccess.setValue(response);
                    onLoading.setValue(false);
                },e -> {
                    e.printStackTrace();
                    onFailure.setValue(true);
                    onLoading.setValue(false);
                },() -> {
                });
        compositeDisposable.add(fetchDisposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }

    public MutableLiveData<Boolean> getOnFailure() {
        return onFailure;
    }

    public MutableLiveData<List<RecipeItem>> getOnSuccess() {
        return onSuccess;
    }

    public ObservableField<String> getTextField() {
        return TextField;
    }

    public void setTextField(ObservableField<String> textField) {
        TextField = textField;
    }

    public MutableLiveData<SearchQuery> getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(SearchQuery searchQuery) {
        this.searchQuery.setValue(searchQuery);
    }

    public MutableLiveData<Boolean> getOnLoading() {
        return onLoading;
    }
}
