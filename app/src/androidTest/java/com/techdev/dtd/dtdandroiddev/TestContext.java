package com.techdev.dtd.dtdandroiddev;

import android.content.Intent;
import android.test.mock.MockContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dangt on 2/22/2017.
 */

public class TestContext extends MockContext {
    private List<Intent> mReceivedIntents = new ArrayList<Intent>();

    @Override
    public String getPackageName()
    {
        return "com.techdev.dtd.dtdandroiddev";
    }

    @Override
    public void startActivity(Intent xiIntent)
    {
        mReceivedIntents.add(xiIntent);
    }

    public List<Intent> getReceivedIntents()
    {
        return mReceivedIntents;
    }
}
