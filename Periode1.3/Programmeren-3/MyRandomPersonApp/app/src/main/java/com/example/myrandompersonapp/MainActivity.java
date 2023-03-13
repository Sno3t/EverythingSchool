package com.example.myrandompersonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class    MainActivity extends AppCompatActivity implements RandomPersonAPITask.RandomPersonListener {

    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recyclerview

        // AsyncTask starten en data terugontvangen
        RandomPersonAPITask task = new RandomPersonAPITask(this);
        String url = "https://randomuser.me/api?results=25";
        task.execute(url);

    }

    @Override
    public void onRandomPersonsAvailable(ArrayList<Person> people) {
        for(int i = 0; i < people.size(); i++){
            Log.d(TAG, "Person = " + people.get(i).getFirstName());
        }
    }
}