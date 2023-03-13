package com.example.hellotoast;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hellotoast.domain.Person;
import java.util.ArrayList;
import java.util.List;

public class PersonListAdapter extends RecyclerView.Adapter<PersonListAdapter.PersonViewHolder> {

    private static final String TAG = PersonListAdapter.class.getSimpleName();
    private List<Person> mPeople;
    private LayoutInflater mInflater;

    public PersonListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        // Inflate an item view.
        View mItemView = mInflater.inflate(R.layout.person_list_item, parent, false);
        return new PersonViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder nr " + position);
        Person person = mPeople.get(position);
        String name = new StringBuilder()
                .append(person.getTitle())
                .append(" ")
                .append(person.getFirstName())
                .append(" ")
                .append(person.getLastName())
                .toString();
        holder.name.setText(name);
        Glide.with(holder.itemView).load(person.getImageUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        if(this.mPeople == null)
            return 0;
        else return mPeople.size();
    }

    public void setData(ArrayList<Person> mPeople) {
        Log.d(TAG, "setData(mPeople)");
        this.mPeople = mPeople;
        notifyDataSetChanged();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final String TAG = PersonViewHolder.class.getSimpleName();
        public TextView name;
        public ImageView image;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.person_list_item_name);
            image = itemView.findViewById(R.id.person_list_item_image);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "ViewHolder onClick - listitem nr " + getAdapterPosition());
        }
    }
}

