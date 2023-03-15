package com.example.hellotoast.presentation;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hellotoast.R;
import com.example.hellotoast.domain.Meal;
import com.example.hellotoast.presentation.viewmodel.MealViewModel;

import java.util.ArrayList;
import java.util.List;

public class MealListActivity extends AppCompatActivity {

    private static final String TAG = MealListActivity.class.getSimpleName();
    private ArrayList<Meal> meals = null;

    private MealViewModel mealViewModel;
    private MealListAdapter mealListAdapter;
    private RecyclerView mealListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_list);


        // De recyclerview opzetten zodat we meals in de lijst kunnen zien.
        mealListAdapter = new MealListAdapter(getApplicationContext()); //
        mealListRecyclerView = findViewById(R.id.meal_list_recycler_view);
        mealListRecyclerView.setAdapter(mealListAdapter);
        mealListRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // LiveData opzetten en data ophalen uit het ViewModel.
        mealViewModel = new ViewModelProvider(this).get(MealViewModel.class);
        mealViewModel.getAllMeals().observe(this, new Observer<List<Meal>>() {

            @Override
            public void onChanged(List<Meal> meals) {
                // Hier hebben we de lijst van meals vanuit de repository gekregen.
                // Lijst van meals toevoegen aan de recyclerview
                Log.d(TAG, "Observer.onChanged aangeroepen");
                Log.d(TAG, "We hebben " + meals.size() + " meals");
                mealListAdapter.setData((ArrayList<Meal>) meals);
            }
        });
    }

}