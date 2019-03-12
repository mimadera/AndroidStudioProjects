package com.example.currenyexchange;

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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button buttonClear;
    private Button buttonResult;
    double result;
    double euro = 4.30;
    double dolar = 3.83;
    double funt = 4.96;
    double rubles = 0.0535;
    String text;

    double valueFromUser;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Spinner element
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final TextView textViewResult = (TextView) findViewById(R.id.textViewResult);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        spinner.setPrompt("Choose currency");
        editText2.setText("");

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currency, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewResult.setText(" ");
                editText2.setText(" ");
                result = 0;

            }
        });

        buttonResult = (Button) findViewById(R.id.buttonResult);
        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String finalResult = Double.toString(result);
                textViewResult.setText(finalResult);
                String value = String.valueOf(editText2.getText());
                valueFromUser = Double.parseDouble(value);


                editText2.setText(" ");

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        text = parent.getItemAtPosition(position).toString();
        if(text.equals("Euro")){
            result = euro * valueFromUser;
        }
        if(text.equals("Dolar")){
            result = dolar * valueFromUser;
        }
        if(text.equals("Funt")){
            result = funt * valueFromUser;
        }
        if(text.equals("Rubles")){
            result = rubles * valueFromUser;
        }
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
