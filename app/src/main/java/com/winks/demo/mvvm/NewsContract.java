package com.winks.demo.mvvm;

import com.winks.demo.bean.Feed;
import com.winks.demo.bean.News;
import com.winks.demo.request.base.BaseView;
import com.winks.demo.request.base.RetrofitException;

import io.reactivex.Observable;

public interface NewsContract {
    interface mode{
        Observable<Feed> getNews();
    }
    interface view extends BaseView {
        void onSuccess(Feed feed);
    }
    interface presenter{
        void getNews();
    }
}
