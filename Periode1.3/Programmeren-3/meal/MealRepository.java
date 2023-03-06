package com.android.example.roommealssample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class MealRepository {

    private MealDao mMealDao;
    private LiveData<List<Meal>> mAllMeals;

    MealRepository(Application application) {
        MealRoomDatabase db = MealRoomDatabase.getDatabase(application);
        mMealDao = db.mealDao();
        mAllMeals = mMealDao.getAllMeals();
    }

    LiveData<List<Meal>> getAllMeals() {
        return mAllMeals;
    }

    public void insert(Meal meal) {
        new com.android.example.roommealssample.MealRepository.insertAsyncTask(mMealDao).execute(meal);
    }

    public void update(Meal meal) {
        new com.android.example.roommealssample.MealRepository.updateMealAsyncTask(mMealDao).execute(meal);
    }

    public void deleteAll() {
        new com.android.example.roommealssample.MealRepository.deleteAllMealsAsyncTask(mMealDao).execute();
    }

    // Must run off main thread
    public void deleteMeal(Meal meal) {
        new com.android.example.roommealssample.MealRepository.deleteMealAsyncTask(mMealDao).execute(meal);
    }

    // Static inner classes below here to run database interactions in the background.

    /**
     * Inserts a meal into the database.
     */
    private static class insertAsyncTask extends AsyncTask<Meal, Void, Void> {

        private MealDao mAsyncTaskDao;

        insertAsyncTask(MealDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Meal... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    /**
     * Deletes all meals from the database (does not delete the table).
     */
    private static class deleteAllMealsAsyncTask extends AsyncTask<Void, Void, Void> {
        private MealDao mAsyncTaskDao;

        deleteAllMealsAsyncTask(MealDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }

    /**
     * Deletes a single meal from the database.
     */
    private static class deleteMealAsyncTask extends AsyncTask<Meal, Void, Void> {
        private MealDao mAsyncTaskDao;

        deleteMealAsyncTask(MealDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Meal... params) {
            mAsyncTaskDao.deleteMeal(params[0]);
            return null;
        }
    }

    /**
     * Updates a meal in the database.
     */
    private static class updateMealAsyncTask extends AsyncTask<Meal, Void, Void> {
        private MealDao mAsyncTaskDao;

        updateMealAsyncTask(MealDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Meal... params) {
            mAsyncTaskDao.update(params[0]);
            return null;
        }
    }
}
