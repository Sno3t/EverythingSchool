package com.example.myrandompersonapp;

public class Person {

    private String title;
    private String firstName;
    private String lastName;
    private String emailAddress = "dummy";
    private String imageUrl = "dummy";

    public Person(String title, String firstName, String lastName) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
