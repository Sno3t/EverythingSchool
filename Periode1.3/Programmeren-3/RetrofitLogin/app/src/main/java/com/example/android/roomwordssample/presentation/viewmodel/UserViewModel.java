package com.example.android.roomwordssample.presentation.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.roomwordssample.datastorage.UserRepository;
import com.example.android.roomwordssample.domain.User;

public class UserViewModel extends AndroidViewModel {

    private UserRepository mUserRepository;
    private final static String TAG = UserViewModel.class.getSimpleName();

    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    private LiveData<User> mUser;
    private LiveData<User> mUserProfile;

    public UserViewModel(@NonNull Application application) {
        super(application);
        // Get Singleton
        mUserRepository = UserRepository.getInstance(application);
        mUser = mUserRepository.getUser();
        mUserProfile = mUserRepository.userProfile();
    }

    public LiveData<User> getUser() { return mUser; }
    public LiveData<User> userProfile() { return mUserProfile; }

    public void login(String emailAdress, String password) {
        this.mUserRepository.login(emailAdress, password);
    }

    public void getUserProfile() {
        // ToDo check of de user al ingelogd is en of er een token aanwezig is.
        if(mUser.getValue() != null) {
            this.mUserRepository.getUserProfile(mUser.getValue().getToken());
        } else {
            Log.d(TAG, "User is nog niet ingelogd!");
        }
    }

}
