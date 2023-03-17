package com.example.hellotoast.presentation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hellotoast.R;
import com.example.hellotoast.datastorage.MealRepository;
import com.example.hellotoast.domain.Meal;

import java.util.ArrayList;
import java.util.List;

public class MealAdapter extends ListAdapter<Meal, MealAdapter.MealViewHolder> {//RecyclerView.Adapter<MealAdapter.MealViewHolder> {

    private static final String TAG = MealAdapter.class.getSimpleName();
    private List<Meal> meals = new ArrayList<>();

    private MealRepository mealRepository;
    private LayoutInflater mInflater;

    public MealAdapter() {
        super(DIFF_CALLBACK); //Context context
//        mInflater = LayoutInflater.from(context);

    }

    private static final DiffUtil.ItemCallback<Meal> DIFF_CALLBACK = new DiffUtil.ItemCallback<Meal>() {
        @Override
        public boolean areItemsTheSame(@NonNull Meal oldItem, @NonNull Meal newItem) {
            //  return oldItem.getId() == newItem.getId();
            return true;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Meal oldItem, @NonNull Meal newItem) {
            return true;
        }
    };

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
        Glide.with(holder.image)
                .load(currentMeal.getImageUrl())
                .into(holder.image);
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

