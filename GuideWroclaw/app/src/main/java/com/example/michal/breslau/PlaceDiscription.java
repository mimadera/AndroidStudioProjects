package com.example.michal.breslau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.michal.breslau.Database.EventCategoryRepository;
import com.example.michal.breslau.Database.EventRepository;
import com.example.michal.breslau.Database.FoodCategoryRepository;
import com.example.michal.breslau.Database.FoodRepository;
import com.example.michal.breslau.Database.MonumentsCategoryRepository;
import com.example.michal.breslau.Database.MonumentsRepository;
import com.example.michal.breslau.DatabaseTables.Event;
import com.example.michal.breslau.DatabaseTables.Food;
import com.example.michal.breslau.DatabaseTables.Monuments;
import com.example.michal.breslau.DatabaseTables.MonumentsCategory;
import com.example.michal.breslau.R;
import com.google.android.gms.maps.model.LatLng;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlaceDiscription extends AppCompatActivity {

    private int repositoryUsed;
    private long placeId;
    @BindView(R.id.placeDescri) TextView placeDiscription;
    @BindView(R.id.placeImage) ImageView placeImg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_discription);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        placeId = intent.getLongExtra( "parameterId", -1);
        repositoryUsed = intent.getIntExtra("repositoryUsed" , -1);
        loadObject();
    }

    @OnClick(R.id.navigateButton)
    public void placesButtonPressed() {

        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        intent.putExtra("startNavigate", 1);
        intent.putExtra("repositoryUsed", repositoryUsed);
        intent.putExtra("parameterId", placeId);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.exit)
    public void exitButtonPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void loadObject(){

        if (repositoryUsed == 1){
            Event event = EventRepository.findById(this,placeId);
            String discription = event.getDescription();
            placeDiscription.setText(discription);
            if (event.getCategory().equals("exhibition")){
                placeImg.setImageResource(R.drawable.koncert);
            }
            if (EventCategoryRepository.findById(this, event.getCategory().getId()).getName().equals("Event")){
                placeImg.setImageResource(R.drawable.koncert);
            }
        }
        if (repositoryUsed == 2){
            Food food = FoodRepository.findById(this,placeId);
            String discription = food.getDescription();
            placeDiscription.setText(discription);
            if (food.getCategory().equals("Restauracje")){
                placeImg.setImageResource(R.drawable.bernard);
            }
            if (FoodCategoryRepository.findById(this, food.getCategory().getId()).getName().equals("Food")){
                placeImg.setImageResource(R.drawable.bernard);
            }

        }
        if (repositoryUsed == 3){
            Monuments monuments = MonumentsRepository.findById(this,placeId);
            String discription = monuments.getDescription();
            placeDiscription.setText(discription);

            if (monuments.getCategory().equals("Krasnoludki")){
                placeImg.setImageResource(R.drawable.krasnal);
            }
            if (MonumentsCategoryRepository.findById(this, monuments.getCategory().getId()).getName().equals("Monuments")){
                placeImg.setImageResource(R.drawable.panorama);
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
