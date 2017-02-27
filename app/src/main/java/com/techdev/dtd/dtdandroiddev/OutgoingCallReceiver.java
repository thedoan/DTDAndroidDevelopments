package com.techdev.dtd.dtdandroiddev;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by dangt on 2/22/2017.
 */

public class OutgoingCallReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context xiContext, Intent xiIntent)
    {
        if (xiIntent.getAction().equalsIgnoreCase(Intent.ACTION_NEW_OUTGOING_CALL))
        {
            String phoneNum = xiIntent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);

            Intent intent = new Intent(xiContext, MainActivity.class);
            intent.putExtra("phoneNum", phoneNum);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            xiContext.startActivity(intent);
            //setResultData(null);
        }
    }
}