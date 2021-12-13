package com.intern.edamammvvm.module.recipeitem.dialog.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intern.edamammvvm.R;
import com.intern.edamammvvm.databinding.DialogCuisineBinding;
import com.intern.edamammvvm.module.recipeitem.dialog.viewmodel.SearchDialogViewModel;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DialogCuisine#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DialogCuisine extends Fragment {
    SearchDialogViewModel viewModel;

    public DialogCuisine() {
    }

    public static DialogCuisine newInstance(SearchDialogViewModel viewModel) {
        DialogCuisine fragment = new DialogCuisine();
        Bundle args = new Bundle();
        args.putSerializable("view model", (Serializable) viewModel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null) viewModel = (SearchDialogViewModel) getArguments().getSerializable("view model");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DialogCuisineBinding binding = DialogCuisineBinding.inflate(inflater);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }
}