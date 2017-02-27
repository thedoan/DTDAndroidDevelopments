package com.techdev.dtd.dtdandroiddev.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.techdev.dtd.dtdandroiddev.R;

/**
 * Created by dangt on 2/25/2017.
 */

public class ActivityForResultActivity extends AppCompatActivity {
    private static String TAG = ActivityForResultActivity.class.getSimpleName();
    Button btnStartActivity;
    public static final int REQUEST_CODE_AFR=11;
    static final int PICK_CONTACT_REQUEST = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.v(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_results);
        btnStartActivity = (Button)findViewById(R.id.btnStartActivity);
        btnStartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(Intent.ACTION_PICK,
                        Uri.parse("content://contacts")),PICK_CONTACT_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.v(TAG,"onActivityResult");
        String intentAction="";
        if(data!=null){
            intentAction = data.getAction();
        }

        Log.v(TAG,"onActivityResult:requestCode:"+requestCode+" resultCode: "+resultCode+"intentAction:"+intentAction);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        Log.v(TAG,"onResume");
        super.onResume();

    }
}
