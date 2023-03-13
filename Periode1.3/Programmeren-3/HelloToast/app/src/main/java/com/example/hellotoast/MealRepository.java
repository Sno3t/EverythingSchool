package com.example.hellotoast;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.hellotoast.domain.Meal;

import java.util.ArrayList;
import java.util.List;

public class MealRepository
        implements RandomMealTask.RandomMealListenener {

    private MealDao mMealDao;
    private LiveData<List<Meal>> mAllMeals;

    private String randomUserUrl = "https://randomuser.me/api?results=50";

    private static final String TAG = MealRepository.class.getSimpleName();

    MealRepository(Application application) {
        MealRoomDatabase db = MealRoomDatabase.getDatabase(application);
        mMealDao = db.mealDao();
        mAllMeals = mMealDao.getAllMeals();

//        ConnectivityManager connMgr = (ConnectivityManager)
//                 application.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo =
//                connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//        boolean isWifiConn = networkInfo.isConnected();
//        networkInfo =
//                connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//        boolean isMobileConn = networkInfo.isConnected();
//        Log.d(TAG, "Wifi connected: " + isWifiConn);
//        Log.d(TAG, "Mobile connected: " + isMobileConn);

        // Twee mogelijkheden:
        if(true){
            // 1. We hebben connectie en kunnen een request naar de API sturen
            // We schrijven de meals weg in de database.
            RandomMealTask randomMealTask = new RandomMealTask(this);
            randomMealTask.execute(randomUserUrl);
        } else {
            // of 2. Er is geen Wifi, dus we halen de meals uit de database.
            mMealDao.getAllMeals();
        }
    }

    @Override
    public void onMealsAvailable(ArrayList<Meal> meals) {
        // Meals via de API ontvangen; zet deze in de LiveData.
        Log.d(TAG, "onMealsAvailable - we hebben " + meals.size() + " meals");
        // mAllMeals.setValue(meals); // gevolg: mAllMeals.onChanged
        for(int i = 0; i < meals.size(); i++) {
            insert(meals.get(i));
        }
    }

    LiveData<List<Meal>> getAllMeals() {
        return mAllMeals;
    }

    public void insert(Meal meal) {
        new insertAsyncTask(mMealDao).execute(meal);
    }

    public void update(Meal meal)  {
        new updateMealAsyncTask(mMealDao).execute(meal);
    }

    public void deleteAll()  {
        new deleteAllMealsAsyncTask(mMealDao).execute();
    }

    // Must run off main thread
    public void deleteMeal(Meal meal) {
        new deleteMealAsyncTask(mMealDao).execute(meal);
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
     *  Deletes a single meal from the database.
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
     *  Updates a meal in the database.
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
