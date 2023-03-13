package com.example.hellotoast;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hellotoast.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository
        implements RandomPersonTask.RandomPersonListenener {

    private PersonDao mPersonDao;
    private LiveData<List<Person>> mAllPeople;

    private String randomUserUrl = "https://randomuser.me/api?results=50";

    private static final String TAG = PersonRepository.class.getSimpleName();

    PersonRepository(Application application) {
        PersonRoomDatabase db = PersonRoomDatabase.getDatabase(application);
        mPersonDao = db.personDao();
        mAllPeople = mPersonDao.getAllPeople();

//        ConnectivityManager connMgr = (ConnectivityManager)
//                 application.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo =
//                connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//        boolean isWifiConn = networkInfo.isConnected();
//        networkInfo =
//                connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//        boolean isMobileConn = networkInfo.isConnected();
//        Log.d(TAG, "Wifi connected: " + isWifiConn);
//        Log.d(TAG, "Mobile connected: " + isMobileConn);

        // Twee mogelijkheden:
        if(true){
            // 1. We hebben connectie en kunnen een request naar de API sturen
            // We schrijven de people weg in de database.
            RandomPersonTask randomPersonTask = new RandomPersonTask(this);
            randomPersonTask.execute(randomUserUrl);
        } else {
            // of 2. Er is geen Wifi, dus we halen de people uit de database.
            mPersonDao.getAllPeople();
        }
    }

    @Override
    public void onPeopleAvailable(ArrayList<Person> people) {
        // People via de API ontvangen; zet deze in de LiveData.
        Log.d(TAG, "onPeopleAvailable - we hebben " + people.size() + " people");
        // mAllPeople.setValue(people); // gevolg: mAllPeople.onChanged
        for(int i = 0; i < people.size(); i++) {
            insert(people.get(i));
        }
    }

    LiveData<List<Person>> getAllPersons() {
        return mAllPeople;
    }

    public void insert(Person person) {
        new insertAsyncTask(mPersonDao).execute(person);
    }

    public void update(Person person)  {
        new updatePersonAsyncTask(mPersonDao).execute(person);
    }

    public void deleteAll()  {
        new deleteAllPersonsAsyncTask(mPersonDao).execute();
    }

    // Must run off main thread
    public void deletePerson(Person person) {
        new deletePersonAsyncTask(mPersonDao).execute(person);
    }

    // Static inner classes below here to run database interactions in the background.

    /**
     * Inserts a person into the database.
     */
    private static class insertAsyncTask extends AsyncTask<Person, Void, Void> {

        private PersonDao mAsyncTaskDao;

        insertAsyncTask(PersonDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Person... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    /**
     * Deletes all persons from the database (does not delete the table).
     */
    private static class deleteAllPersonsAsyncTask extends AsyncTask<Void, Void, Void> {
        private PersonDao mAsyncTaskDao;

        deleteAllPersonsAsyncTask(PersonDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }

    /**
     *  Deletes a single person from the database.
     */
    private static class deletePersonAsyncTask extends AsyncTask<Person, Void, Void> {
        private PersonDao mAsyncTaskDao;

        deletePersonAsyncTask(PersonDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Person... params) {
            mAsyncTaskDao.deletePerson(params[0]);
            return null;
        }
    }

    /**
     *  Updates a person in the database.
     */
    private static class updatePersonAsyncTask extends AsyncTask<Person, Void, Void> {
        private PersonDao mAsyncTaskDao;

        updatePersonAsyncTask(PersonDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Person... params) {
            mAsyncTaskDao.update(params[0]);
            return null;
        }
    }
}
