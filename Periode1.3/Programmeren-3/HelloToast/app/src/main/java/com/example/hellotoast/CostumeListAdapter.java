package com.example.hellotoast;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hellotoast.domain.Costume;
import com.example.hellotoast.domain.Meal;
import com.example.hellotoast.presentation.MealListAdapter;
import com.example.hellotoast.presentation.viewmodel.MealViewModel;

import java.util.ArrayList;
import java.util.List;

public class CostumeListAdapter extends RecyclerView.Adapter<CostumeListAdapter.CostumeViewHolder> {

    private static final String TAG = CostumeListAdapter.class.getSimpleName();
    private ArrayList<Costume> costumes;
    private LayoutInflater mInflater;

    public CostumeListAdapter(Context context, ArrayList<Costume> costumes) {
        this.costumes = costumes;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CostumeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        // Inflate an item view.
        View mItemView = mInflater.inflate(R.layout.costume_list_item, parent, false);
        return new CostumeViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CostumeViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder nr " + position);
        Costume costume = costumes.get(position);
        holder.name.setText(costume.getName());
        holder.description.setText(costume.getDescription());
        holder.price.setText("" + costume.getPrice());
        holder.image.setImageResource(costume.getImage());
    }

    @Override
    public int getItemCount() {
        return costumes.size();
    }

    class CostumeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final String TAG = CostumeViewHolder.class.getSimpleName();
        public TextView name;
        public TextView description;
        public TextView price;
        public ImageView image;

        public CostumeViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.costume_list_item_name);
            description = itemView.findViewById(R.id.costume_list_item_description);
            price = itemView.findViewById(R.id.costume_list_item_price);
            image = itemView.findViewById(R.id.costume_list_item_image);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "ViewHolder onClick - listitem nr " + getAdapterPosition());
        }
    }


}

