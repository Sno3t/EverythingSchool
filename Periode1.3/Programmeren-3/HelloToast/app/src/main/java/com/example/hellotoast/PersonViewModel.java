package com.example.hellotoast;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.hellotoast.domain.Person;
import java.util.List;

/**
 * The PersonViewModel provides the interface between the UI and the data layer of the app,
 * represented by the Repository
 */

public class PersonViewModel extends AndroidViewModel {

    private PersonRepository mRepository;

    private LiveData<List<Person>> mAllPersons;

    public PersonViewModel(Application application) {
        super(application);
        mRepository = new PersonRepository(application);
        mAllPersons = mRepository.getAllPersons();
    }

    LiveData<List<Person>> getAllPersons() {
        return mAllPersons;
    }

    public void insert(Person person) {
        mRepository.insert(person);
    }

    public void deleteAll() {
        mRepository.deleteAll();
    }

    public void deletePerson(Person person) {
        mRepository.deletePerson(person);
    }

    public void update(Person person) {
        mRepository.update(person);
    }
}

