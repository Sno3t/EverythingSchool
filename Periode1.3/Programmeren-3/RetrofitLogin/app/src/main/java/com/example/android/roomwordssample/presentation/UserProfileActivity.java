package com.example.android.roomwordssample.presentation;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.roomwordssample.R;
import com.example.android.roomwordssample.domain.User;
import com.example.android.roomwordssample.presentation.viewmodel.UserViewModel;

public class UserProfileActivity extends AppCompatActivity {

    private TextView userName;
    private TextView userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        userName = findViewById(R.id.profile_user_name);
        userEmail = findViewById(R.id.profile_user_email);

        // Get a new or existing ViewModel from the ViewModelProvider.
        UserViewModel mUserViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        mUserViewModel.getUserProfile();

        mUserViewModel.userProfile().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if(user != null) {
                    userName.setText(user.getDisplayName());
                    userEmail.setText(user.getEmailAdress());
                }
            }
        });

    }
}