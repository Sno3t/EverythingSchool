package com.example.hellotoast.datastorage;

import androidx.room.TypeConverter;

import com.example.hellotoast.domain.Meal;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.sql.Date;
import java.util.ArrayList;

public class Converters {


    private Gson gson = new Gson();

    @TypeConverter
    public Meal fromJson(String value) {
        return gson.fromJson(value, Meal.class);
    }

    @TypeConverter
    public String toJson(Meal meal) {
        return gson.toJson(meal);
    }

    @TypeConverter
    public static ArrayList<String> fromString(String value) {
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<String> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
