package com.origin.sc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.origin.sc.frame.MiddleProxy;
import com.origin.sc.frame.HttpCallBack;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button mBtn;
    TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = (Button) findViewById(R.id.button);
        mTv = (TextView) findViewById(R.id.textView);
    }


    public void onClick(View v) {
        String url = "http://192.168.100.237:8080/test";
        Map<String, Object> map = new HashMap<>();
        map.put("str", "android");
        MiddleProxy.getInstance().post(url, map, new HttpCallBack<String>() {
            @Override
            public void onSuccess(String result) {
                mTv.setText(result);
            }

            @Override
            public void onFailure(String msg) {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
