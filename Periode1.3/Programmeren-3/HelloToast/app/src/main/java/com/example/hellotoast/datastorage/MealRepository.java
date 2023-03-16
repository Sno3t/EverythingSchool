package com.example.hellotoast.datastorage;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.hellotoast.domain.Meal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealRepository {


    private MealDao mealDao;
    private MealClient.MealApi mealApiService;
    private LiveData<List<Meal>> allMeals;

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

//    public void insertAll(List<Meal> meals) {
//        MealDatabase.databaseWriteExecutor.execute(() -> {
//            mealDao.insertAll(meals);
//        });
//    }

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
                // Do nothing - use cached data
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

    private static class insertMealAsyncTask extends AsyncTask<Meal, Void, Void>{

        private MealDao mealDao;
        private  insertMealAsyncTask(MealDao mealDao){
            this.mealDao = mealDao;
        }

        @Override
        protected Void doInBackground(Meal... meals) {
            mealDao.insert(meals[0]);
            return null;
        }
    }

    private static class updateMealAsyncTask extends AsyncTask<Meal, Void, Void>{

        private MealDao mealDao;
        private  updateMealAsyncTask(MealDao mealDao){
            this.mealDao = mealDao;
        }

        @Override
        protected Void doInBackground(Meal... meals) {
            mealDao.update(meals[0]);
            return null;
        }
    }

    private static class deleteAllMealsAsyncTask extends AsyncTask<Void, Void, Void>{

        private MealDao mealDao;
        private  deleteAllMealsAsyncTask(MealDao mealDao){
            this.mealDao = mealDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mealDao.deleteAllMeals();
            return null;
        }
    }

    private static class deleteMealAsyncTask extends AsyncTask<Meal, Void, Void>{

        private MealDao mealDao;
        private  deleteMealAsyncTask(MealDao mealDao){
            this.mealDao = mealDao;
        }

        @Override
        protected Void doInBackground(Meal... meals) {
            mealDao.deleteMeal(meals[0]);
            return null;
        }
    }
}




//    private MealClient.MealApi mealApi;
//    private MealDao mealDao;
//    private LiveData<List<Meal>> mealsLiveData;
//
//    public MealRepository(Application application) {
//        mealApi = MealClient.getClient().create(MealClient.MealApi.class);
//        MealRoomDatabase MealRoomDatabase = MealRoomDatabase.getDatabase(application);
//        mealDao = MealRoomDatabase.mealDao();
//        mealsLiveData = mealDao.getAllMeals();
//        refreshMeals();
//    }
//
//    public LiveData<List<Meal>> getMeals() {
//        return mealsLiveData;
//    }
//
//    public void refreshMeals() {
//        Call<List<Meal>> call = mealApi.getMeals();
//
//        call.enqueue(new Callback<List<Meal>>() {
//            @Override
//            public void onResponse(Call<List<Meal>> call, Response<List<Meal>> response) {
//                if (response.isSuccessful()) {
//                    List<Meal> meals = response.body();
//                    MealRoomDatabase.databaseWriteExecutor.execute(() -> {
//                        mealDao.deleteAll();
//                        mealDao.insertAll(meals);
//                    });
//                } else {
//                    // Handle error
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Meal>> call, Throwable t) {
//                // Handle error
//            }
//        });
//    }
//}



//import android.app.Application;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import androidx.lifecycle.LiveData;
//import androidx.lifecycle.MutableLiveData;
//
//import com.example.hellotoast.presentation.RandomMealTask;
//import com.example.hellotoast.domain.Meal;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MealRepository
//        implements RandomMealTask.RandomMealListenener {
//
//    private MealDao mMealDao;
////    private LiveData<List<Meal>> mAllMeals;
////    private String mealUrl = "http://shareameal-api.herokuapp.com/api/meal";
//
//    private MealClient.MealApi mealApi;
//    private MutableLiveData<List<Meal>> mealsLiveData;
//
//    private static final String TAG = MealRepository.class.getSimpleName();
//
//    public MealRepository(Application application) {
//        MealRoomDatabase db = MealRoomDatabase.getDatabase(application);
//        mMealDao = db.mealDao();
//        mAllMeals = mMealDao.getAllMeals();
//
////        ConnectivityManager connMgr = (ConnectivityManager)
////                 application.getSystemService(Context.CONNECTIVITY_SERVICE);
////        NetworkInfo networkInfo =
////                connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
////        boolean isWifiConn = networkInfo.isConnected();
////        networkInfo =
////                connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
////        boolean isMobileConn = networkInfo.isConnected();
////        Log.d(TAG, "Wifi connected: " + isWifiConn);
////        Log.d(TAG, "Mobile connected: " + isMobileConn);
//
//        // Twee mogelijkheden:
//        if (true) {
//            // 1. We hebben connectie en kunnen een request naar de API sturen
//            // We schrijven de meals weg in de database.
//            RandomMealTask randomMealTask = new RandomMealTask(this);
//            randomMealTask.execute(mealUrl);
//        } else {
//            // of 2. Er is geen Wifi, dus we halen de meals uit de database.
//            mMealDao.getAllMeals();
//        }
//    }
//
//    @Override
//    public void onMealsAvailable(ArrayList<Meal> meals) {
//        // Meals via de API ontvangen; zet deze in de LiveData.
//        Log.d(TAG, "onMealsAvailable - we hebben " + meals.size() + " meals");
//        // mAllMeals.setValue(meals); // gevolg: mAllMeals.onChanged
//        for (int i = 0; i < meals.size(); i++) {
//            insert(meals.get(i));
//        }
//    }
//
//    public LiveData<List<Meal>> getAllMeals() {
//        return mAllMeals;
//    }
//
//    public void insert(Meal meal) {
//        new insertAsyncTask(mMealDao).execute(meal);
//    }
//
//    public void update(Meal meal) {
//        new updateMealAsyncTask(mMealDao).execute(meal);
//    }
//
//    public void deleteAll() {
//        new deleteAllMealsAsyncTask(mMealDao).execute();
//    }
//
//    // Must run off main thread
//    public void deleteMeal(Meal meal) {
//        new deleteMealAsyncTask(mMealDao).execute(meal);
//    }
//
//    // Static inner classes below here to run database interactions in the background.
//
//    /**
//     * Inserts a meal into the database.
//     */
//    private static class insertAsyncTask extends AsyncTask<Meal, Void, Void> {
//
//        private MealDao mAsyncTaskDao;
//
//        insertAsyncTask(MealDao dao) {
//            mAsyncTaskDao = dao;
//        }
//
//        @Override
//        protected Void doInBackground(final Meal... params) {
//            mAsyncTaskDao.insert(params[0]);
//            return null;
//        }
//    }
//
//    /**
//     * Deletes all meals from the database (does not delete the table).
//     */
//    private static class deleteAllMealsAsyncTask extends AsyncTask<Void, Void, Void> {
//        private MealDao mAsyncTaskDao;
//
//        deleteAllMealsAsyncTask(MealDao dao) {
//            mAsyncTaskDao = dao;
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            mAsyncTaskDao.deleteAll();
//            return null;
//        }
//    }
//
//    /**
//     * Deletes a single meal from the database.
//     */
//    private static class deleteMealAsyncTask extends AsyncTask<Meal, Void, Void> {
//        private MealDao mAsyncTaskDao;
//
//        deleteMealAsyncTask(MealDao dao) {
//            mAsyncTaskDao = dao;
//        }
//
//        @Override
//        protected Void doInBackground(final Meal... params) {
//            mAsyncTaskDao.deleteMeal(params[0]);
//            return null;
//        }
//    }
//
//    /**
//     * Updates a meal in the database.
//     */
//    private static class updateMealAsyncTask extends AsyncTask<Meal, Void, Void> {
//        private MealDao mAsyncTaskDao;
//
//        updateMealAsyncTask(MealDao dao) {
//            mAsyncTaskDao = dao;
//        }
//
//        @Override
//        protected Void doInBackground(final Meal... params) {
//            mAsyncTaskDao.update(params[0]);
//            return null;
//        }
//    }
//}
