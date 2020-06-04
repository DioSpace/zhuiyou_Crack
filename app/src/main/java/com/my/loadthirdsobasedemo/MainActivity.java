package com.my.loadthirdsobasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.m4399.framework.helpers.AppNativeHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void load_encrypt_so(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String tmp = AppNativeHelper.getMd5("aaaa");
                System.out.println("result:\n" + tmp);
                Log.e("t1", "md5:\n" + tmp);
            }
        }).start();
    }
}