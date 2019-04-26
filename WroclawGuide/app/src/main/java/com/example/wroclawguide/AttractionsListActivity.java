package com.example.wroclawguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.wroclawguide.Adapter.EventAdapter;
import com.example.wroclawguide.Adapter.MonumentsAdapter;
import com.example.wroclawguide.Database.EventCategoryRepository;
import com.example.wroclawguide.Database.EventRepository;
import com.example.wroclawguide.Database.MonumentsCategoryRepository;
import com.example.wroclawguide.Database.MonumentsRepository;
import com.example.wroclawguide.DatabaseTables.Event;
import com.example.wroclawguide.DatabaseTables.Monuments;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;


public class AttractionsListActivity extends AppCompatActivity {

    @BindView(R.id.categorySpinner)
    Spinner categorySpinner;
    @BindView(R.id.categoryListView)
    ListView categoryListView;

    private String category;
    private int categoryCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions_list);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        categoryCheck = intent.getIntExtra("categoryCheck", 0);
        setSpinnersContent();
    }

    private void setSpinnersContent() {
        String nothing = getString(R.string.noFilter);
        List<String> monumentsCategories = (ArrayList) MonumentsCategoryRepository.findAllNames(this);

        List<String> eventsCategories= (ArrayList) EventCategoryRepository.findAllNames(this);
        /*
        List<String> foodsCategories = (ArrayList) FoodCategoryRepository.findAllNames(this);
        */
        monumentsCategories.add(nothing); // no filter

        eventsCategories.add(nothing);
        /*
        foodsCategories.add(nothing);
        */

        if (categoryCheck == 1) {
            ArrayAdapter<String> monumentsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, monumentsCategories);
            monumentsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            categorySpinner.setAdapter(monumentsAdapter);
            categorySpinner.setSelection(monumentsCategories.size() - 1);
            // pierwszy bedzie ustawiony no filter
        }

        if (categoryCheck == 2){
            ArrayAdapter<String> eventsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, eventsCategories);
            eventsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            categorySpinner.setAdapter(eventsAdapter);
            categorySpinner.setSelection(eventsCategories.size() - 1);
        }
        /*
        if (categoryCheck == 3){
            ArrayAdapter<String> foodsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, foodsCategories);
            foodsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            categorySpinner.setAdapter(foodsAdapter);
            // Setting "no filter" on spinners
            categorySpinner.setSelection(foodsCategories.size() - 1);
        }
        */
    }
    /*
    private void setListViewContentFood(ArrayList<Food> foodList) {
        FoodAdapter adapter = new FoodAdapter(foodList, this);
        categoryListView.setAdapter(adapter);
    }
    */
    private void setListViewContentEvent(ArrayList<Event> eventList) {
        EventAdapter adapter = new EventAdapter(eventList, this);
        categoryListView.setAdapter(adapter);
    }

    private void setListViewContentMonuments(ArrayList<Monuments> monumentList) {
        MonumentsAdapter adapter = new MonumentsAdapter(monumentList, this);
        categoryListView.setAdapter(adapter);
    }

    @OnItemSelected(R.id.categorySpinner)
    public void categoryChoose(int position){
        category = (String) categorySpinner.getItemAtPosition(position);
        Log.i("attraction list","search button pressed");
        /*
        if (categoryCheck == 3){

            ArrayList<Food> foodList = (ArrayList) FoodRepository.filterList(
                    FoodRepository.findAll(this),
                    FoodCategoryRepository.findByName(this, category));
            setListViewContentFood(foodList);
            Log.i("attraction list","list Size" + foodList.size());
        }
         */
        if (categoryCheck == 2){
            ArrayList<Event> eventList = (ArrayList) EventRepository.filterList(
                    EventRepository.findAll(this),
                    EventCategoryRepository.findByName(this, category));
            setListViewContentEvent(eventList);

        }

        if (categoryCheck == 1){
            ArrayList<Monuments>  monumentList = (ArrayList) MonumentsRepository.filterList(
                    MonumentsRepository.findAll(this),
                    MonumentsCategoryRepository.findByName(this, category));
            setListViewContentMonuments(monumentList);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

}
