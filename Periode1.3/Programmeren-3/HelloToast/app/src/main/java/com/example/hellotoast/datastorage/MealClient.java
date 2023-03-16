package com.example.hellotoast.datastorage;

import android.util.Log;

import com.example.hellotoast.domain.Meal;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MealClient {

    private static Retrofit retrofit = null;
    private final static String TAG = "MealClient";

    public static Retrofit getClient() {
        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://shareameal-api.herokuapp.com/api/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


        return retrofit;
    }

    public interface MealApi {
        @GET("meal")
        Call<List<Meal>> getMeals();
    }

}
