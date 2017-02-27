package com.techdev.dtd.dtdandroiddev;

import android.content.Intent;
import android.test.AndroidTestCase;

/**
 * Created by dangt on 2/22/2017.
 */

public class OutgoingCallReceiverTest extends AndroidTestCase {
    private OutgoingCallReceiver mReceiver;
    private TestContext mContext;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        mReceiver = new OutgoingCallReceiver();
        mContext = new TestContext();
    }

    public void testStartActivity()
    {
        Intent intent = new Intent(Intent.ACTION_NEW_OUTGOING_CALL);
        intent.putExtra(Intent.EXTRA_PHONE_NUMBER, "01234567890");

        mReceiver.onReceive(mContext, intent);
        assertEquals(1, mContext.getReceivedIntents().size());
        assertNull(mReceiver.getResultData());

        Intent receivedIntent = mContext.getReceivedIntents().get(0);
        assertNull(receivedIntent.getAction());
        assertEquals("01234567890", receivedIntent.getStringExtra("phoneNum"));
        assertTrue((receivedIntent.getFlags() & Intent.FLAG_ACTIVITY_NEW_TASK) != 0);
    }
}
