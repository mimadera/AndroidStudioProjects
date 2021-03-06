package com.example.telephonyapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class OutgoingCallReceiver extends BroadcastReceiver {
    public static final String ABORT_PHONE_NUMBER = "5556";
    @Override
    public void onReceive(Context context, Intent intent) {
    if (intent.getAction().equals(
            Intent.ACTION_NEW_OUTGOING_CALL)) {
        String phoneNumber = intent.getExtras().getString(Intent.EXTRA_PHONE_NUMBER);
        if ((phoneNumber != null) && phoneNumber.equals(
                OutgoingCallReceiver.ABORT_PHONE_NUMBER)) { Toast.makeText(context,
                "NEW_OUTGOING_CALL intercepted to number "
                        + "5556 - aborting call",
                Toast.LENGTH_LONG).show();
                this.setResultData(null);
        } }
} }
