package com.origin.sc.util;

import android.os.Handler;

import com.origin.sc.frame.FormatUtils;
import com.origin.sc.frame.ICallBack;
import com.origin.sc.frame.IHttpSpecs;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @description
 * @antuor Yoke
 * @date 2017/8/24 13:27
 */

public class OkHttpProcessor implements IHttpSpecs {

    OkHttpClient mOkHttpClient = null;
    Handler mHandler = null;

    public OkHttpProcessor() {
        mOkHttpClient = new OkHttpClient();
        mHandler = new Handler();
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallBack callBack) {
        url = FormatUtils.formatGetParams(url, params);
        Request request = new Request.Builder().url(url).addHeader("User-Agent", "a").get().build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onFailure(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String result = response.body().string();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onSuccess(result);
                        }
                    });

                } else {
                    callBack.onSuccess(response.message());
                }

            }
        });

    }

    @Override
    public void post(String url, Map<String, Object> params, final ICallBack callBack) {
        RequestBody body = appendBody(params);
        Request request = new Request.Builder().url(url).post(body).addHeader("User-Agent", "a").build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onFailure(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String result = response.body().string();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onSuccess(result);
                        }
                    });

                } else {
                    callBack.onSuccess(response.message());
                }
            }
        });
    }

    private RequestBody appendBody(Map<String, Object> params) {
        FormBody.Builder body = new FormBody.Builder();
        Iterator<String> iterator = params.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            body.add(key, params.get(key) + "");
        }
        return body.build();

    }
}
