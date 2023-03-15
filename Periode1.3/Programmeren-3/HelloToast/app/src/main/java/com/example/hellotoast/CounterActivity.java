package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hellotoast.presentation.MainActivity;

public class CounterActivity extends AppCompatActivity {
    private int mCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        this.mCounter = bundle.getInt(MainActivity.COUNTER_VALUE);

        TextView mCounterOutputTxt = (TextView) findViewById(R.id.counter_output_txt);
        mCounterOutputTxt.setText("" + this.mCounter);
    }
}