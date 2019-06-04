package com.example.wroclawguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wroclawguide.Database.EventCategoryRepository;
import com.example.wroclawguide.Database.EventRepository;
import com.example.wroclawguide.Database.MonumentsCategoryRepository;
import com.example.wroclawguide.Database.MonumentsRepository;
import com.example.wroclawguide.DatabaseTables.Event;
import com.example.wroclawguide.DatabaseTables.Monuments;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlaceDiscription extends AppCompatActivity {

    private int repositoryUsed;
    private long placeId;
    @BindView(R.id.placeDescri)
    TextView placeDiscription;
    @BindView(R.id.placeImage)
    ImageView placeImg;



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
            if (EventCategoryRepository.findById(this, event.getCategory().getId()).getName().equals("Koncert")){
                placeImg.setImageResource(R.drawable.koncert);
            }else {
                placeImg.setImageResource(R.drawable.splash);
            }
        }
        if (repositoryUsed == 3){
            Monuments monuments = MonumentsRepository.findById(this,placeId);
            String discription = monuments.getDescription();
            placeDiscription.setText(discription);

            if (monuments.getCategory().equals("Krasnoludki")){
                placeImg.setImageResource(R.drawable.krasnal);
            }
            if (MonumentsCategoryRepository.findById(this, monuments.getCategory().getId()).getName().equals("Zabytki")){
                placeImg.setImageResource(R.drawable.panorama);
            }
            if (MonumentsCategoryRepository.findById(this, monuments.getCategory().getId()).getName().equals("Muzea")){
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
