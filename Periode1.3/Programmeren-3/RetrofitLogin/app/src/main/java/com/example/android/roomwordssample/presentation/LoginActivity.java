package com.example.android.roomwordssample.presentation;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.roomwordssample.R;
import com.example.android.roomwordssample.presentation.viewmodel.UserViewModel;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private TextView emailAdress;
    private TextView password;
    private UserViewModel mUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Get a new or existing ViewModel from the ViewModelProvider.
        mUserViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        emailAdress = findViewById(R.id.login_emailadress);
        password = findViewById(R.id.login_password);

        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Todo: check of password en emailadress ingevuld zijn

                mUserViewModel.login(emailAdress.getText().toString(), password.getText().toString());

                // Todo: handle errors etc!
                //Complete and destroy login activity once successful
                setResult(Activity.RESULT_OK);
                finish();

            }
        });
    }
}