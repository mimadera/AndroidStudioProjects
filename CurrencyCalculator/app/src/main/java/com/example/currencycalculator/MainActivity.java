package com.example.currencycalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //currency converter
    private final double euro = 4.30;
    private final double dolar = 3.84;
    private final double zl = 1;
    private final double ruble = 0.05;
    private double calculatedAmountOfMoney;

    //GUI widgets
    Button buttonClear;
    Button buttonConvert;
    EditText editTextTransfer;
    TextView textViewResult;
    Spinner Currency1;
    Spinner Currency2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
        addItemsOnCurrencySpinner1();
        addItemsOnCurrencySpinner2();


        buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewResult.setText(" ");
                editTextTransfer.setText(" ");
            }
        });

        buttonConvert = findViewById(R.id.buttonConvert);
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textViewResult.setText((int) calculatedAmountOfMoney);
            }
        });

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addItemsOnCurrencySpinner1() {

        Currency1 = findViewById(R.id.Currency1);
        List<String> list = new ArrayList<String>();
        list.add("Euro");
        list.add("Dolar");
        list.add("Zl");
        list.add("Russian ruble");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Currency1.setAdapter(dataAdapter);
    }

    public void addItemsOnCurrencySpinner2() {

        Currency2 = findViewById(R.id.Currency2);
        List<String> list = new ArrayList<String>();
        list.add("Euro");
        list.add("Dolar");
        list.add("Zl");
        list.add("Russian ruble");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Currency2.setAdapter(dataAdapter);
    }
}
