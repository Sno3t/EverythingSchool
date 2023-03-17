package com.example.shareameal.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.shareameal.R;
import com.example.shareameal.domain.Meal;
import com.example.shareameal.presentation.viewmodel.MealViewModel;

import java.text.NumberFormat;

public class DetailsActivity extends AppCompatActivity {

    private final static String TAG = "DetailActivity";

    private ImageView detailImageUrl;
    private TextView detailMealName;
    private TextView detailMealDescription;
    private TextView detailMealParticipants;
    private CheckBox detailMealCheckBoxIsVega;
    private CheckBox detailMealCheckBoxIsActive;
    private TextView detailMealPrice;
    private CheckBox detailMealCheckBoxIsToTakeHome;
    private TextView detailMealAllergenes;
    private TextView detailMealDateTime;
    private CheckBox detailMealCheckBoxIsVegan;
    private TextView detailMealMaxAmountOfParticipants;

    public static Intent getIntent(Context context, Meal meal) {
        Intent intent = new Intent(context, DetailsActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_details);

        Log.d(TAG, "Posistion of food in recycler " + String.valueOf(getIntent().getExtras().get("position")));

        Meal meal = (Meal) getIntent().getSerializableExtra("meal");

        detailImageUrl = findViewById(R.id.detail_imageUrl);
        detailMealName = findViewById(R.id.detail_meal_name);
        detailMealDescription = findViewById(R.id.detail_meal_description);
        detailMealParticipants = findViewById(R.id.detail_meal_participants);
        detailMealCheckBoxIsVega = findViewById(R.id.detail_meal_check_box_isVega);
        detailMealCheckBoxIsActive = findViewById(R.id.detail_meal_check_box_isActive);
        detailMealPrice = findViewById(R.id.detail_meal_price);
        detailMealCheckBoxIsToTakeHome = findViewById(R.id.detail_meal_check_box_isToTakeHome);
        detailMealAllergenes = findViewById(R.id.detail_meal_allergenes);
        detailMealDateTime = findViewById(R.id.detail_meal_dateTime);
        detailMealCheckBoxIsVegan = findViewById(R.id.detail_check_box_isVegan);
        detailMealMaxAmountOfParticipants = findViewById(R.id.detail_meal_maxAmountOfParticipants);

        Glide.with(this)
                .load(meal.getImageUrl())
                .placeholder(R.drawable.food_placeholder)
                .into(detailImageUrl);

        //Set rest of data
        detailMealName.setText(meal.getName());
        detailMealDescription.setText(meal.getDescription());
//        detailMealParticipants.setText(getString(R.string.detail_meal_participants_format, meal.getParticipants()));
        detailMealCheckBoxIsVega.setChecked(meal.isVega());
        detailMealCheckBoxIsVegan.setChecked(meal.isVegan());
        detailMealCheckBoxIsActive.setChecked(meal.isActive());
        detailMealPrice.setText(NumberFormat.getCurrencyInstance().format(meal.getPrice()));
        detailMealCheckBoxIsToTakeHome.setChecked(meal.isToTakeHome());
        detailMealAllergenes.setText((CharSequence) meal.getAllergenes());
        detailMealDateTime.setText(meal.getDateTime());

    }
}