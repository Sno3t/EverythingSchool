package com.example.hellotoast.misc;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class RandomPersonTask
        extends AsyncTask<String, Void, ArrayList<Person>> {

    private final static String TAG = RandomPersonTask.class.getSimpleName();
    private ArrayList<Person> people = new ArrayList<>();

    private RandomPersonListenener listener;

    private final static String JSON_RESULTS = "results";
    private final static String JSON_PERSON_NAME = "name";
    private final static String JSON_PERSON_TITLE = "title";
    private final static String JSON_PERSON_FIRST = "first";
    private final static String JSON_PERSON_LAST = "last";
    private final static String JSON_PERSON_IMAGE = "thumbnail";
    private final static String JSON_PERSON_PICTURE = "picture";

    // Constructor
    public RandomPersonTask(RandomPersonListenener listener) {
        this.listener = listener;
    }

    @Override
    protected ArrayList<Person> doInBackground(String... strings) {
        // Url uitlezen
        String randomPersonUrl = strings[0];
        Log.d(TAG, "doInBackground aangeroepen - url = " + randomPersonUrl);

        // Request naar API sturen, via de URL
        // Response als JSON String ontvangen
        try {
            String jsonResponse = downloadUrl(randomPersonUrl);
            Log.d(TAG, jsonResponse);
            people = convertJsonToPeople(jsonResponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    @Override
    protected void onPostExecute(ArrayList<Person> people) {
        Log.d(TAG, "onPostExecute");
        listener.onPeopleAvailable(people);
    }

    private String downloadUrl(String myurl) throws IOException {
        InputStream inputStream = null;
        // Only display the first 500 characters of the retrieved
        // web page content.
        int len = 10000;

        HttpURLConnection conn = null;
        try {
            URL url = new URL(myurl);
            conn =
                    (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            // Start the query
            conn.connect();
            int response = conn.getResponseCode();
            // Log.d(TAG, "The response is: " + response);
            inputStream = conn.getInputStream();

            // Convert the InputStream into a string
            String contentAsString = getStringFromInputStream(inputStream);
            return contentAsString;

            // Close the InputStream and connection
        } finally {
            conn.disconnect();
            if (inputStream != null) {
                inputStream.close();
            }
        }

    }

    // Reads an InputStream and converts it to a String.
    private static String getStringFromInputStream(InputStream inputStream){
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    private ArrayList<Person> convertJsonToPeople(String jsonResponse){
        // Parsen (uitpluizen)
        // Response omzetten van JSON naar ArrayList<Person> people.
        JSONObject response = null;

        try {
            response = new JSONObject(jsonResponse);
            JSONArray results = response.getJSONArray(JSON_RESULTS);
            for(int i = 0; i < results.length(); i++){
                JSONObject person = results.getJSONObject(i);
                JSONObject name = person.getJSONObject(JSON_PERSON_NAME);
                JSONObject picture = person.getJSONObject(JSON_PERSON_PICTURE);

                Person p = new Person(
                        name.getString(JSON_PERSON_TITLE),
                        name.getString(JSON_PERSON_FIRST),
                        name.getString(JSON_PERSON_LAST),
                        picture.getString(JSON_PERSON_IMAGE)
                );
                people.add(p);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    //
    public interface RandomPersonListenener {
        public void onPeopleAvailable(ArrayList<Person> people);
    }
}
