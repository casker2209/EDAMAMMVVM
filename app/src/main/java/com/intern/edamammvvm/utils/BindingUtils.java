package com.intern.edamammvvm.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.intern.edamammvvm.R;
import com.intern.edamammvvm.module.recipeitem.adapter.InformationAdapter;
import com.intern.edamammvvm.module.recipeitem.adapter.IngredientAdapter;
import com.intern.edamammvvm.module.search.model.Ingredient;
import com.intern.edamammvvm.module.search.model.RecipeItem;

import java.util.List;

public class BindingUtils {
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view,String url){
        if(url!=null){
            if(!url.isEmpty())
                Glide.with(view.getContext()).load(url).placeholder(R.drawable.ic_image_error).centerCrop().into(view);
        }
    }
    @BindingAdapter("recyclerListString")
    public static void loadListString(RecyclerView recyclerView, List<String> list){
        InformationAdapter adapter = new InformationAdapter(list,recyclerView.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
    }
    @BindingAdapter("recyclerListIngredient")
    public static void loadListIngredient(RecyclerView recyclerView, RecipeItem recipeItem){
        IngredientAdapter adapter = new IngredientAdapter(recipeItem,recyclerView.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
    }

}
