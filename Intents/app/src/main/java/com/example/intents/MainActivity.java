package com.example.intents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button btnSMS;
    private Button btnContactList;
    private Button btnAbout;
    private Button btnMap;
    private TextView textResult;
    private EditText editTextSmS;
    private EditText editTextNumber;
    private EditText editTextIndeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSMS = findViewById(R.id.btnSMS);
        btnMap = findViewById(R.id.btnMap);
        btnAbout = findViewById(R.id.btnAbout);
        btnContactList = findViewById(R.id.btnContactList);
        textResult = findViewById(R.id.textResult);
        editTextSmS = findViewById(R.id.editTextSms);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextIndeks = findViewById(R.id.editTextIndeks);


        btnContactList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DEFAULT, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, 101);


            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String thePlace = "Rynek, Wrocław";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=(" + thePlace + ")"));
                startActivity(intent);


            }
        });

        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String smsText = editTextSmS.getText().toString();
                String telefonNumber = editTextNumber.getText().toString();


                Intent intent = new Intent(
                        Intent.ACTION_SENDTO,
                        Uri.parse("smsto:"+telefonNumber));
                intent.putExtra("sms_body",
                        smsText);
                startActivity(intent);

                try {
                    startActivity(intent);
                    finish();
                    Log.i("Sms Send", "");
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Sms not send", Toast.LENGTH_LONG).show();
                }


            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, StudentActivity.class);
                Bundle myDataBundle = new Bundle();
                String indeksNumber = editTextIndeks.getText().toString();
                intent.putExtra("INDEKS", indeksNumber);
                startActivityForResult(intent, 101);
            }
        });

    }
    // local listener receives callbacks from other activities
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if ((requestCode == 101 ) && (resultCode == Activity.RESULT_OK)){
                Bundle myResultBundle = data.getExtras();
                String name = myResultBundle.getString("nameKey");
                String email = myResultBundle.getString("emailKey");
                String indeks = myResultBundle.getString("indeksKey");
                textResult.setText(name + System.lineSeparator() + email + System.lineSeparator() + indeks);
                Toast.makeText(MainActivity.this, name + email + indeks, Toast.LENGTH_LONG).show();
            } }
        catch (Exception e) {
            Toast.makeText(MainActivity.this, "Problems - " + requestCode + " " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}

