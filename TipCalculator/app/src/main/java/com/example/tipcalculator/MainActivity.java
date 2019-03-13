package com.example.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //GUI
    private Button buttonClear;
    private Button buttonResult;

    // value entered by user, result and chosenAmmountOfTip
    double result;
    double resultInPercent;
    double valueFromUser;
    double chosenAmmountOfTip;
    

    private String chosenAmmountOfTipText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Spinner element
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final TextView textViewResult = (TextView) findViewById(R.id.textViewResult);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        editText2.setText("");

        /*
        array currency is in location res/values/strings.xml
         */

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tipList, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewResult.setText(" ");
                editText2.setText(" ");

            }
        });

        buttonResult = (Button) findViewById(R.id.buttonResult);
        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = String.valueOf(editText2.getText());
                valueFromUser = Double.parseDouble(value);
                resultInPercent = (chosenAmmountOfTip * valueFromUser)/100;
                result = valueFromUser + resultInPercent;
                String finalResult = Double.toString(result);
                textViewResult.setText(finalResult);


                editText2.setText(" ");

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        chosenAmmountOfTipText = parent.getItemAtPosition(position).toString();
        if(chosenAmmountOfTipText.equals("5")){
            chosenAmmountOfTip = 5;
        }
        if(chosenAmmountOfTipText.equals("10")){
            chosenAmmountOfTip = 10;
        }
        if(chosenAmmountOfTipText.equals("15")){
            chosenAmmountOfTip = 15;
        }
        if(chosenAmmountOfTipText.equals("20")){
            chosenAmmountOfTip = 20;
        }
        if(chosenAmmountOfTipText.equals("25")){
            chosenAmmountOfTip = 25;
        }
        if(chosenAmmountOfTipText.equals("30")){
            chosenAmmountOfTip = 30;
        }
        if(chosenAmmountOfTipText.equals("35")){
            chosenAmmountOfTip = 25;
        }
        if(chosenAmmountOfTipText.equals("40")){
            chosenAmmountOfTip = 40;
        }
        if(chosenAmmountOfTipText.equals("45")){
            chosenAmmountOfTip = 45;
        }
        if(chosenAmmountOfTipText.equals("50")){
            chosenAmmountOfTip = 50;
        }
        Toast.makeText(parent.getContext(), chosenAmmountOfTipText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
