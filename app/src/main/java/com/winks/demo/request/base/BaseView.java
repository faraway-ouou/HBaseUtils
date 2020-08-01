package com.winks.demo.request.base;

public interface BaseView extends com.winks.utils.base.BaseView {
    void onError(RetrofitException.ResponeThrowable throwable);
}
