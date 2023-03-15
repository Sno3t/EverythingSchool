package com.example.hellotoast.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hellotoast.R;
import com.example.hellotoast.domain.Meal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = "MainActivity";
    public static final String COUNTER_VALUE = "COUNTER_VALUE";
    public static final String NAME_VALUE = "NAME_VALUE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate aangeroepen");

        goToMealListActivity();

//        // Voorbeeld van gebruik van Meal class met Builder Pattern
////        Meal newMeal = new Meal.Builder("Spaghetti", "Heerlijke pasta!", 6.75).build();
//
//        Meal newMeal = new Meal.Builder("aaa", "bbb", 6.66).build();
//        // Voorbeeld: print de gebuilde Meal in logcat.
//        // Pas eventueel zelf de toString()-methode aan voor meer attributen!
//        Log.d(TAG, "newMeal: " + newMeal.toString());
//        // Voorbeeld setter: wijzig achteraf het aantal deelnemers
//        newMeal.setMaxAmountOfParticipants(5);
//        // Voorbeeld getter
//        String name = newMeal.getName();

    }

    public void goToMealListActivity() {
        Intent intent = new Intent(this, MealListActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick aangeroepen");

//        switch (view.getId()) {
//            case R.id.activity_meal_list:
//                Log.d(TAG, "Start Open Counter activity");
//
//                Intent openCounterIntent = new Intent(this, CounterActivity.class);
//                Bundle extras = new Bundle();
//                extras.putInt(COUNTER_VALUE, this.mCounter);
//                openCounterIntent.putExtras(extras);
//                startActivity(openCounterIntent);
//                break;
//            case R.id.open_costume_list_view:
//                Log.d(TAG, "Open CostumeListView activity");
//                Intent openCostumeListIntent = new Intent(this, PersonListActivity.class);
//                startActivity(openCostumeListIntent);
//                break;
//            default:
//                Log.d(TAG, "Click nog niet geimpmelenteerd!");
//                break;
//        }
    }
}