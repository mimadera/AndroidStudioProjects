package com.example.michal.breslau;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.io.InputStream;

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

    @OnClick(R.id.food)
    public void foodButtonPressed() {
        Intent intent = new Intent(getApplicationContext(), AttractionsListActivity.class);
        intent.putExtra("categoryCheck", 3);
        startActivity(intent);
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