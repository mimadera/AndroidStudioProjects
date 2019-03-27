package com.example.intents;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class StudentActivity extends AppCompatActivity {

    private TextView email;
    private TextView name;
    private TextView indeks;
    private String nameSurname;
    private String emailAddress;
    private String indeksNumber;
    private Button btnBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        email = findViewById(R.id.textViewEmail);
        name = findViewById(R.id.textViewName);
        indeks = findViewById(R.id.textViewIndeks);


        btnBack = findViewById(R.id.btnBack);

        String index = indeks.getText().toString();

        btnBack = findViewById(R.id.btnBack);

        String indeksNum;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                indeksNum = null;
            } else {
                indeksNum = extras.getString("INDEKS");
            }
        } else {
            indeksNum = (String) savedInstanceState.getSerializable("INDEKS");
        }

        if (indeksNum.equals(index)) {
            Toast.makeText(StudentActivity.this, "indeks match", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(StudentActivity.this, "indeks not the same", Toast.LENGTH_LONG).show();
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(StudentActivity.this, MainActivity.class);

                nameSurname = name.getText().toString();
                emailAddress = email.getText().toString();
                indeksNumber = indeks.getText().toString();

                Bundle myBundle1 = new Bundle();
                myBundle1.putString("nameKey", nameSurname);
                myBundle1.putString("emailKey", emailAddress);
                myBundle1.putString("indeksKey", indeksNumber);

                myIntent.putExtras(myBundle1);
                setResult(Activity.RESULT_OK, myIntent);
                finish();
            }
        });
    }
}

