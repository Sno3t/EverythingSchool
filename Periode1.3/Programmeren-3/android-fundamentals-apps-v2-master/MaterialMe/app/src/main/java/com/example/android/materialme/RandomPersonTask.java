package com.example.android.materialme;

import android.nfc.Tag;
import android.os.AsyncTask;
import android.util.Log;

import com.example.android.materialme.domain.Person;

import java.util.ArrayList;

public class RandomPersonTask extends AsyncTask<String, Void, ArrayList<Person>> {

    private final static String TAG = RandomPersonTask.class.getSimpleName();
    private ArrayList<Person> people = new ArrayList<>();

//    private PersonListActivity listener;

    private randomPersonListener listener;

    public RandomPersonTask(randomPersonListener listener) {
        this.listener = listener;
    }

//    private void randomPersonTask

    @Override
    protected ArrayList<Person> doInBackground(String... strings) {
        String randomPersonUrl = strings[0];
        Log.d(TAG, "doInBackground called - " + randomPersonUrl);

        // Read url

        // Request to API

        // Get json results

        // Process results (json to arraylist)

        // Return

        return people;
    }

    @Override
    protected void onPostExecute(ArrayList<Person> people) {
        super.onPostExecute(people);
        Log.d(TAG, "onPostExecute");
        listener.onPeopleAvailabe(people);

    }

    public interface randomPersonListener{
        public void onPeopleAvailabe(ArrayList<Person> people);

    }

}
