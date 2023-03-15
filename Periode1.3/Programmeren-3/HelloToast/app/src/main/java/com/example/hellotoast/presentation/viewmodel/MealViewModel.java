package com.example.hellotoast.presentation.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.hellotoast.datastorage.MealDao;
import com.example.hellotoast.datastorage.MealRepository;
import com.example.hellotoast.domain.Meal;

import java.util.List;

/**
 * The MealViewModel provides the interface between the UI and the data layer of the app,
 * represented by the Repository
 */

public class MealViewModel extends AndroidViewModel {

    private MealRepository mealRepository;
    private LiveData<List<Meal>> allMeals;

    public MealViewModel(Application application) {
        super(application);
        mealRepository = new MealRepository(application);
        allMeals = mealRepository.getAllMeals();
    }

    public LiveData<List<Meal>> getAllMeals() {
        return allMeals;
    }

    public void insertAll(List<Meal> meals) {
        mealRepository.insertAll(meals);
    }



//    private MealRepository mealRepository;
//    private LiveData<List<Meal>> allMeals;
//
//    public MealViewModel(Application application) {
//        super(application);
//        mealRepository = new MealRepository(application);
//        allMeals = mealRepository.getAllMeals();
//    }
//
//    public LiveData<List<Meal>> getAllMeals() {
//        return allMeals;
//    }
//
//    public void insertAll(List<Meal> meals) {
//        mealRepository.insertAll(meals);
//    }
//

    ////////////////////////--------------------------

//    private MealRepository mRepository;
//    private MealDao mealDao;
//
//    private LiveData<List<Meal>> mAllMeals;
//
//    public MealViewModel(Application application) {
//        super(application);
//        mRepository = new MealRepository(application);
//        mAllMeals = mRepository.getMeals();
//    }
//
//    public LiveData<List<Meal>> getAllMeals() {
//        return mAllMeals;
//    }
//
//    public void insert(Meal meal) {
//        mealDao.insert(meal);
//    }
//
//    public void deleteAll() {
//        mealDao.deleteAll();
//    }
//
//    public void deleteMeal(Meal meal) {
//        mealDao.deleteMeal(meal);
//    }
//
//    public void update(Meal meal) {
//        mealDao.update(meal);
//    }
}

