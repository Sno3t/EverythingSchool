package com.example.shareameal.presentation;

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
import com.example.shareameal.domain.Meal;
import com.example.shareameal.R;

public class MealAdapter extends ListAdapter<Meal, MealAdapter.MealHolder> {

    private static final String TAG = MealAdapter.class.getSimpleName();

    private OnItemClickListener listener;

    public MealAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Meal> DIFF_CALLBACK = new DiffUtil.ItemCallback<Meal>() {
        @Override
        public boolean areItemsTheSame(@NonNull Meal oldItem, @NonNull Meal newItem) {
            return true;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Meal oldItem, @NonNull Meal newItem) {
            return true;
        }
    };

    @NonNull
    @Override
    public MealHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_item, parent, false);
        return new MealHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder position " + position);

        // Insert data onto the cards
        Meal currentMeal = getItem(position);
        holder.textViewName.setText(currentMeal.getName());
        holder.textViewDescription.setText(currentMeal.getDescription());

        Glide.with(holder.imageViewImage)
                .load(currentMeal.getImageUrl())
                .placeholder(R.drawable.food_placeholder)
                .into(holder.imageViewImage);
    }

    public Meal getMealAt(int position) {
        return getItem(position);
    }

    class MealHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewDescription;
        private ImageView imageViewImage;

        public MealHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.meal_list_item_name);
            textViewDescription = itemView.findViewById(R.id.meal_list_description);
            imageViewImage = itemView.findViewById(R.id.meal_list_item_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
