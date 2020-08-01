package com.winks.demo.request.base;

import com.winks.demo.bean.Feed;
import com.winks.demo.bean.News;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    /**
     * 获取banner 数据
     *
     * @return
     */
    @GET("https://www.toutiao.com/api/pc/feed/")
    Observable<Feed> getNews();

}
