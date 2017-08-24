package com.origin.sc.frame;

/**
 * @description 网络回调
 * @antuor Yoke
 * @date 2017/8/24 9:10
 */

public interface ICallBack {

    // 成功
    void onSuccess(String result);

    // 失败
    void onFailure(String msg);

}
