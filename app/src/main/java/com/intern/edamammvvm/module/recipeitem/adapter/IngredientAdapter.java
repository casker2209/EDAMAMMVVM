package com.intern.edamammvvm.module.recipeitem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.intern.edamammvvm.databinding.ItemIngredientBinding;
import com.intern.edamammvvm.databinding.RecipeIngredientFragmentBinding;
import com.intern.edamammvvm.module.recipeitem.viewmodel.IngredientViewModel;
import com.intern.edamammvvm.module.search.model.Ingredient;
import com.intern.edamammvvm.module.search.model.RecipeItem;

import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.ViewHolder> {
    List<Ingredient> ingredientList;
    Context context;

    public IngredientAdapter(RecipeItem item, Context context) {
        this.ingredientList = item.getIngredientList();
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemIngredientBinding binding = ItemIngredientBinding
                .inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Ingredient ingredient = ingredientList.get(position);

        IngredientViewModel viewModel = new IngredientViewModel();
        holder.binding.setViewModel(viewModel);
        viewModel.setIngredient(ingredient);
    }

    @Override
    public int getItemCount() {
        return ingredientList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemIngredientBinding binding;
        public ViewHolder(@NonNull ItemIngredientBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
