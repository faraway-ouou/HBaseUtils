package com.winks.base_utils.request.manager;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class RequestSubscribe<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {
        onNetSubscribe(d);
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
                break;
            case RetrofitException.ERROR.PARSE_ERROR:
                onRequestError(new BaseObjectBean(false, responeThrowable.message, RetrofitException.ERROR.PARSE_ERROR));
                break;
            default:
                onRequestError(new BaseObjectBean(false, responeThrowable.message, responeThrowable.code));
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
     * @param objectBean
     */
    protected abstract void onRequestError(BaseObjectBean objectBean);

    /**
     * 网络错误
     */
    protected abstract void onNetWorkError();

    /**
     * 网络请求订阅
     *
     * @param d 可以在此取消网络请求
     */
    protected void onNetSubscribe(Disposable d) {
    }

    ;

}

