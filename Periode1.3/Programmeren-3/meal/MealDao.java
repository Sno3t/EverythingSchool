package com.android.example.roomwordssample.meal;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Meal meal);

    @Delete
    void delete(Meal meal);

    @Query("SELECT * FROM meal_table ORDER BY mId ASC")
    List<Meal> getAllMeals();

    @Query("SELECT * FROM meal_table WHERE mId = :id")
    Meal getMealById(int id);

    @Query("DELETE FROM meal_table")
    void deleteAllMeals();
}
