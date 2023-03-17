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

// private static RoomDatabase.Callback RoomDatabaseCallback =
//            new Callback() {
//                @Override
//                public void onOpen(@NonNull SupportSQLiteDatabase db) {
//                    super.onOpen(db);
//                     new PopulateDbAsync(INSTANCE).execute();
//                }
//            };
//
//    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
//
//        private final MealDao mMealDao;
//
//        // Constructor
//        public PopulateDbAsync(MealDatabase db) {
//            mMealDao = db.mealDao();
//        }
//
//        @Override
//        protected Void doInBackground(final Void... params) {
//            // Check if database is empty
//            if (mMealDao.getAnyMeal().size() == 0) {
//                // If so, populate it with initial data set
//                mMealDao.insert(new Meal(new Meal.Builder("Lasagne", "Italian pasta dish made with layers of cheese and tomato sauce", 8.5)));
//                mMealDao.insert(new Meal(new Meal.Builder("Burger", "Sandwich consisting of one or more cooked patties of ground meat, usually beef", 6.5)));
//                mMealDao.insert(new Meal(new Meal.Builder("Sushi", "Japanese dish made with vinegared rice and various fillings", 12.0)));
//                mMealDao.insert(new Meal(new Meal.Builder("Pizza", "Flatbread topped with tomato sauce, cheese, and various toppings", 10.0)));
//            }
//            return null;
//        }
//    }
}