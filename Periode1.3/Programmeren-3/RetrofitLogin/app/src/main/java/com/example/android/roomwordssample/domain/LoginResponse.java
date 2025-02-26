package com.example.android.roomwordssample.domain;

public class LoginResponse {

    // De API retourneert altijd  { result: <je resultaat> }
    // Je result zit dus altijd ingepakt in een Result-object, dat je eerst moet uitpakken.
    private User result;

    public LoginResponse(User result) {
        this.result = result;
    }

    public User getResult() {
        return result;
    }
}
