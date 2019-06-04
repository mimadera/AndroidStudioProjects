package com.example.telephonyapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsBroadcastReceiver extends BroadcastReceiver {

    private SmsManager smsManager;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle pudsBundle = intent.getExtras();
        Object[] data = (Object[]) pudsBundle.get("pdus");
        SmsMessage messages = SmsMessage.createFromPdu((byte[]) data[0]);
        Intent smsIntent = new Intent(context,MainActivity.class);

        String number = messages.getOriginatingAddress();
        String text = messages.getMessageBody();

        int messageInInt = Integer.parseInt(text);

        if (messageInInt <= 5){
            messageInInt++;
        }

        String messageToSend = Integer.toString(messageInInt);

        Toast.makeText(context, "SMS RECEIVED - "
                + messages.toString(), Toast.LENGTH_LONG).show();

        this.smsManager = SmsManager.getDefault();

        smsManager.sendTextMessage(
                number, null,
                messageToSend,
                null, null);
    }
}