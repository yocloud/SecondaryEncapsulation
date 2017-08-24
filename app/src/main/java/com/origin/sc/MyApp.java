package com.origin.sc;

import android.app.Application;

import com.origin.sc.frame.MiddleProxy;
import com.origin.sc.util.OkHttpProcessor;

/**
 * @description
 * @antuor Yoke
 * @date 2017/8/24 9:56
 */

public class MyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
//        MiddleProxy.init(new VolleyProcessor(this));
        MiddleProxy.init(new OkHttpProcessor());
    }
}
