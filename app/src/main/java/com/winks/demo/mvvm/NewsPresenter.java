package com.winks.demo.mvvm;

import com.winks.demo.bean.Feed;
import com.winks.demo.bean.News;
import com.winks.demo.request.base.RequestSubscribe;
import com.winks.demo.request.base.RetrofitException;
import com.winks.demo.request.base.RxLifeCycleUtils;
import com.winks.demo.request.base.RxThreadUtil;
import com.winks.utils.base.BasePresenter;

public class NewsPresenter extends BasePresenter<NewsContract.view> implements NewsContract.presenter {
    public NewsMode mode;

    public NewsPresenter() {
        mode = new NewsMode();
    }

    @Override
    public void getNews() {
        if (!isViewAttached()) {
            return;
        }
        mode.getNews()
                .compose(RxLifeCycleUtils.bindToLifecycle(mView))
                .compose(RxThreadUtil.rxObservableSchedulerHelper())
                .subscribe(new RequestSubscribe<Feed>() {
                    @Override
                    protected void onRequestSuccess(Feed response) {
                        mView.onSuccess(response);
                    }

                    @Override
                    protected void onRequestError(RetrofitException.ResponeThrowable throwable) {
                        mView.onError(throwable);
                    }

                    @Override
                    protected void onNetWorkError() {

                    }
                });
    }
}
