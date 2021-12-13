package com.intern.edamammvvm.app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.intern.edamammvvm.R;
import com.intern.edamammvvm.databinding.BaseactivityBinding;
import com.intern.edamammvvm.module.search.view.SearchFragment;
import com.intern.edamammvvm.utils.Helper;

public class BaseActivity extends AppCompatActivity {
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseactivityBinding binding = BaseactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setLifecycleOwner(this);
        int count = getSupportFragmentManager().getBackStackEntryCount();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, SearchFragment.newInstance())
                .addToBackStack(String.valueOf(count))
                .commit();
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()>1) super.onBackPressed();
        else this.finishAffinity();
    }

    public static void hideSoftKeyboard(AppCompatActivity activity, View root) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                root.getWindowToken(), 0);
    }
    public void showLoading() {
        hideLoading();
        mProgressDialog = Helper.showLoadingDialog(this);
    }

    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }
}