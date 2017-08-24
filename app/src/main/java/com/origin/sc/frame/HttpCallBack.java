package com.origin.sc.frame;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @description 网络回调
 * @antuor Yoke
 * @date 2017/8/24 9:25
 */

public abstract class HttpCallBack<T> implements ICallBack {

    @Override
    public void onSuccess(String result) {
        Class<?> clazz = analysisClassInfo(this);
        Gson gson = new Gson();
        T t = (T) gson.fromJson(result, clazz);
        onSuccess(t);
    }

    public abstract void onSuccess(T result);


    protected Class<?> analysisClassInfo(Object obj) {
        Type genType = obj.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        return (Class<?>) params[0];
    }
}
