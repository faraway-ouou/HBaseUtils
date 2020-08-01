package com.winks.demo.mvvm;

import com.winks.demo.bean.Feed;
import com.winks.demo.bean.News;
import com.winks.demo.request.base.RequestManager;

import io.reactivex.Observable;

public class NewsMode implements NewsContract.mode {
    @Override
    public Observable<Feed> getNews() {
        return RequestManager.getInstance().getApi.getNews();
    }
}
