

//package com.example.application.domain;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class User {
//    private String user;
//    private String pass;
//    private HashMap<String, String> userInfo = new HashMap<String, String>();
//
//
//
//
//    public User(String user, String pass) {
//        this.user = user;
//        this.pass = pass;
//        userInfo.put(user, pass);
//    }
//
//    public String getUser() {
//        return user;
//    }
//
//    public String getPass() {
//        return pass;
//    }
//
//    public HashMap<String,String> getMap() {
//        return userInfo;
//    }
//
//
//}
package com.example.architectureexample.domain;

import java.util.List;

public class User {

    private List<String> roles;
    private boolean isActive;
    private String phoneNumber;
    private int id;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String emailAdress;

    public User(List<String> roles, boolean isActive, String phoneNumber, int id, String firstName, String lastName, String street, String city, String emailAdress) {
        this.roles = roles;
        this.isActive = isActive;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.emailAdress = emailAdress;
    }

    public List<String> getRoles() {
        return roles;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getEmailAdress() {
        return emailAdress;
    }
}

