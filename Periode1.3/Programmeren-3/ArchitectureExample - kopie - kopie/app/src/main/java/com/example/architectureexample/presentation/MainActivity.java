package com.example.architectureexample.presentation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.architectureexample.domain.Meal;
import com.example.architectureexample.presentation.viewmodel.MealViewModel;
import com.example.architectureexample.R;


import java.util.List;

public class MainActivity extends AppCompatActivity {

//    public static final int ADD_MEAL_REQUEST = 1;
//    public static final int EDIT_MEAL_REQUEST = 2;
//    public static final int VIEW_MEAL_REQUEST = 3;

    private MealViewModel mealViewModel;
    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.meal_list_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setHasFixedSize(true);

        MealAdapter adapter = new MealAdapter();
        recyclerView.setAdapter(adapter);


        mealViewModel = new ViewModelProvider(this).get(MealViewModel.class);
        mealViewModel.insertMeals();
        mealViewModel.getAllMeals().observe(this, new Observer<List<Meal>>() {
            @Override
            public void onChanged(List<Meal> meals) {
                Log.d(TAG, "onChanged called");
                //Updates the recyclerview
                adapter.submitList(meals);
            }
        });


//        RecyclerView recyclerView = findViewById(R.id.meal_list_recycler_view);
//        //LinearLayoutManager moet gridlayoutmanager zijn
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
//        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setHasFixedSize(true);
//
//        final MealAdapter adapter = new MealAdapter();
//        recyclerView.setAdapter(adapter);
//
//
//        mealViewModel = new ViewModelProvider(this).get(MealViewModel.class);
//        mealViewModel.insertMeals();
//        mealViewModel.getAllMeals().observe(this, new Observer<List<Meal>>() {
//            @Override
//            public void onChanged(List<Meal> meals) {
//                //update RecyclerView
//                //Toast.makeText(MainActivity.this, "onChanged", Toast.LENGTH_SHORT).show();
//                adapter.submitList(meals);
//            }
//        });


        //Dit wordt de on click op de meal
//        FloatingActionButton buttonViewMeal = findViewById(R.id.button_add_meal);
//        buttonViewMeal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            //DIT MOET IK WSS OOK VERANDEREN
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
//                startActivityForResult(intent, VIEW_MEAL_REQUEST);
//            }
//        });



////        FloatingActionButton buttonAddMeal = findViewById(R.id.button_add_meal);
////        buttonAddMeal.setOnClickListener(new View.OnClickListener() {
////            @Override
////            //DIT MOET IK WSS OOK VERANDEREN
////            public void onClick(View view) {
////                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
////                startActivityForResult(intent, ADD_MEAL_REQUEST);
////            }
////        });

        //Dit wordt die button die naar de details pagina gaat
//        FloatingActionButton buttonAddMeal = findViewById(R.id.button_add_meal);
//        buttonAddMeal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            //DIT MOET IK WSS OOK VERANDEREN
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
//                startActivityForResult(intent, ADD_MEAL_REQUEST);
//            }
//        });



//        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
//                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
//            @Override
//            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//                return false;
//            }
//
//            @Override
//            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//                mealViewModel.delete(adapter.getMealAt(viewHolder.getAdapterPosition()));
//                Toast.makeText(MainActivity.this, "Meal deleted", Toast.LENGTH_SHORT).show();
//            }
//        }).attachToRecyclerView(recyclerView);

        //DIT MOET IK WSS OOK TOEVOEGEN BIJ DE TWEEDE ACTIVITY MAAR DAN ANDERS
        //DEZE MOET IN DE "DETAILS PAGINA" BIJ MEALS STAAN
//        adapter.setOnItemClickListener(new MealAdapter.OnItemClickListener() {
//
//
////        FloatingActionButton buttonViewMeal = findViewById(R.id.button_add_meal);
////        buttonViewMeal.setOnClickListener(new View.OnClickListener() {
//
//            private void showMeal(int id) {
//                // Find the Meal object with the specified id
//                for (Meal meal : meals) {
//                    if (meal.getId() == id) {
//                        // Show the Meal object to the user
//                        showMealToUser(meal);
//                        break;
//                    }
//                }
//            }
//            @Override
//            //DIT MOET IK WSS OOK VERANDEREN
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
//                startActivityForResult(intent, VIEW_MEAL_REQUEST);
//            }});
//        });
//            @Override
//            public void onItemClick(Meal meal) {
//                //DEZE LIJN VERANDEREN
//                Intent intent = new Intent(MainActivity.this, AddEditMealActivity.class);
//                intent.putExtra(AddEditMealActivity.EXTRA_MID, meal.getId());
//                intent.putExtra(AddEditMealActivity.EXTRA_MNAME, meal.getName());
//                intent.putExtra(AddEditMealActivity.EXTRA_MDESCRIPTION, meal.getDescription());
//                intent.putExtra(AddEditMealActivity.EXTRA_MISACTIVE, meal.isActive());
//                intent.putExtra(AddEditMealActivity.EXTRA_MISVEGA, meal.isVega());
//                intent.putExtra(AddEditMealActivity.EXTRA_MISVEGAN, meal.isVegan());
//                intent.putExtra(AddEditMealActivity.EXTRA_MISTOTAKEHOME, meal.isToTakeHome());
//                intent.putExtra(AddEditMealActivity.EXTRA_MDATETIME, meal.getDateTime());
//                intent.putExtra(AddEditMealActivity.EXTRA_MMAXAMOUNTOFPARTICIPANTS, meal.getMaxAmountOfParticipants());
//                intent.putExtra(AddEditMealActivity.EXTRA_MPRICE, meal.getPrice());
//                intent.putExtra(AddEditMealActivity.EXTRA_MIMAGEURL, meal.getImageUrl());
//                //intent.putExtra(AddEditMealActivity.EXTRA_MALLERGENES, meal.getAllergenes());
//                //intent.putExtra(AddEditMealActivity.EXTRA_MPARTICIPANTS, meal.getParticipants());
//
//                startActivityForResult(intent, EDIT_MEAL_REQUEST);
//            }


    }


    //Aanpassen voor meal dus meer toevoegen IN DE ANDERE ACTIVTY ZETTEN WSSW
    //DE ADD MAG VOLGENS MIJ BLIJVEN STAAN
    // MAAR DE EDIT MOET NAAR DE ANDERE
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        if (requestCode == ADD_MEAL_REQUEST && resultCode == RESULT_OK) {
//
//            String name = data.getStringExtra((AddEditMealActivity.EXTRA_MNAME));
//            String description = data.getStringExtra(AddEditMealActivity.EXTRA_MDESCRIPTION);
//            Boolean isActive = Boolean.valueOf(data.getStringExtra(AddEditMealActivity.EXTRA_MISACTIVE));
//            Boolean isVega = Boolean.valueOf(data.getStringExtra(AddEditMealActivity.EXTRA_MISVEGA));
//            Boolean isVegan = Boolean.valueOf(data.getStringExtra(AddEditMealActivity.EXTRA_MISVEGAN));
//            Boolean isToTakeHome = Boolean.valueOf(data.getStringExtra(AddEditMealActivity.EXTRA_MISVEGA));
//
////            // Retrieve the date string extra from the intent
////            String dateString = getIntent().getStringExtra(AddEditMealActivity.EXTRA_MDATETIME);
////
////            // Parse the date string into a Date object using SimpleDateFormat
////            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////            String date = "";
////            try {
////                date = String.valueOf(dateFormat.parse(dateString));
////            } catch (ParseException e) {
////                throw new RuntimeException(e);
////            }
//
//
//
//            String dateString = data.getStringExtra(AddEditMealActivity.EXTRA_MDATETIME);
//            SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
//            SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
//
//            String date;
//            try {
//                date = String.valueOf(inputDateFormat.parse(dateString));
//            } catch (ParseException e) {
//                Log.e(TAG, "Error parsing date", e);
//                Toast.makeText(this, "Error parsing date", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            String formattedDate = outputDateFormat.format(date);
//
//            if (dateString != null && !dateString.isEmpty()) {
//                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                try {
//                    String date = format.parse(dateString);
//                    // do something with the parsed date
//                } catch (ParseException e) {
//                    // handle the exception
//                }
//            } else {
//                // handle null or empty dateString
//            }
//
//            int maxAmountOfParticipants = data.getIntExtra(AddEditMealActivity.EXTRA_MMAXAMOUNTOFPARTICIPANTS, 1);
//            double price = data.getDoubleExtra(AddEditMealActivity.EXTRA_MPRICE, 1.00);
//            String imageUrl = data.getStringExtra(AddEditMealActivity.EXTRA_MIMAGEURL);
//            ArrayList<String> allergenes = data.getStringArrayListExtra(AddEditMealActivity.EXTRA_MALLERGENES);
//            ArrayList<String> participants = data.getStringArrayListExtra(AddEditMealActivity.EXTRA_MPARTICIPANTS);
//
//
//            Meal meal = new Meal(name, description, isActive, isVega, isVegan, isToTakeHome, date, maxAmountOfParticipants, price, imageUrl, allergenes, participants);
//
//            mealViewModel.insert(meal);
//            Toast.makeText(this, "Meal saved", Toast.LENGTH_SHORT).show();
//        } else if (requestCode == EDIT_MEAL_REQUEST && resultCode == RESULT_OK) {
//            int id = data.getIntExtra(AddEditMealActivity.EXTRA_MID, -1);
//
//            if (id == -1) {
//                Toast.makeText(this, "Meal can't be updated", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            String name = data.getStringExtra((AddEditMealActivity.EXTRA_MNAME));
//            String description = data.getStringExtra(AddEditMealActivity.EXTRA_MDESCRIPTION);
//            Boolean isActive = Boolean.valueOf(data.getStringExtra(AddEditMealActivity.EXTRA_MISACTIVE));
//            Boolean isVega = Boolean.valueOf(data.getStringExtra(AddEditMealActivity.EXTRA_MISVEGA));
//            Boolean isVegan = Boolean.valueOf(data.getStringExtra(AddEditMealActivity.EXTRA_MISVEGAN));
//            Boolean isToTakeHome = Boolean.valueOf(data.getStringExtra(AddEditMealActivity.EXTRA_MISVEGA));
//
//
////            // Retrieve the date string extra from the intent
////            String dateString = getIntent().getStringExtra(AddEditMealActivity.EXTRA_MDATETIME);
////
////            // Parse the date string into a Date object using SimpleDateFormat
////            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////            String date = null;
////            try {
////                date = String.valueOf(dateFormat.parse(dateString));
////            } catch (ParseException e) {
////                throw new RuntimeException(e);
////            }
//
//            String dateString = data.getStringExtra(AddEditMealActivity.EXTRA_MDATETIME);
//            SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
//            SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
//
//            String date;
//            try {
//                date = String.valueOf(inputDateFormat.parse(dateString));
//            } catch (ParseException e) {
//                Log.e(TAG, "Error parsing date", e);
//                Toast.makeText(this, "Error parsing date", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            String formattedDate = outputDateFormat.format(date);
//
//
//            int maxAmountOfParticipants = data.getIntExtra(AddEditMealActivity.EXTRA_MMAXAMOUNTOFPARTICIPANTS, 1);




//        if (requestCode == ADD_MEAL_REQUEST && resultCode == RESULT_OK) {
//
//            String name = data.getStringExtra((AddEditMealActivity.EXTRA_MNAME));
//            String description = data.getStringExtra(AddEditMealActivity.EXTRA_MDESCRIPTION);
//            Boolean isActive = Boolean.valueOf(data.getStringExtra(AddEditMealActivity.EXTRA_MISACTIVE));
//            Boolean isVega = Boolean.valueOf(data.getStringExtra(AddEditMealActivity.EXTRA_MISVEGA));
//            Boolean isVegan = Boolean.valueOf(data.getStringExtra(AddEditMealActivity.EXTRA_MISVEGAN));
//            Boolean isToTakeHome = Boolean.valueOf(data.getStringExtra(AddEditMealActivity.EXTRA_MISVEGA));
//
//            String dateString = data.getStringExtra(AddEditMealActivity.EXTRA_MDATETIME);
//            SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
//            SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
//
//            String date;
//            try {
//                // Validate dateString using Objects.requireNonNull()
//                date = String.valueOf(inputDateFormat.parse(Objects.requireNonNull(dateString, "dateString must not be null")));
//                date = outputDateFormat.format(date);
//            } catch (ParseException | NullPointerException e) {
//                Log.e(TAG, "Error parsing date", e);
//                Toast.makeText(this, "Error parsing date", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            int maxAmountOfParticipants = data.getIntExtra(AddEditMealActivity.EXTRA_MMAXAMOUNTOFPARTICIPANTS, 1);
//            double price = data.getDoubleExtra(AddEditMealActivity.EXTRA_MPRICE, 1.00);
//            String imageUrl = data.getStringExtra(AddEditMealActivity.EXTRA_MIMAGEURL);
//            ArrayList<String> allergenes = data.getStringArrayListExtra(AddEditMealActivity.EXTRA_MALLERGENES);
//            ArrayList<String> participants = data.getStringArrayListExtra(AddEditMealActivity.EXTRA_MPARTICIPANTS);
//
//
//            //Meal meal = new Meal(name, description, isActive, isVega, isVegan, isToTakeHome, date, maxAmountOfParticipants, price, imageUrl);
//                    //allergenes, participants
//                    //);
//
//            //mealViewModel.insert(meal);
//            Toast.makeText(this, "Meal saved", Toast.LENGTH_SHORT).show();
//        } else if (requestCode == EDIT_MEAL_REQUEST && resultCode == RESULT_OK) {
//            int id = data.getIntExtra(AddEditMealActivity.EXTRA_MID, -1);
//
//            if (id == -1) {
//                Toast.makeText(this, "Meal can't be updated", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            String name = data.getStringExtra((AddEditMealActivity.EXTRA_MNAME));
//            String description = data.getStringExtra(AddEditMealActivity.EXTRA_MDESCRIPTION);
//            Boolean isActive = Boolean.valueOf(data.getStringExtra(AddEditMealActivity.EXTRA_MISACTIVE));
//            Boolean isVega = Boolean.valueOf(data.getStringExtra(AddEditMealActivity.EXTRA_MISVEGA));
//            Boolean isVegan = Boolean.valueOf(data.getStringExtra(AddEditMealActivity.EXTRA_MISVEGAN));
//            Boolean isToTakeHome = Boolean.valueOf(data.getStringExtra(AddEditMealActivity.EXTRA_MISVEGA));
//
//            String dateString = data.getStringExtra(AddEditMealActivity.EXTRA_MDATETIME);
//            SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
//            SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
//
//            String date;
//            try {
//                // Validate dateString using Objects.requireNonNull()
//                date = String.valueOf(inputDateFormat.parse(Objects.requireNonNull(dateString, "dateString must not be null")));
//                date = outputDateFormat.format(date);
//            } catch (ParseException | NullPointerException e) {
//                Log.e(TAG, "Error parsing date", e);
//                Toast.makeText(this, "Error parsing date", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            int maxAmountOfParticipants = data.getIntExtra(AddEditMealActivity.EXTRA_MMAXAMOUNTOFPARTICIPANTS, 1);
//            double price = data.getDoubleExtra(AddEditMealActivity.EXTRA_MPRICE, 1.00);
//            String imageUrl = data.getStringExtra(AddEditMealActivity.EXTRA_MIMAGEURL);
//            ArrayList<String> allergenes = data.getStringArrayListExtra(AddEditMealActivity.EXTRA_MALLERGENES);
//            ArrayList<String> participants = data.getStringArrayListExtra(AddEditMealActivity.EXTRA_MPARTICIPANTS);
//
//
//            //Meal meal = new Meal(name, description, isActive, isVega, isVegan, isToTakeHome, date, maxAmountOfParticipants, price, imageUrl, allergenes, participants);
//            //meal.setId(id);
//            //mealViewModel.update(meal);
//
//            Toast.makeText(this, "Meal updated", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Meal not saved", Toast.LENGTH_SHORT).show();
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_all_meals:
                mealViewModel.deleteAllMeals();
                Toast.makeText(this, "All meals deleted", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}