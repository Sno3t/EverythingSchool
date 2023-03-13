package com.example.myrandompersonapp;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class RandomPersonAPITask
        extends AsyncTask<String, Void, ArrayList<Person>> {

    private RandomPersonListener listener;
    private final static String TAG = RandomPersonAPITask.class.getSimpleName();

    public RandomPersonAPITask(RandomPersonListener listener){
        // opslaan
        this.listener = listener;
    }

//    @Override
//    protected ArrayList<Person> doInBackground(String... strings) {
//        String url = strings[0];
//        Log.d(TAG, "doInBackground - URL = " + url);
//
//        ArrayList<Person> people = new ArrayList<>();
//        Person person = new Person("Mr.",
//                "Kees",
//                "Jansen",
//                "k.jansen@home.nl",
//                "aasdf");
//        people.add(person);
//
//        return people;
//    }

    @Override
    protected ArrayList<Person> doInBackground(String... params){

        String urlString = null;
        ArrayList<Person> people = new ArrayList<>();
        if(params[0] != null) {
            urlString = params[0];
        }
        Log.i(TAG, "doInBackground " + urlString);

        InputStream inputStream = null;
        int responsCode = -1;
        String response = null;

        try{
            URL url = new URL(urlString);
            URLConnection urlConnection = url.openConnection();

            if (!(urlConnection instanceof HttpURLConnection)) {
                // Url
                return null;
            }

            HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;
            httpConnection.setAllowUserInteraction(false);
            httpConnection.setInstanceFollowRedirects(true);
            httpConnection.setRequestMethod("GET");
            httpConnection.connect();

            responsCode = httpConnection.getResponseCode();

            if (responsCode == HttpURLConnection.HTTP_OK) {
                inputStream = httpConnection.getInputStream();
                response = getStringFromInputStream(inputStream);
                Log.d(TAG, "response = " + response);

                people = jsonParseResponse(response);
            }
        } catch (MalformedURLException e) {
            Log.e(TAG, "doInBackground MalformedURLEx " + e.getLocalizedMessage());
            return null;
        } catch (IOException e) {
            Log.e("TAG", "doInBackground IOException " + e.getLocalizedMessage());
            return null;
        }
        return people;
    }

    @Override
    protected void onPostExecute(ArrayList<Person> people) {
        super.onPostExecute(people);
        Log.d(TAG, "onPostExecute");
        // listener gebruiken om resultaat terug te sturen.
        listener.onRandomPersonsAvailable(people);
    }

    private ArrayList<Person> jsonParseResponse(String response){
        ArrayList<Person> people = new ArrayList<>();

        // Parse response.
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray results = jsonObject.getJSONArray("results");
            for (int i = 0; i < results.length(); i++) {
                JSONObject personJson = results.getJSONObject(i);
                String title = personJson.getJSONObject("name").getString("title");
                String first = personJson.getJSONObject("name").getString("first");
                String last = personJson.getJSONObject("name").getString("last");

                people.add(new Person(title, first, last));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return people;
    }

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

    interface RandomPersonListener {
        public void onRandomPersonsAvailable(ArrayList<Person> people);
    }
}
