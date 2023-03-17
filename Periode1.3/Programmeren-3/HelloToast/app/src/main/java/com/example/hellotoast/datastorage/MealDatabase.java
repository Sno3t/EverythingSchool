package com.example.hellotoast.datastorage;

import android.content.Context;
import android.os.AsyncTask;

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
@Database(entities = {Meal.class}, version = 2)
@TypeConverters({Converters.class})
public abstract class MealDatabase extends RoomDatabase {

    public abstract MealDao mealDao();

    private static MealDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

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

    // This callback is called when the database has opened.
    // In this case, use PopulateDbAsync to populate the database
    // with the initial data set if the database has no entries.
    private static RoomDatabase.Callback RoomDatabaseCallback =
            new Callback() {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                     new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final MealDao mMealDao;

        // Constructor
        public PopulateDbAsync(MealDatabase db) {
            mMealDao = db.mealDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Check if database is empty
            if (mMealDao.getAnyMeal().size() == 0) {
                // If so, populate it with initial data set
                mMealDao.insert(new Meal(new Meal.Builder("Lasagne", "Italian pasta dish made with layers of cheese and tomato sauce", 8.5)));
                mMealDao.insert(new Meal(new Meal.Builder("Burger", "Sandwich consisting of one or more cooked patties of ground meat, usually beef", 6.5)));
                mMealDao.insert(new Meal(new Meal.Builder("Sushi", "Japanese dish made with vinegared rice and various fillings", 12.0)));
                mMealDao.insert(new Meal(new Meal.Builder("Pizza", "Flatbread topped with tomato sauce, cheese, and various toppings", 10.0)));
            }
            return null;
        }
    }

}