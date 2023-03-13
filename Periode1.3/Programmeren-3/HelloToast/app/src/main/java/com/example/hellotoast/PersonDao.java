package com.example.hellotoast;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.hellotoast.domain.Person;

import java.util.List;

/**
 * Data Access Object (DAO) for a word.
 * Each method performs a database operation, such as inserting or deleting a word,
 * running a DB query, or deleting all words.
 */

@Dao
public interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Person person);

    @Query("DELETE FROM person_table")
    void deleteAll();

    @Delete
    void deletePerson(Person person);

    @Query("SELECT * from person_table LIMIT 1")
    List<Person> getAnyPerson();

    @Query("SELECT * from person_table ORDER BY first_name ASC")
    LiveData<List<Person>> getAllPeople();

    @Update
    void update(Person... people);
}
