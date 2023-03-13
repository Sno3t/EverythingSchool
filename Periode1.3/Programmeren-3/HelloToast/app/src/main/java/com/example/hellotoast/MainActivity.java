package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hellotoast.domain.Meal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button openCounterBtn, counterPlusBtn, openCostumeListBtn;
    private final static String TAG = "MainActivity";
    private TextView mCounterOutput;
    private int mCounter = 0;
    public static final String COUNTER_VALUE = "COUNTER_VALUE";
    public static final String NAME_VALUE = "NAME_VALUE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate aangeroepen");

        // Maak verbinding met de Buttons
//        openCounterBtn = (Button) findViewById(R.id.open_counter_activity_btn);
//        openCounterBtn.setOnClickListener(this);
//
//        counterPlusBtn = (Button) findViewById(R.id.counter_plus_btn);
//        counterPlusBtn.setOnClickListener(this);
//
//        mCounterOutput = (TextView) findViewById(R.id.counter_output_txt);
//        mCounterOutput.setText("" + this.mCounter);
//
//        openCostumeListBtn = findViewById(R.id.open_costume_list_view);
//        openCostumeListBtn.setOnClickListener(this);

        // Voorbeeld van gebruik van Meal class met Builder Pattern
        Meal newMeal = new Meal.Builder("Spaghetti", "Heerlijke pasta!", 6.75)
                .setImageUrl("http://image.jpg")
                .setIsActive(true)
                .setMaxAmountOfParticipants(10)
                .build();
        // Voorbeeld: print de gebuilde Meal in logcat.
        // Pas eventueel zelf de toString()-methode aan voor meer attributen!
        Log.d(TAG, "newMeal: " + newMeal.toString());
        // Voorbeeld setter: wijzig achteraf het aantal deelnemers
        newMeal.setMaxAmountOfParticipants(5);
        // Voorbeeld getter
        String name = newMeal.getName();

    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick aangeroepen");

        switch (view.getId()){
            case R.id.counter_plus_btn:
                counterUp();
                break;
            case R.id.open_counter_activity_btn:
                Log.d(TAG, "Start Open Counter activity");

                Intent openCounterIntent = new Intent(this, CounterActivity.class);
                Bundle extras = new Bundle();
                extras.putInt(COUNTER_VALUE, this.mCounter);
                openCounterIntent.putExtras(extras);
                startActivity(openCounterIntent);
                break;
            case R.id.open_costume_list_view:
                Log.d(TAG, "Open CostumeListView activity");
                Intent openCostumeListIntent = new Intent(this, PersonListActivity.class);
                startActivity(openCostumeListIntent);
                break;
            default:
                Log.d(TAG, "Click nog niet geimpmelenteerd!");
                break;
        }
    }

    private void counterUp(){
        Log.d(TAG, "Counter Plus Button");
        this.mCounter++;
        if(mCounterOutput != null) {
            this.mCounterOutput.setText("" + this.mCounter);
        }
    }
}