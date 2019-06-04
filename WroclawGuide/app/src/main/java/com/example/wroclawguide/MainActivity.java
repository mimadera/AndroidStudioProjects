package com.example.wroclawguide;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;

import android.view.Window;


import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.events)
    public void eventsButtonPressed() {
        Intent intent = new Intent(getApplicationContext(), AttractionsListActivity.class);
        intent.putExtra("categoryCheck", 2);
        startActivity(intent);
    }

    @OnClick(R.id.places)
    public void placesButtonPressed() {
        Intent intent = new Intent(getApplicationContext(), AttractionsListActivity.class);
        intent.putExtra("categoryCheck", 1);
        startActivity(intent);
    }


    @OnClick(R.id.exit)
    public void exitButtonPressed() {
        this.finish();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }


}