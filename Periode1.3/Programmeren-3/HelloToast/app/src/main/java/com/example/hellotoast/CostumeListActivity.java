package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hellotoast.domain.Costume;

import java.util.ArrayList;

public class CostumeListActivity extends AppCompatActivity {

    private ArrayList<Costume> costumeList;
    private CostumeListAdapter costumeListAdapter;
    private RecyclerView costumeListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costume_list);

        // Data: lijst met 30 kostuums.
        costumeList = createCostumeList();

        // Adapter: koppelt lijst/data met RecyclerView/ViewHolder
        costumeListAdapter = new CostumeListAdapter(getApplicationContext(), costumeList);

        // RecyclerView: koppel adapter en layoutmanager
        costumeListRecyclerView = findViewById(R.id.costume_list_recycler_view);
        costumeListRecyclerView.setAdapter(costumeListAdapter);
        costumeListRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private ArrayList<Costume> createCostumeList(){
        ArrayList<Costume> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(new Costume(R.drawable.clown, "Clownskostuum", "Super grappig", 24.95, true));
            list.add(new Costume(R.drawable.lederhosen, "Lederhosen", "Super grappig", 32.95, false));
            list.add(new Costume(R.drawable.oktoberfest, "Oktoberfest", "Super grappig", 12.95, true));
        }
        return list;
    }
}