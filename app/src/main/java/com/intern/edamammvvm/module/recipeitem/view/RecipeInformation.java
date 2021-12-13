package com.intern.edamammvvm.module.recipeitem.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intern.edamammvvm.R;
import com.intern.edamammvvm.databinding.RecipeInformationFragmentBinding;
import com.intern.edamammvvm.databinding.RecipeIngredientFragmentBinding;
import com.intern.edamammvvm.module.recipeitem.viewmodel.RecipeViewModel;
import com.intern.edamammvvm.module.recipeitem.viewmodel.RecipeViewModelFactory;
import com.intern.edamammvvm.module.search.model.RecipeItem;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipeInformation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipeInformation extends Fragment {


    public RecipeInformation() {
    }


    // TODO: Rename and change types and number of parameters
    public static RecipeInformation newInstance(RecipeItem recipeItem) {
        RecipeInformation fragment = new RecipeInformation();
        Bundle args = new Bundle();
        args.putSerializable("param",recipeItem);
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
        // Inflate the layout for this fragment
        RecipeInformationFragmentBinding binding = RecipeInformationFragmentBinding.inflate(inflater,container,false);
        RecipeViewModel viewModel = new ViewModelProvider(this,new RecipeViewModelFactory(this.getActivity().getApplication()
                , (RecipeItem) getArguments().getSerializable("param"))).get(RecipeViewModel.class);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }
}