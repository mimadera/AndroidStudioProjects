package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button BtnAC;
    private Button Btn0;
    private Button Btn1;
    private Button Btn2;
    private Button Btn3;
    private Button Btn4;
    private Button Btn5;
    private Button Btn6;
    private Button Btn7;
    private Button Btn8;
    private Button Btn9;
    private Button BtnResult;
    private Button BtnMult;
    private Button BtnDiv;
    private Button BtnPlusMinus;
    private Button BtnPlus;
    private Button BtnMinus;
    private Button BtnProcent;

    private TextView userInput;
    private TextView results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView partialResults = (TextView) findViewById(R.id.results);
        final TextView result = (TextView) findViewById(R.id.userInput);

        BtnResult = (Button) findViewById(R.id.BtnResult);
        BtnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        BtnProcent = (Button) findViewById(R.id.BtnProcent);
        BtnProcent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        BtnDiv = (Button) findViewById(R.id.BtnDiv);
        BtnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        BtnMult = (Button) findViewById(R.id.BtnMult);
        BtnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        BtnPlus = (Button) findViewById(R.id.BtnPlus);
        BtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        BtnMinus = (Button) findViewById(R.id.BtnMinus);
        BtnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        BtnPlusMinus = (Button) findViewById(R.id.BtnPlusMinus);
        BtnPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        BtnAC = (Button) findViewById(R.id.BtnAC);
        BtnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Btn0 = (Button) findViewById(R.id.Btn0);
        Btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Btn1 = (Button) findViewById(R.id.Btn1);
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Btn2 = (Button) findViewById(R.id.Btn2);
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Btn3 = (Button) findViewById(R.id.Btn3);
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Btn4 = (Button) findViewById(R.id.Btn4);
        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Btn5 = (Button) findViewById(R.id.Btn5);
        Btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Btn6 = (Button) findViewById(R.id.Btn6);
        Btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Btn7 = (Button) findViewById(R.id.Btn7);
        Btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Btn8 = (Button) findViewById(R.id.Btn8);
        Btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Btn9 = (Button) findViewById(R.id.Btn9);
        Btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
