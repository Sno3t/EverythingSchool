package com.android.example.roomwordssample.meal;/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

/**
 * MealRoomDatabase. Includes code to create the database.
 * After the app creates the database, all further interactions
 * with it happen through the MealViewModel.
 */

@Database(entities = {Meal.class}, version = 2, exportSchema = false)
public abstract class MealRoomDatabase extends RoomDatabase {

    public abstract MealDao MealDao();

    private static MealRoomDatabase INSTANCE;

    public static MealRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MealRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here.
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MealRoomDatabase.class, "Meal_database")
                            // Wipes and rebuilds instead of migrating if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    // This callback is called when the database has opened.
    // In this case, use PopulateDbAsync to populate the database
    // with the initial data set if the database has no entries.
    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    // Populate the database with the initial data set
    // only if the database has no entries.
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final MealDao mDao;

        // Initial data set
        private static String [] Meals = {"dolphin", "crocodile", "cobra", "elephant", "goldfish",
                "tiger", "snake"};

        PopulateDbAsync(MealRoomDatabase db) {
            mDao = db.MealDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // If we have no Meals, then create the initial list of Meals.
            if (mDao.getAnyMeal().length < 1) {
                for (int i = 0; i <= Meals.length - 1; i++) {
                    Meal Meal = new Meal(); //Meals[i]
                    mDao.insert(Meal);
                }
            }
            return null;
        }
    }
}

