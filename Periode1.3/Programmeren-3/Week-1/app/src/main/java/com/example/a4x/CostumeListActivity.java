package com.example.a4x;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CostumeListActivity extends AppCompatActivity {

    private ArrayList<Costume> costumeList;
    private CostumeListAdaptar costumeListAdaptar;
    private RecyclerView costumeListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        costumeList = createCostumeList();
        costumeListAdaptar = new CostumeListAdaptar(getApplicationContext(), costumeList);
        costumeListRecyclerView = findViewById(R.id.costume_list);
        costumeListRecyclerView.setAdapter(costumeListAdaptar);
        costumeListRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private ArrayList<Costume> createCostumeList(){
        ArrayList<Costume> costumeArrayList = new ArrayList<Costume>();

        for (int i = 0; i < 30; i++) {
            costumeArrayList.add(new Costume(R.drawable.clown,"Clown", "red nose", 3.5, true));
        }

        return costumeArrayList;
    }


}
