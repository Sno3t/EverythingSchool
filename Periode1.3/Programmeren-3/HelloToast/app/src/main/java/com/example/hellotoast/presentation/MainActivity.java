package com.example.hellotoast.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hellotoast.R;
import com.example.hellotoast.domain.Meal;
import com.example.hellotoast.presentation.viewmodel.MealViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = "MainActivity";

    private MealViewModel mealViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate aangeroepen");

        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.meal_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        MealListAdapter adapter = new MealListAdapter();
        recyclerView.setAdapter(adapter);

        mealViewModel = new ViewModelProvider(this).get(MealViewModel.class);
        mealViewModel.getAllMeals().observe(this, new Observer<List<Meal>>() {
            @Override
            public void onChanged(List<Meal> meals) {
                //update recyclerview
//                Toast.makeText(MainActivity.this, "onChanged", Toast.LENGTH_LONG).show();
                adapter.setData(meals);
            }
        });
    }

//        goToMealListActivity();



    public void goToMealListActivity() {
        Intent intent = new Intent(this, MealListActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick aangeroepen");

//        switch (view.getId()) {
//            case R.id.activity_meal_list:
//                Log.d(TAG, "Start Open Counter activity");
//
//                Intent openCounterIntent = new Intent(this, CounterActivity.class);
//                Bundle extras = new Bundle();
//                extras.putInt(COUNTER_VALUE, this.mCounter);
//                openCounterIntent.putExtras(extras);
//                startActivity(openCounterIntent);
//                break;
//            case R.id.open_costume_list_view:
//                Log.d(TAG, "Open CostumeListView activity");
//                Intent openCostumeListIntent = new Intent(this, PersonListActivity.class);
//                startActivity(openCostumeListIntent);
//                break;
//            default:
//                Log.d(TAG, "Click nog niet geimpmelenteerd!");
//                break;
//        }
    }
}