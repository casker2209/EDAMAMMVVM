package com.intern.edamammvvm.module.recipeitem.dialog.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intern.edamammvvm.R;
import com.intern.edamammvvm.databinding.DialogCuisineBinding;
import com.intern.edamammvvm.databinding.DialogHealthBinding;
import com.intern.edamammvvm.module.recipeitem.dialog.viewmodel.SearchDialogViewModel;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DialogHealth#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DialogHealth extends Fragment {
    SearchDialogViewModel viewModel;
    public DialogHealth() {
    }


    public static DialogHealth newInstance(SearchDialogViewModel viewModel) {
        DialogHealth fragment = new DialogHealth();
        Bundle args = new Bundle();
        args.putSerializable("view model", (Serializable) viewModel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        if(getArguments()!=null) viewModel = (SearchDialogViewModel) getArguments().getSerializable("view model");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        DialogHealthBinding binding = DialogHealthBinding.inflate(inflater);
        binding.setViewModel(viewModel);
        return binding.getRoot();    }
}