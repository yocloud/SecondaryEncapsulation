package com.origin.sc.frame;

import java.util.Map;

/**
 * @description 规范行为
 * @antuor Yoke
 * @date 2017/8/24 9:41
 */

public interface IHttpSpecs {

    // get 请求
    void get(String url, Map<String, Object> params, ICallBack callBack);

    void post(String url, Map<String, Object> params, ICallBack callBack);

}
