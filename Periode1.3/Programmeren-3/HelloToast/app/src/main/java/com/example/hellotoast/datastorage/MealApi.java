package com.example.hellotoast.datastorage;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MealApi {
    @GET("api/meal")
    Call<JsonObject> getMeals();
//        Call<List<Meal>> getMeals();
}
