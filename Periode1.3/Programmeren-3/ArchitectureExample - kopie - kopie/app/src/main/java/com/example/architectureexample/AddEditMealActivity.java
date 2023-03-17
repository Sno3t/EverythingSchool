package com.example.architectureexample;

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


//IK MOET VAN DEZE ACTIVITY OOK NOG EEN ANDERE ACTIVITY MAKEN MET EEN X VOOR SLUITEN
// IN DIE ACTIVITY KAN JE ALLEEN MAAR KIJKEN NAAR WAT ER IN ZIT
// ER ZIT OOK NOG ERGENS IN DIE ACTIVTY WAAR JE ALLEEN MAAR KAN KIJKEN EEN OPTIE OM NAAR DEZE ACTIVITY TE GAAN OM HET AAN TE PASSE
//OOK ZIT ER NOG EEN ACTIVITY IN DE KIJK ACTIVTY OM NAAR EEN COOK TE GAAN DIE OOK ALLEEN MAAR KIJKEN IS DIT IS WEL OPTIONEEL

public class AddEditMealActivity extends AppCompatActivity {

    //Alles wat note is moet meal worden
    //Hier moet dus ook meer bij worden gedaan

//    public static final String EXTRA_ID =
//            "com.example.architectureexample.EXTRA_ID";
//
//    public static final String EXTRA_TITLE =
//            "com.example.architectureexample.EXTRA_TITLE";
//
//    public static final String EXTRA_DESCRIPTION =
//            "com.example.architectureexample.EXTRA_DESCRIPTION";
//
//    public static final String EXTRA_PRIORITY =
//            "com.example.architectureexample.EXTRA_PRIORITY";
//    private EditText editTextTitle;
//    private EditText editTextDescription;
//    private NumberPicker numberPickerPriority;

    public static final String EXTRA_MID =
            "com.example.architectureexample.EXTRA_MID";

    public static final String EXTRA_MNAME =
            "com.example.architectureexample.EXTRA_MNAME";

    public static final String EXTRA_MDESCRIPTION =
            "com.example.architectureexample.EXTRA_MDESCRIPTION";

    public static final String EXTRA_MISACTIVE =
            "com.example.architectureexample.EXTRA_MISACTIVE";
    public static final String EXTRA_MISVEGA =
            "com.example.architectureexample.EXTRA_MISVEGA";

    public static final String EXTRA_MISVEGAN =
            "com.example.architectureexample.EXTRA_MISVEGAN";

    public static final String EXTRA_MISTOTAKEHOME =
            "com.example.architectureexample.EXTRA_MISTOTAKEHOME";

    public static final String EXTRA_MDATETIME =
            "com.example.architectureexample.EXTRA_MDATETIME";

    public static final String EXTRA_MMAXAMOUNTOFPARTICIPANTS =
            "com.example.architectureexample.EXTRA_MMAXAMOUNTOFPARTICIPANTS";

    public static final String EXTRA_MPRICE =
            "com.example.architectureexample.EXTRA_MPRICE";

    public static final String EXTRA_MIMAGEURL =
            "com.example.architectureexample.EXTRA_MIMAGEURL";

    public static final String EXTRA_MALLERGENES =
            "com.example.architectureexample.EXTRA_MALLERGENES";

    public static final String EXTRA_MPARTICIPANTS =
            "com.example.architectureexample.EXTRA_MPARTICIPANTS";

    private EditText editTextmParticipants;
    private EditText editTextmAllergenes;
    private EditText editTextmImageUrl;
    private EditText editTextmPrice;
    private EditText editTextmMaxAmountOfParticipants;
    private DatePicker datePickermDateTime;
    private CheckBox checkBoxmIsToTakeHome;
    private CheckBox checkBoxmIsVegan;
    private CheckBox checkBoxmIsVega;
    private CheckBox checkBoxmIsActive;
    private EditText editTextmDescription;
    private EditText editTextmName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);

        editTextmName = findViewById(R.id.edit_text_mName);
        editTextmDescription = findViewById(R.id.edit_text_mDescription);
        checkBoxmIsActive = findViewById(R.id.check_box_mIsActive);
        checkBoxmIsVega = findViewById(R.id.check_box_mIsVega);
        checkBoxmIsVegan = findViewById(R.id.check_box_mIsVegan);
        checkBoxmIsToTakeHome = findViewById(R.id.check_box_mIsToTakeHome);
        datePickermDateTime = findViewById(R.id.date_picker_mDateTime);
        editTextmMaxAmountOfParticipants = findViewById(R.id.edit_text_mMaxAmountOfParticipants);
        editTextmPrice = findViewById(R.id.edit_text_mPrice);
        editTextmImageUrl = findViewById(R.id.edit_text_mImageUrl);
        editTextmAllergenes = findViewById(R.id.edit_text_mAllergenes);
        editTextmParticipants = findViewById(R.id.edit_text_mParticipants);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();


        // DIT IS BELANGRIJK OM OP TE SLAAN ALS JE IETS VERANDERD 'EDIT'
        if (intent.hasExtra(EXTRA_MID)) {
            setTitle("Edit Meal");
            editTextmName.setText(intent.getStringExtra(EXTRA_MNAME));
            editTextmDescription.setText(intent.getStringExtra(EXTRA_MDESCRIPTION));

//            checkBoxmIsActive
//            checkBoxmIsVega
//            checkBoxmIsVegan
//            checkBoxmIsToTakeHome
//            datePickermDateTime
//           editTextmMaxAmountOfParticipants.setInt(intent.getIntExtra(EXTRA_MMAXAMOUNTOFPARTICIPANTS, 1));
//            editTextmMaxAmountOfParticipants.setText(intent.getStringExtra(EXTRA_MMAXAMOUNTOFPARTICIPANTS));
//          editTextmPrice.setText(intent.getDoubleExtra(EXTRA_MPRICE));
            editTextmImageUrl.setText(intent.getStringExtra(EXTRA_MIMAGEURL));
            //           editTextmAllergenes.setText(intent.getStringExtra(EXTRA_MALLERGENES));
            //          editTextmParticipants.setText(intent.getStringExtra(EXTRA_MPARTICIPANTS));

        } else {
            setTitle("Add Meal");
        }
    }

    private void saveMeal() {
        String mName = editTextmName.getText().toString();
        String mDescription = editTextmDescription.getText().toString();
        Boolean mIsActive = checkBoxmIsActive.isChecked();
        Boolean mIsVega = checkBoxmIsVega.isChecked();
        Boolean mIsVegan = checkBoxmIsVegan.isChecked();
        Boolean mIsToTakeHome = checkBoxmIsToTakeHome.isChecked();
        String mImageUrl = editTextmImageUrl.getText().toString();


        //String mDateTime = datePickermDateTime.getText().toString;
        //Date mDateTime = ;
        //int mMaxAmountOfParticipants = ;
        //double mPrice = ;
        //ArrayList<String> mAllergenes = ;
        //ArrayList<String> mParticipants = ;

        if (mName.trim().isEmpty() || mDescription.trim().isEmpty() || mImageUrl.trim().isEmpty()) {
            Toast.makeText(this, "Please insert the correct stuff", Toast.LENGTH_SHORT).show();
            return;
        }
        //MealRepository mealRepository = new MealRepository(getApplication());


        Intent data = new Intent();
        data.putExtra(EXTRA_MNAME, mName);
        data.putExtra(EXTRA_MDESCRIPTION, mDescription);
        data.putExtra(EXTRA_MISACTIVE, mIsActive);
        data.putExtra(EXTRA_MISVEGA, mIsVega);
        data.putExtra(EXTRA_MISVEGAN, mIsVegan);
        data.putExtra(EXTRA_MISTOTAKEHOME, mIsToTakeHome);
        data.putExtra(EXTRA_MIMAGEURL, mImageUrl);

        int id = getIntent().getIntExtra(EXTRA_MID, -1);
        if (id != -1) {
            data.putExtra(EXTRA_MID, id);
        }

        setResult(RESULT_OK, data);

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