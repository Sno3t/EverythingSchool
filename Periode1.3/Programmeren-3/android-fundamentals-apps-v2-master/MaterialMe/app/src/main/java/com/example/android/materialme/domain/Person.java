package com.example.android.materialme.domain;

public class Person {
    private String title;
    private String name;
    private String lastname;
    private String imageUrl;

    public Person(String title, String name, String lastname, String imageUrl) {
        this.title = title;
        this.name = name;
        this.lastname = lastname;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
