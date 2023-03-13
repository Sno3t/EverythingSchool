package com.example.hellotoast;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.hellotoast.domain.Meal;

import java.util.List;

/**
 * Data Access Object (DAO) for a word.
 * Each method performs a database operation, such as inserting or deleting a word,
 * running a DB query, or deleting all words.
 */

@Dao
public interface MealDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Meal meal);

    @Query("DELETE FROM meal_table")
    void deleteAll();

    @Delete
    void deleteMeal(Meal meal);

    @Query("SELECT * from meal_table LIMIT 1")
    List<Meal> getAnyMeal();

    @Query("SELECT * from meal_table ORDER BY name ASC")
    LiveData<List<Meal>> getAllMeals();

    @Update
    void update(Meal... meals);
}
