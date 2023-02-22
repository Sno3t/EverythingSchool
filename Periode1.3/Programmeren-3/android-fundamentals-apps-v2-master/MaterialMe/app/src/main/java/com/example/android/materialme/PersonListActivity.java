package com.example.android.materialme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.materialme.domain.Person;

import java.util.ArrayList;

public class PersonListActivity extends AppCompatActivity implements RandomPersonTask.randomPersonListener{

    private static final String TAG = PersonListActivity.class.getSimpleName();

    private ArrayList<Person> people = null;
    private String randomUserUrl = "https://randomuser.me/api?results=5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);

        Log.d(TAG, "Task aanmaken en starten");

        // Make task and start
        RandomPersonTask task = new RandomPersonTask(this);
        task.execute(randomUserUrl);

        // Receive results

    }

    @Override
    public void onPeopleAvailabe(ArrayList<Person> people) {
    // put people in recuycle view
        Log.d(TAG, "Received people");
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}