package com.example.shareameal.presentation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.shareameal.datastorage.MealRepository;
import com.example.shareameal.domain.Meal;

import java.util.List;

public class MealViewModel extends AndroidViewModel {

    private MealRepository mealRepository;
    private LiveData<List<Meal>> allMeals;

    public MealViewModel(@NonNull Application application) {
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

    public void insert(Meal meal) {
        mealRepository.insert(meal);
    }

    public void deleteAllMeals() {
        mealRepository.deleteAllMeals();
    }

    public void deleteMeal(Meal meal) {
        mealRepository.deleteMeal(meal);
    }

    public void update(Meal meal) {
        mealRepository.update(meal);
    }

    public void insertMeals() {
        mealRepository.insertMeals();
    }
}
