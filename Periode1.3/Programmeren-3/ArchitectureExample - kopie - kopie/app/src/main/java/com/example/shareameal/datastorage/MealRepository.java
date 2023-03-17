package com.example.shareameal.datastorage;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.shareameal.domain.Meal;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealRepository {

    private MealClient.MealApi mealApi;
    private MealDao mealDao;
    private LiveData<List<Meal>> allMeals;
    private final static String TAG = "MealRepository";

    public MealRepository(Application application) {
        // MealDatabase
        MealDatabase database = MealDatabase.getInstance(application);
        mealDao = database.mealDao();
        // Set all meals
        allMeals = mealDao.getAllMeals();
        mealApi = MealClient.getClient().create(MealClient.MealApi.class);

    }

    public void insertMeals() {
        Call<JsonObject> callJson = mealApi.getMeals();
        Log.d(TAG, "insertMeals called");
        callJson.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();
                    JsonArray jsonArray = jsonObject.getAsJsonArray("result");
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<Meal>>() {}.getType();
                    List<Meal> mealList = gson.fromJson(jsonArray, type);
                    mealDao.insertAllBackground(mealList);
                }
            }
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d(TAG, "insertMeals failure");
                Log.d(TAG, t.getMessage());
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
