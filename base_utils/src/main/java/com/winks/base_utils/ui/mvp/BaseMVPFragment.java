package com.winks.base_utils.ui.mvp;
import com.winks.base_utils.ui.view.BaseFragment;

public abstract class BaseMVPFragment<T extends BasePresenter> extends BaseFragment implements BaseView {
    protected T mPresenter;

    @Override
    protected void initPresenter() {
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void removePresenter() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void onNetWorkError() {
    }

    protected abstract T createPresenter();

}
