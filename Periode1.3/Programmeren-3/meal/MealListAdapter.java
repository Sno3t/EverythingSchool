
package com.android.example.roomwordssample.meal;/*

/**
 * Adapter for the RecyclerView that displays a list of Meals.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MealListAdapter extends RecyclerView.Adapter<MealListAdapter.MealViewHolder> {

    private final LayoutInflater mInflater;
    private List<Meal> mMeals; // Cached copy of Meals
    private static ClickListener clickListener;

    MealListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new MealViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MealViewHolder holder, int position) {
        if (mMeals != null) {
            Meal current = mMeals.get(position);
            holder.MealItemView.setText(current.getName());
        } else {
            // Covers the case of data not being ready yet.
            holder.MealItemView.setText(R.string.no_Meal);
        }
    }

    /**
     * Associates a list of Meals with this adapter
     */
    void setMeals(List<Meal> Meals) {
        mMeals = Meals;
        notifyDataSetChanged();
    }

    /**
     * getItemCount() is called many times, and when it is first called,
     * mMeals has not been updated (means initially, it's null, and we can't return null).
     */
    @Override
    public int getItemCount() {
        if (mMeals != null)
            return mMeals.size();
        else return 0;
    }

    /**
     * Gets the Meal at a given position.
     * This method is useful for identifying which Meal
     * was clicked or swiped in methods that handle user events.
     *
     * @param position The position of the Meal in the RecyclerView
     * @return The Meal at the given position
     */
    public Meal getMealAtPosition(int position) {
        return mMeals.get(position);
    }

    class MealViewHolder extends RecyclerView.ViewHolder {
        private final TextView MealItemView;

        private MealViewHolder(View itemView) {
            super(itemView);
            MealItemView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemClick(view, getAdapterPosition());
                }
            });
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        MealListAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(View v, int position);
    }

}
