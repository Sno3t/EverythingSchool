package com.example.shareameal.datastorage;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.shareameal.domain.Meal;

@Database(entities = {Meal.class}, version = 2)
@TypeConverters({Converters.class})
public abstract class MealDatabase extends RoomDatabase {

    public abstract MealDao mealDao();

    private static MealDatabase INSTANCE;

    public static MealDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (MealDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here.
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MealDatabase.class, "meal_database")
                            // Wipes and rebuilds instead of migrating if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
//                            .addCallback(RoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
