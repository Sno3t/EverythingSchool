package com.example.a4x;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CostumeListAdaptar extends RecyclerView.Adapter<CostumeListAdaptar.CostumeViewHolder> implements View.OnClickListener {

    private ArrayList<Costume> costumes;
    private LayoutInflater mInflater;

    public CostumeListAdaptar(Context context, ArrayList<Costume> costumes) {
        this.costumes = costumes;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CostumeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View mItemView = mInflater.inflate(R.layout.costume_list_item, parent, false);
       return new CostumeViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CostumeViewHolder holder, int position) {
        Costume costume = costumes.get(position);

        holder.name.setText(costume.getName());
    }

    @Override
    public int getItemCount() {
        return costumes.size();
    }

    public ArrayList<Costume> getCostumes() {
        return costumes;
    }

    public void setCostumes(ArrayList<Costume> costumes) {
        this.costumes = costumes;
    }

    @Override
    public void onClick(View view) {
//        Log.d(TAG, "ViewholderClick");
    }

    class CostumeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView name;
        public TextView description;
        public TextView price;
        public TextView isAvailable;
        public ImageView image;

        public CostumeViewHolder(@NonNull View itemView) {
            super(itemView);


            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
//            isAvailable = itemView.findViewById(R.id.Costume_List);
//            name = itemView.findViewById(R.id.name);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {

        }
    }

}
