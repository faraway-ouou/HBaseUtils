package com.winks.base_utils.request.manager;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxThreadUtil {
    /**
     * Observable 统一线程处理
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> rxObservableSchedulerHelper() {

        //compose简化线程
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
