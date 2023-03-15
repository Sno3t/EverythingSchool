package com.example.hellotoast.datastorage;

//import com.example.android.roomwordssample.domain.LoginData;
//import com.example.android.roomwordssample.domain.LoginResponse;
import com.example.hellotoast.domain.Meal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ShareAMealApiService {


    @GET("api/meal")
    Call<List<Meal>> getMeals();


//    @POST("api/auth/login")
//    Call<LoginResponse> login(@Body() LoginData loginData);
//
//    @GET("api/user/profile")
//    Call<LoginResponse> getUserProfile(@Header("Authorization") String token);

}
