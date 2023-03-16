package com.example.hellotoast.datastorage;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.hellotoast.domain.Meal;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealRepository {


    private MealDao mealDao;
    private MealClient.MealApi mealApiService;
    private LiveData<List<Meal>> allMeals;

    private final static String TAG = "MealRepository";

    public MealRepository(Application application) {
        MealDatabase db = MealDatabase.getInstance(application);
        mealDao = db.mealDao();
        mealApiService = MealClient.getClient().create(MealClient.MealApi.class);
        allMeals = mealDao.getAllMeals();
    }


    public LiveData<List<Meal>> getAllMeals() {
        refreshMeals();
        return allMeals;
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


    private void refreshMeals() {
        Log.d(TAG,  "aaaaaa");
        mealApiService.getMeals().enqueue(new Callback<List<Meal>>() {
            @Override
            public void onResponse(Call<List<Meal>> call, Response<List<Meal>> response) {

                if (response.isSuccessful()) {
                    MealDatabase.databaseWriteExecutor.execute(() -> {
                        mealDao.deleteAllMeals();
                        mealDao.insertAll(response.body());
                    });
                }
            }

            @Override
            public void onFailure(Call<List<Meal>> call, Throwable t) {
                Log.d(TAG, t.getLocalizedMessage());


            }
        });
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
