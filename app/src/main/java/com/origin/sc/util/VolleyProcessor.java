package com.origin.sc.util;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.origin.sc.frame.FormatUtils;
import com.origin.sc.frame.ICallBack;
import com.origin.sc.frame.IHttpSpecs;

import java.util.Map;

/**
 * @description volley
 * @antuor Yoke
 * @date 2017/8/24 9:57
 */

public class VolleyProcessor implements IHttpSpecs {

    private static RequestQueue mQueue;

    public VolleyProcessor(Context context) {
        mQueue = Volley.newRequestQueue(context);
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallBack callBack) {
        url = FormatUtils.formatGetParams(url, params);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onFailure(error.toString());
            }
        });
        mQueue.add(request);
        mQueue.start();
    }

    @Override
    public void post(String url, Map<String, Object> params, final ICallBack callBack) {
        url = FormatUtils.formatGetParams(url, params);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onFailure(error.toString());
            }
        });
        mQueue.add(request);
    }


}
