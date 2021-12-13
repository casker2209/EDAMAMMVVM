package com.intern.edamammvvm.module.recipeitem.dialog.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.intern.edamammvvm.databinding.DialogSearchBinding;
import com.intern.edamammvvm.module.recipeitem.dialog.viewmodel.SearchDialogViewModel;
import com.intern.edamammvvm.module.recipeitem.view.RecipeInformation;
import com.intern.edamammvvm.module.recipeitem.view.RecipeIngredientFragment;
import com.intern.edamammvvm.module.search.model.SearchQuery;

import java.io.Serializable;

public class SearchDialog extends DialogFragment {
    private MutableLiveData<Boolean> isComplete;
    private SearchDialogViewModel viewModel;
    private DialogSearchBinding binding;
    private SearchQuery searchQuery;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogSearchBinding.inflate(inflater);
        binding.viewPager.setAdapter(new ViewPagerAdapter(this));
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(position==0 ? "Thông tin sức khỏe" : "Thông tin thức ăn");
            }
        }).attach();
        binding.setLifecycleOwner(this);
        viewModel = new SearchDialogViewModel(searchQuery);
        binding.setViewModel(viewModel);
        binding.complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isComplete.setValue(true);
                dismiss();
            }
        });
        return binding.getRoot();
    }

    public static SearchDialog newInstance(SearchQuery searchQuery) {

        Bundle args = new Bundle();

        SearchDialog fragment = new SearchDialog();
        args.putSerializable("query", (Serializable) searchQuery);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            searchQuery = (SearchQuery) getArguments().getSerializable("query");
        }
        isComplete = new MutableLiveData<>(false);
    }


    class ViewPagerAdapter extends FragmentStateAdapter {
        public ViewPagerAdapter(@NonNull Fragment fragment) {
            super(fragment);
        }
        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0:
                    return DialogCuisine.newInstance(viewModel);
                case 1:
                    return DialogHealth.newInstance(viewModel);
                default:
                    return null;
            }
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }

    public SearchQuery getSearchQuery() {
        return binding.getViewModel().getQuery();
    }

    public MutableLiveData<Boolean> getIsComplete() {
        return isComplete;
    }
}
