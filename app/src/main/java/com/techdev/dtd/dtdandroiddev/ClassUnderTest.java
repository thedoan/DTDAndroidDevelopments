package com.techdev.dtd.dtdandroiddev;

import android.content.Context;

/**
 * Created by dangt on 2/20/2017.
 */

public class ClassUnderTest {
    Context context;
    public ClassUnderTest(Context context){
        this.context = context;
    }
    public String getHelloWorldString(){
        return context.getResources().getString(R.string.hello_word);
    }
}
