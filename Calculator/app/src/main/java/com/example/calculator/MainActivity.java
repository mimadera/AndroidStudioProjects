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
    private Button BtnComma;
    private Button BtnC;

    private double value1 = Double.NaN;
    private double value2;

    EditText userInput;
    TextView results;


    String action;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        results = findViewById(R.id.results);
        userInput = findViewById(R.id.userInput);
        Btn0 = findViewById(R.id.Btn0);
        Btn1 = findViewById(R.id.Btn1);
        Btn2 = findViewById(R.id.Btn2);
        Btn3 = findViewById(R.id.Btn3);
        Btn4 = findViewById(R.id.Btn4);
        Btn5 = findViewById(R.id.Btn5);
        Btn6 = findViewById(R.id.Btn6);
        Btn7 = findViewById(R.id.Btn7);
        Btn8 = findViewById(R.id.Btn8);
        Btn9 = findViewById(R.id.Btn9);

        BtnMinus = findViewById(R.id.BtnMinus);
        BtnProcent = findViewById(R.id.BtnProcent);
        BtnPlus = findViewById(R.id.BtnPlus);
        BtnPlusMinus = findViewById(R.id.BtnPlusMinus);
        BtnDiv = findViewById(R.id.BtnDiv);
        BtnResult = findViewById(R.id.BtnResult);
        BtnMult = findViewById(R.id.BtnMult);
        BtnAC = findViewById(R.id.BtnAC);
        BtnC = findViewById(R.id.BtnC);
        BtnComma = findViewById(R.id.BtnComma);

        BtnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(null);
                results.setText(null);
            }
        });

        BtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                action = "+";
                if(!Double.isNaN(value1)){
                    value2= Double.parseDouble(userInput.getText().toString());
                    value1 = value1 + value2;
                } else {
                    value1 = Double.parseDouble(userInput.getText().toString());
                }
                results.setText(value1 + " + ");
                userInput.setText(null);

            }
        });

        BtnPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                action = "+-";
                if(!Double.isNaN(value1)) {
                    value2= Double.parseDouble(userInput.getText().toString());
                    results.setText((value2 * -1) + "");
                    userInput.setText(null);
                }

            }
        });

        BtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                action = "+-";
                if(!Double.isNaN(value1)) {
                    value2= Double.parseDouble(userInput.getText().toString());
                    results.setText((value2 * -1) + "");
                    userInput.setText(null);
                    BtnC.setVisibility(View.GONE);
                    //stopButton.setVisibility(View.VISIBLE);
                }

            }
        });

        BtnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                action = "-";
                if(!Double.isNaN(value1)){
                    value2= Double.parseDouble(userInput.getText().toString());
                    value1 = value1 - value2;
                } else {
                    value1 = Double.parseDouble(userInput.getText().toString());
                }
                results.setText(value1 + " - ");
                userInput.setText(null);

            }
        });

        BtnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                action = "*";
                if(!Double.isNaN(value1)){
                    value2= Double.parseDouble(userInput.getText().toString());
                    value1 = value1 * value2;
                } else {
                    value1 = Double.parseDouble(userInput.getText().toString());
                }
                results.setText(value1 + " * ");
                userInput.setText(null);

            }
        });

        BtnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                action = "+";
                if(!Double.isNaN(value1)){
                    value2= Double.parseDouble(userInput.getText().toString());
                    value1 = value1 / value2;
                } else {
                    value1 = Double.parseDouble(userInput.getText().toString());
                }
                results.setText(value1 + " / ");
                userInput.setText(null);

            }
        });

        BtnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (action != null && action.equals("+")) {
                    double result = value1 + Double.parseDouble(userInput.getText().toString());
                    results.setText(null);
                    userInput.setText(String.valueOf(result));
                }else if (action != null && action.equals("-")) {
                    double result = value1 - Double.parseDouble(userInput.getText().toString());
                    results.setText(null);
                    userInput.setText(String.valueOf(result));
                }else if (action != null && action.equals("*")) {
                    double result = value1 * Double.parseDouble(userInput.getText().toString());
                    results.setText(null);
                    userInput.setText(String.valueOf(result));
                }else if (action != null && action.equals("/")) {
                    double result = value1 / Double.parseDouble(userInput.getText().toString());
                    results.setText(null);
                    userInput.setText(String.valueOf(result));
                }
                action = null;
                value1 = Double.NaN;
                userInput.setSelection(userInput.getText().length());

            }
        });

        BtnComma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText() + ".");
                userInput.setSelection(userInput.getText().length());
            }
        });

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText() + "1");
                userInput.setSelection(userInput.getText().length());
            }
        });

        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText() + "2");
                userInput.setSelection(userInput.getText().length());
            }
        });
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText() + "3");
                userInput.setSelection(userInput.getText().length());
            }
        });

        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText() + "4");
                userInput.setSelection(userInput.getText().length());
            }
        });

        Btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText() + "5");
                userInput.setSelection(userInput.getText().length());
            }
        });

        Btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText() + "6");
                userInput.setSelection(userInput.getText().length());
            }
        });

        Btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText() + "7");
                userInput.setSelection(userInput.getText().length());
            }
        });

        Btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText() + "8");
                userInput.setSelection(userInput.getText().length());
            }
        });

        Btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText() + "9");
                userInput.setSelection(userInput.getText().length());
            }
        });

        Btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText() + "0");
                userInput.setSelection(userInput.getText().length());
            }
        });



    }
}
