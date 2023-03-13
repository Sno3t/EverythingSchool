package com.example.hellotoast.datastorage;

import com.example.android.roomwordssample.domain.LoginData;
import com.example.android.roomwordssample.domain.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ShareAMealApiService {

    @GET("api/meal")
    Call<LoginResponse> login(@Body() LoginData loginData);

//    @POST("api/auth/login")
//    Call<LoginResponse> login(@Body() LoginData loginData);
//
//    @GET("api/user/profile")
//    Call<LoginResponse> getUserProfile(@Header("Authorization") String token);

}
