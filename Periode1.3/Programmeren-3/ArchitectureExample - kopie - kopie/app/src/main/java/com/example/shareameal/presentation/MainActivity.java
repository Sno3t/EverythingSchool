package com.example.shareameal.presentation;

import static android.app.PendingIntent.getActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.shareameal.domain.Meal;
import com.example.shareameal.presentation.viewmodel.MealViewModel;
import com.example.shareameal.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MealViewModel mealViewModel;
    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate main called");
        setContentView(R.layout.activity_main);

        // Initialize the RecyclerView.
        RecyclerView recyclerView = findViewById(R.id.meal_list_recycler_view);

        // Set the layout manager to the recyclerview
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setHasFixedSize(true);

        MealAdapter adapter = new MealAdapter();
        recyclerView.setAdapter(adapter);

        // Initialize the adapter and set it to the RecyclerView.
        mealViewModel = new ViewModelProvider(this).get(MealViewModel.class);
        mealViewModel.insertMeals();
        mealViewModel.getAllMeals().observe(this, new Observer<List<Meal>>() {
            @Override
            public void onChanged(List<Meal> meals) {
                Log.d(TAG, "onChanged called");
                //Updates the recyclerview
                adapter.submitList(meals);
            }
        });

        // Click on meal to get details
        adapter.setOnItemClickListener(new MealAdapter.OnItemClickListener() {
            public void onItemClick(int position) {
                // Handle click event here, e.g. start a new activity
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
//                intent.putExtra("position", position);
                intent.putExtra("meal", (Parcelable) adapter.getMealAt(position));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);


        // Add meal button activity start
        FloatingActionButton buttonViewMeal = findViewById(R.id.button_add_meal);
        buttonViewMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_all_meals:
                mealViewModel.deleteAllMeals();
                Toast.makeText(this, "All meals deleted", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}