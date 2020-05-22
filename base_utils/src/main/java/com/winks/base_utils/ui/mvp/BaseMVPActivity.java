package com.winks.base_utils.ui.mvp;


import com.winks.base_utils.ui.view.BaseActivity;

/**
 * MVP BaseActivity
 * @param <T>
 */
public  abstract  class BaseMVPActivity<T extends BasePresenter> extends BaseActivity implements BaseView {
    protected T mPresenter;

    /**
     * 创建BasePresenter并且绑定BaseView
     */
    @Override
    protected void initPresenter() {
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        //页面销毁时解除绑定
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    /**
     * 创建Presenter
     *
     * @return
     */
    protected abstract T createPresenter();

    @Override
    public void onNetWorkError() {
    }
}
