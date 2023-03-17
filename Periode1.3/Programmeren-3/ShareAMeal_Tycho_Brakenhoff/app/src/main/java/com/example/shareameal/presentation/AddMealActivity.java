package com.example.shareameal.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shareameal.R;

public class AddMealActivity extends AppCompatActivity {

    //    private EditText TextmParticipants;
    private EditText TextmAllergenes;
    private EditText TextimageUrl;
    private EditText Textprice;
    private EditText TextmaxAmountOfParticipants;
    private DatePicker dateTime;
    private CheckBox checkBoxisToTakeHome;
    private CheckBox checkBoxisVegan;
    private CheckBox checkBoxisVega;
    private CheckBox checkBoxisActive;
    private EditText Textdescription;
    private EditText Textname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        Intent intent = getIntent();
        setTitle("Add Meal");

    }

    private void saveMeal() {
        String mName = Textname.getText().toString();
        String mDescription = Textdescription.getText().toString();
        Boolean mIsActive = checkBoxisActive.isChecked();
        Boolean mIsVega = checkBoxisVega.isChecked();
        Boolean mIsVegan = checkBoxisVegan.isChecked();
        Boolean mIsToTakeHome = checkBoxisToTakeHome.isChecked();
        String mImageUrl = TextimageUrl.getText().toString();

        if (mName.trim().isEmpty() || mDescription.trim().isEmpty() || mImageUrl.trim().isEmpty()) {
            Toast.makeText(this, "Please fill in everything", Toast.LENGTH_SHORT).show();
        }

        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_meal_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_meal:
                saveMeal();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}