package com.intern.edamammvvm.module.search.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.intern.edamammvvm.R;
import com.intern.edamammvvm.app.BaseActivity;
import com.intern.edamammvvm.databinding.RecipeItemBinding;
import com.intern.edamammvvm.module.recipeitem.view.RecipeFragment;
import com.intern.edamammvvm.module.search.model.RecipeItem;

import java.util.List;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.ViewHolder>{
    List<RecipeItem> itemList;
    BaseActivity context;
    public RecipeListAdapter(List<RecipeItem> itemList,BaseActivity context){
        this.itemList = itemList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecipeItemBinding binding = RecipeItemBinding.inflate(LayoutInflater.from(context),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecipeItem item = itemList.get(position);
        Glide.with(context).load(item.getImage()).
                centerCrop()
                .placeholder(context.getResources().getDrawable(R.drawable.ic_image_error)).
                centerCrop().into(holder.binding.recipeImage);
        holder.binding.recipeName.setText(item.getLabel());
        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container, RecipeFragment.newInstance(item)).commit();
                context.hideSoftKeyboard(context,v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        RecipeItemBinding binding;
        public ViewHolder(RecipeItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
