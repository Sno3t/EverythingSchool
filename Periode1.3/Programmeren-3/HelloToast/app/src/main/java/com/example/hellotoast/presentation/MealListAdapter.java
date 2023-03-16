package com.example.hellotoast.presentation;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hellotoast.R;
import com.example.hellotoast.datastorage.MealRepository;
import com.example.hellotoast.domain.Meal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MealListAdapter extends RecyclerView.Adapter<MealListAdapter.MealViewHolder> {

    private static final String TAG = MealListAdapter.class.getSimpleName();
    private List<Meal> meals = new ArrayList<>();

    private MealRepository mealRepository;
    private LayoutInflater mInflater;

    public MealListAdapter() { //Context context
//        mInflater = LayoutInflater.from(context);

    }


    @NonNull
    @Override // initial
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder called");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_list_item, parent, false);
        return new MealViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder position " + position);

        Meal currentMeal = meals.get(position);
        holder.name.setText(currentMeal.getName());
        holder.description.setText(currentMeal.getDescription());
//        holder.image.setImageResource(currentMeal.getImageUrl());


//        Meal meal = meals.get(position);
//        String name = new StringBuilder()
//                .append(meal.getName())
//                .append(" ")
//                .append(meal.getDescription())
//                .append(" ")
//                .append(meal.getImageUrl())
//                .toString();
//        holder.name.setText(name);
//        Glide.with(holder.itemView).load(meal.getImageUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
//        return meals != null ? meals.size() : 0;
        return meals.size();
    }

    public void setData(List<Meal> meals) {
        Log.d(TAG, "setData(meals)");
        Log.d(TAG, String.valueOf(meals.size()));

        this.meals = meals;
        notifyDataSetChanged();
    }

    class MealViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final String TAG = MealViewHolder.class.getSimpleName();
        public TextView name;
        public TextView description;
        public ImageView image;

        public MealViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.meal_list_item_image);
            name = itemView.findViewById(R.id.meal_list_item_name);
            description = itemView.findViewById(R.id.meal_list_description);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "ViewHolder onClick - listitem nr " + getAdapterPosition());
        }
    }
}

