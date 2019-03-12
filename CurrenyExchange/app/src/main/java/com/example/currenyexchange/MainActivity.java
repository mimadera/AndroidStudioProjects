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


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //GUI
    private Button buttonClear;
    private Button buttonResult;

    // value entered by user, result and chosenCurrency
    double result;
    double valueFromUser;
    double chosenCurrency;

    // currency value in zl
    final double  euro = 4.30;
    final double dolar = 3.83;
    final double funt = 4.96;
    final double rubles = 0.0535;

    private String chosenCurrencyText;

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

            }
        });

        buttonResult = (Button) findViewById(R.id.buttonResult);
        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = String.valueOf(editText2.getText());
                valueFromUser = Double.parseDouble(value);
                result = chosenCurrency * valueFromUser;
                String finalResult = Double.toString(result);
                textViewResult.setText(finalResult);


                editText2.setText(" ");

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        chosenCurrencyText = parent.getItemAtPosition(position).toString();
        if(chosenCurrencyText.equals("Euro")){
            chosenCurrency = euro;
        }
        if(chosenCurrencyText.equals("Dolar")){
            chosenCurrency = dolar;
        }
        if(chosenCurrencyText.equals("Funt")){
            chosenCurrency = funt;
        }
        if(chosenCurrencyText.equals("Rubles")){
            chosenCurrency = rubles;
        }
        Toast.makeText(parent.getContext(), chosenCurrencyText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
