package com.origin.sc.frame;

import java.util.Map;

/**
 * @description 中间代理者
 * @antuor Yoke
 * @date 2017/8/24 9:46
 */

public class MiddleProxy implements IHttpSpecs {

    private static MiddleProxy mProxy = null;

    private static IHttpSpecs mSpecs;

    private MiddleProxy() {
    }

    public static MiddleProxy getInstance() {
        synchronized (MiddleProxy.class) {
            if (mProxy == null) {
                mProxy = new MiddleProxy();
            }
        }
        return mProxy;
    }


    public static void init(IHttpSpecs specs) {
        mSpecs = specs;
    }


    @Override
    public void get(String url, Map<String, Object> params, ICallBack callBack) {
        mSpecs.get(url, params, callBack);
    }



    @Override
    public void post(String url, Map<String, Object> params, ICallBack callBack) {
        mSpecs.post(url, params, callBack);
    }


}
