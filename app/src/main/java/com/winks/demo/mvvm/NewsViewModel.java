package com.winks.demo.mvvm;

import com.winks.demo.bean.Feed;
import com.winks.demo.request.base.RetrofitException;
import com.winks.demo.view.activity.DataBindingActivity;

public class NewsViewModel  {
    private DataBindingActivity activity;

    public NewsViewModel(DataBindingActivity activity) {
        this.activity = activity;
    }
    public void loadNews(){
        Feed feed = new Feed();
        feed.load(new NewsContract.view() {
            @Override
            public void onSuccess(Feed feed) {
                activity.mNewsList.addAll(feed.getData());
                activity.mDataBindingAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(RetrofitException.ResponeThrowable throwable) {

            }

            @Override
            public void onNetWorkError() {

            }

            @Override
            public void showLoading() {

            }

            @Override
            public void hideLoading() {

            }
        });
    }
}
