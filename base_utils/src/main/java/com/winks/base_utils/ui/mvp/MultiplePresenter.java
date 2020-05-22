package com.winks.base_utils.ui.mvp;

import java.util.ArrayList;
import java.util.List;

/**
 * 单页面多数据请求
 * @param <T>
 */
public class MultiplePresenter<T extends BaseView> extends BasePresenter<T> {
    private T mView;
    private List<BasePresenter> presenters = new ArrayList<>();

    /**
     * 添加Presenter
     * @param addPresenter
     * @param <K>
     */
    public final <K extends BasePresenter<T>> void addPresenter(K... addPresenter) {
        for (K ap : addPresenter) {
            ap.attachView(mView);
            presenters.add(ap);
        }
    }

    public MultiplePresenter(T mView) {
        this.mView = mView;
    }
    /**
     * 解除绑定
     */
    @Override
    public void detachView() {
        for (BasePresenter presenter:presenters){
            presenter.detachView();
        }
    }
}
