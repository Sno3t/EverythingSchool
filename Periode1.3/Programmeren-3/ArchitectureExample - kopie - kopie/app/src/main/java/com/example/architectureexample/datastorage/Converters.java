package com.example.architectureexample.datastorage;

import androidx.room.TypeConverter;

import com.example.architectureexample.domain.User;
import com.google.gson.Gson;

public class Converters {
    private Gson gson = new Gson();
    @TypeConverter
    public User fromJson(String value) {
        return gson.fromJson(value, User.class);
    }
    @TypeConverter
    public String toJson(User user) {
        return gson.toJson(user);
    }

}
