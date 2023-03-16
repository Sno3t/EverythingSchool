package com.example.hellotoast.misc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.hellotoast.R;

import java.util.ArrayList;
import java.util.List;

public class PersonListActivity extends AppCompatActivity {

    private static final String TAG = PersonListActivity.class.getSimpleName();
    private ArrayList<Person> people = null;

    private PersonViewModel personViewModel;
    private PersonListAdapter personListAdapter;
    private RecyclerView personListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);

        // De recyclerview opzetten zodat we persons in de lijst kunnen zien.
        personListAdapter = new PersonListAdapter(getApplicationContext());
        personListRecyclerView = findViewById(R.id.person_list_recycler_view);
        personListRecyclerView.setAdapter(personListAdapter);
        personListRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // LiveData opzetten en data ophalen uit het ViewModel.
        personViewModel = new ViewModelProvider(this).get(PersonViewModel.class);
        personViewModel.getAllPersons().observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(List<Person> people) {
                // Hier hebben we de lijst van persons vanuit de repository gekregen.
                // Lijst van people toevoegen aan de recyclerview
                Log.d(TAG, "Observer.onChanged aangeroepen");
                Log.d(TAG, "We hebben " + people.size() + " people");
                personListAdapter.setData((ArrayList<Person>) people);
            }
        });
    }

}