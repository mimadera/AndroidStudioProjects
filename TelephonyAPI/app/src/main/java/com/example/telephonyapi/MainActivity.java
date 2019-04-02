package com.example.telephonyapi;

import android.Manifest;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.provider.Telephony;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity{

    private TextView textViewSFID;
    private SmsBroadcastReceiver smsBroadcastReceiver;

    private final String serviceProviderNumber = "";
    private final String serviceProviderSmsCondition = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSFID = findViewById(R.id.textViewSFID);
        smsBroadcastReceiver = new SmsBroadcastReceiver(BuildConfig.SERVICE_NUMBER, BuildConfig.SERVICE_CONDITION);
        registerReceiver(smsBroadcastReceiver, new IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION));

        //    <--- task 1 --->
        TelephonyManager telephonyManager = (TelephonyManager)
                getSystemService(Context.TELEPHONY_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        String subscriberID = telephonyManager.getDeviceId();
        int callState = telephonyManager.getCallState();
        int phoneType = telephonyManager.getPhoneType();
        int networkType = telephonyManager.getNetworkType();
        String SIMSerialNumber = telephonyManager.getSimSerialNumber();
        String softwareVersion = telephonyManager.getDeviceSoftwareVersion();

        textViewSFID.setText("Subscriber ID " + subscriberID + System.lineSeparator() +
                            "Call State " + callState + System.lineSeparator() +
                            "Phone Type " + phoneType + System.lineSeparator() +
                            "Network Type " + networkType + System.lineSeparator() +
                            "SIM Serial Number " + SIMSerialNumber + System.lineSeparator() +
                            "Software Version " + softwareVersion + System.lineSeparator());

    }


}

