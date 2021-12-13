package com.intern.edamammvvm.module.search.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.intern.edamammvvm.R;
import com.intern.edamammvvm.app.BaseActivity;
import com.intern.edamammvvm.databinding.SearchFragmentBinding;
import com.intern.edamammvvm.module.recipeitem.dialog.view.SearchDialog;
import com.intern.edamammvvm.module.search.adapter.RecipeListAdapter;
import com.intern.edamammvvm.module.search.model.RecipeItem;
import com.intern.edamammvvm.module.search.viewmodel.SearchViewModel;
import com.intern.edamammvvm.utils.Helper;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {
    SearchFragmentBinding binding;


    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding =  DataBindingUtil.inflate(inflater,R.layout.search_fragment, container, false);
       binding.setLifecycleOwner(getViewLifecycleOwner());
       binding.setViewModel(new ViewModelProvider(this).get(SearchViewModel.class));
       binding.btnSetting.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               SearchDialog dialog = SearchDialog.newInstance(binding.getViewModel().getSearchQuery().getValue());
               dialog.show(getActivity().getSupportFragmentManager(),"Dialog");
               if(dialog.getIsComplete()!=null) dialog.getIsComplete().observe(getViewLifecycleOwner(),aBoolean -> {
                   if(aBoolean) binding.getViewModel().setSearchQuery(dialog.getSearchQuery());
               });
           }
       });
       binding.editText.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               binding.getViewModel().getRecipeItem(binding.getViewModel().getTextField().get());
           }
       });
       init();
       return binding.getRoot();
    }

    private void init() {
        binding.getViewModel().getOnFailure().observe(getViewLifecycleOwner(),this::onFailure);
        binding.getViewModel().getOnSuccess().observe(getViewLifecycleOwner(),this::onSuccess);
        binding.getViewModel().getOnLoading().observe(getViewLifecycleOwner(),this::onLoading);
    }
    private void onLoading(Boolean bool){
        if(bool) getBaseActivity().showLoading();
        else getBaseActivity().hideLoading();
    }
    private void onSuccess(List<RecipeItem> items) {
        RecipeListAdapter recipeListAdapter = new RecipeListAdapter(items, (BaseActivity) getActivity());
        binding.recyclerView.setAdapter(recipeListAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
    }

    private void onFailure(Boolean aBoolean) {
        if(aBoolean){
            binding.getViewModel().getOnFailure().setValue(false);
            Toast.makeText(getActivity(),"Có lỗi xảy ra",Toast.LENGTH_LONG).show();
        }
    }
    public BaseActivity getBaseActivity(){
        return (BaseActivity) getActivity();
    }
}