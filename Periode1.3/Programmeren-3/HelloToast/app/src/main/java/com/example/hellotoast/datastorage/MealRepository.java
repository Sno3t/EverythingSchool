package com.example.hellotoast.datastorage;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.hellotoast.domain.Meal;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MealRepository {


    private MealDao mealDao;
    private MealApi mealApiService;

    private LiveData<List<Meal>> allMeals;

    private final static String TAG = "MealRepository";

    public MealRepository(Application application) {
        MealDatabase db = MealDatabase.getInstance(application);
        mealDao = db.mealDao();
        mealApiService = MealClient.getClient().create(MealApi.class);
        allMeals = mealDao.getAllMeals();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://shareameal-api.herokuapp.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        mealApiService  = retrofit.create(MealApi.class);
    }



    public void insertMeals() {
        Call<JsonObject> callJson = mealApiService.getMeals();
        Log.d(TAG, "insertMeals called");
        callJson.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();
                    JsonArray jsonArray = jsonObject.getAsJsonArray("result");
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<Meal>>() {
                    }.getType();
                    List<Meal> mealList = gson.fromJson(jsonArray, type);
                    mealDao.insertAllBackground(mealList);
                }
            }
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d(TAG, "insertMeals failure");
            }
        });
    }



    public LiveData<List<Meal>> getAllMeals() {
//        refreshMeals();
        return mealDao.getAllMeals();

    }

    public void insertAll(List<Meal> meals) {
        new InsertAllAsyncTask(mealDao).execute(meals);
    }

    public void insert(Meal meal) {
        new insertMealAsyncTask(mealDao).execute(meal);
    }

    public void update(Meal meal) {
        new updateMealAsyncTask(mealDao).execute(meal);
    }

    public void deleteAllMeals() {
        new deleteAllMealsAsyncTask(mealDao).execute();
    }

    public void deleteMeal(Meal meal) {
        new deleteMealAsyncTask(mealDao).execute(meal);
    }

    private static class InsertAllAsyncTask extends AsyncTask<List<Meal>, Void, Void> {
        private MealDao mealDao;

        public InsertAllAsyncTask(MealDao mealDao) {
            this.mealDao = mealDao;
        }

        @Override
        protected Void doInBackground(List<Meal>... lists) {
            mealDao.insertAll(lists[0]);
            return null;
        }
    }

    private static class insertMealAsyncTask extends AsyncTask<Meal, Void, Void> {

        private MealDao mealDao;

        private insertMealAsyncTask(MealDao mealDao) {
            this.mealDao = mealDao;
        }

        @Override
        protected Void doInBackground(Meal... meals) {
            mealDao.insert(meals[0]);
            return null;
        }
    }

    private static class updateMealAsyncTask extends AsyncTask<Meal, Void, Void> {

        private MealDao mealDao;

        private updateMealAsyncTask(MealDao mealDao) {
            this.mealDao = mealDao;
        }

        @Override
        protected Void doInBackground(Meal... meals) {
            mealDao.update(meals[0]);
            return null;
        }
    }

    private static class deleteAllMealsAsyncTask extends AsyncTask<Void, Void, Void> {

        private MealDao mealDao;

        private deleteAllMealsAsyncTask(MealDao mealDao) {
            this.mealDao = mealDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mealDao.deleteAllMeals();
            return null;
        }
    }

    private static class deleteMealAsyncTask extends AsyncTask<Meal, Void, Void> {

        private MealDao mealDao;

        private deleteMealAsyncTask(MealDao mealDao) {
            this.mealDao = mealDao;
        }

        @Override
        protected Void doInBackground(Meal... meals) {
            mealDao.deleteMeal(meals[0]);
            return null;
        }
    }
}
