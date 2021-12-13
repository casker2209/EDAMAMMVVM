package com.intern.edamammvvm.module.recipeitem.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.intern.edamammvvm.R;
import com.intern.edamammvvm.common.WebFragment;
import com.intern.edamammvvm.databinding.RecipeFragmentBinding;
import com.intern.edamammvvm.module.recipeitem.viewmodel.RecipeViewModel;
import com.intern.edamammvvm.module.recipeitem.viewmodel.RecipeViewModelFactory;
import com.intern.edamammvvm.module.search.model.RecipeItem;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipeFragment extends Fragment {
    private RecipeItem recipeItem;
    public RecipeFragment() {
    }

    public static RecipeFragment newInstance(RecipeItem recipeItem) {
        RecipeFragment fragment = new RecipeFragment();
        Bundle args = new Bundle();
        args.putSerializable("param",recipeItem);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null)
            recipeItem = (RecipeItem) getArguments().getSerializable("param");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecipeFragmentBinding binding = RecipeFragmentBinding.inflate(inflater,container,false);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        Log.d("TAG",recipeItem.getLabel());
        RecipeViewModel viewModel = new ViewModelProvider(this,new RecipeViewModelFactory(this.getActivity().getApplication()
                , (RecipeItem) getArguments().getSerializable("param"))).get(RecipeViewModel.class);
        Log.d("TAG TWO",viewModel.getRecipeItem().getValue().getLabel());
        binding.setViewModel(viewModel);
        binding.viewPager.setAdapter(new ViewPagerAdapter(this));
        binding.recipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, WebFragment.newInstance(recipeItem.getWebUrl()))
                        .addToBackStack(null).commit();
            }
        });
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(position==0 ? "Thông tin" : "Nguyên liệu");
            }
        }).attach();
        return binding.getRoot();
    }

    class ViewPagerAdapter extends FragmentStateAdapter{
        public ViewPagerAdapter(@NonNull Fragment fragment) {
            super(fragment);
        }
        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0:
                    return RecipeInformation.newInstance(recipeItem);
                case 1:
                    return RecipeIngredientFragment.newInstance(recipeItem);
                default:
                    return null;
            }
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }
}
