package com.example.hellotoast;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.hellotoast.domain.Meal;

import java.util.List;

/**
 * The MealViewModel provides the interface between the UI and the data layer of the app,
 * represented by the Repository
 */

public class MealViewModel extends AndroidViewModel {

    private MealRepository mRepository;

    private LiveData<List<Meal>> mAllMeals;

    public MealViewModel(Application application) {
        super(application);
        mRepository = new MealRepository(application);
        mAllMeals = mRepository.getAllMeals();
    }

    LiveData<List<Meal>> getAllMeals() {
        return mAllMeals;
    }

    public void insert(Meal meal) {
        mRepository.insert(meal);
    }

    public void deleteAll() {
        mRepository.deleteAll();
    }

    public void deleteMeal(Meal meal) {
        mRepository.deleteMeal(meal);
    }

    public void update(Meal meal) {
        mRepository.update(meal);
    }
}

