package com.winks.utils.base;
public interface BaseView {
    /**
     * 网络错误
     */
    void onNetWorkError();

    /**
     * 展示提示
     */
    void showLoading();

    /**
     * 隐藏提示
     */


    void hideLoading();

    /**
     * 请求错误
     * @param o
     */
    void onError(Object o);
}
