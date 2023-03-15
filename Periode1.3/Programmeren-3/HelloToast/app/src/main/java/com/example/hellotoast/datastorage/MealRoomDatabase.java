package com.example.hellotoast.datastorage;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.hellotoast.domain.Meal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * WordRoomDatabase. Includes code to create the database.
 * After the app creates the database, all further interactions
 * with it happen through the WordViewModel.
 */

//@Database(entities = {Meal.class}, version = 2, exportSchema = false)
@Database(entities = {Meal.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class MealRoomDatabase extends RoomDatabase {

    public abstract MealDao mealDao();

    private static MealRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static MealRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MealRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here.
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MealRoomDatabase.class, "meal_database")
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
    private static Callback sRoomDatabaseCallback =
            new Callback() {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    // new PopulateDbAsync(INSTANCE).execute();
                }
            };
}