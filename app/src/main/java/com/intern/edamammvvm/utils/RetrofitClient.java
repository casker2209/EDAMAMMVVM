package com.intern.edamammvvm.utils;

import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RecipeAPI recipeAPI;
    public static RecipeAPI getRecipeAPI(){
        if(recipeAPI != null) return recipeAPI;
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);
        builder.addInterceptor(chain -> {
            Request original = chain.request();
            HttpUrl url = original.url().newBuilder().addQueryParameter("app_id",Constants.APP_ID)
                    .addQueryParameter("app_key",Constants.APP_KEY)
                    .addQueryParameter("type",Constants.string_public)
                    .build();
            Request request = original.newBuilder()
                    .url(url)
                    .build();

            return chain.proceed(request);
        });

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = builder
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(recipeAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.computation()))
                .client(okHttpClient)
                .build();
        recipeAPI = retrofit.create(RecipeAPI.class);
        return recipeAPI;
    }
}
