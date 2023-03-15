package com.example.hellotoast.presentation;

import android.os.AsyncTask;
import android.util.Log;

import com.example.hellotoast.domain.Meal;

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

public class RandomMealTask
        extends AsyncTask<String, Void, ArrayList<Meal>> {

    private final static String TAG = RandomMealTask.class.getSimpleName();
    private ArrayList<Meal> meals = new ArrayList<>();

    private RandomMealListenener listener;

    private final static String JSON_RESULTS = "results";
    private final static String JSON_MEAL_NAME = "name";
    private final static String JSON_DESCRIPTION = "description";
    private final static String JSON_ISACTIVE = "isActive";
    private final static String JSON_ISVEGA = "isVega";
    private final static String JSON_ISVEGAN = "isVegan";
    private final static String JSON_ISTOTAKEHOME = "isToTakeHome";
    private final static String JSON_DATETIME = "dateTime";
    private final static String JSON_MAXAMOUNTOFPARTICIPANTS = "maxAmountOfParticipants";
    private final static String JSON_PRICE = "price";
    private final static String JSON_IMAGEURL_PICTURE = "imageUrl";
    private final static String JSON_ALLERGENES = "allergenes";
    private final static String JSON_PARTICIPANTS = "participants";

    // Constructor
    public RandomMealTask(RandomMealListenener listener) {
        this.listener = listener;
    }

    @Override
    protected ArrayList<Meal> doInBackground(String... strings) {
        // Url uitlezen
        String randomMealUrl = strings[0];
        Log.d(TAG, "doInBackground aangeroepen - url = " + randomMealUrl);

        // Request naar API sturen, via de URL
        // Response als JSON String ontvangen
        try {
            String jsonResponse = downloadUrl(randomMealUrl);
            Log.d(TAG, jsonResponse);
            meals = convertJsonToMeals(jsonResponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return meals;
    }

    @Override
    protected void onPostExecute(ArrayList<Meal> meals) {
        Log.d(TAG, "onPostExecute");
        listener.onMealsAvailable(meals);
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

    private ArrayList<Meal> convertJsonToMeals(String jsonResponse){
        // Parsen (uitpluizen)
        // Response omzetten van JSON naar ArrayList<Meal> meals.
        JSONObject response = null;

        try {
            response = new JSONObject(jsonResponse);
            JSONArray results = response.getJSONArray(JSON_RESULTS);
            for(int i = 0; i < results.length(); i++){
                JSONObject meal = results.getJSONObject(i);
                JSONObject name = meal.getJSONObject(JSON_MEAL_NAME);
                JSONObject description = meal.getJSONObject(JSON_DESCRIPTION);
                JSONObject price = meal.getJSONObject(JSON_PRICE);


                Meal.Builder p = new Meal.Builder(
                        name.getString(JSON_MEAL_NAME),
                        description.getString(JSON_DESCRIPTION),
                        price.getDouble(JSON_PRICE)
                );

                meals.add(p.build());
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return meals;
    }

    //
    public interface RandomMealListenener {
        public void onMealsAvailable(ArrayList<Meal> meals);
    }
}
