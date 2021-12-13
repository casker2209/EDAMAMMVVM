package com.intern.edamammvvm.module.recipeitem.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.intern.edamammvvm.databinding.ItemInformationBinding;

import java.util.List;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.ViewHolder>  {
    List<String> list;
    Context context;

    public InformationAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemInformationBinding binding = ItemInformationBinding.inflate(LayoutInflater.from(context),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.text.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemInformationBinding binding;
        public ViewHolder(@NonNull ItemInformationBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
