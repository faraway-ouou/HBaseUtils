package com.winks.demo.request.base;


import com.blankj.utilcode.util.ToastUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class RequestSubscribe<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {
    }

    @Override
    public void onNext(T t) {
        onRequestSuccess(t);
    }

    @Override
    public void onError(Throwable t) {
        RetrofitException.ResponeThrowable responeThrowable = RetrofitException.retrofitException(t);
        switch (responeThrowable.code) {
            case RetrofitException.ERROR.HTTP_ERROR:
            case RetrofitException.ERROR.SSL_ERROR:
            case RetrofitException.ERROR.NETWORD_ERROR:
            case RetrofitException.ERROR.UNKNOWN:
                onNetWorkError();
                ToastUtils.showShort(responeThrowable.message);
                break;
            default:
                onRequestError(responeThrowable);
                break;
        }
    }


    @Override
    public void onComplete() {
    }

    /**
     * 请求数据成功
     *
     * @param response
     */
    protected abstract void onRequestSuccess(T response);

    /**
     * 请求错误
     *
     * @param throwable
     */
    protected abstract void onRequestError(RetrofitException.ResponeThrowable throwable);

    /**
     * 网络错误
     */
    protected abstract void onNetWorkError();

}

