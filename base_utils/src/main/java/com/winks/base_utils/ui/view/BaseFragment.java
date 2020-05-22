package com.winks.base_utils.ui.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.trello.rxlifecycle3.components.support.RxFragment;


public abstract class BaseFragment<T> extends RxFragment {
    private View mView;
    private Activity mActivity;
    public Context mContext;
    private LayoutInflater mInflater;
    protected boolean isInit = false;
    public boolean isVisible;
    public boolean isPrepared;
    public static final String TYPE_NAME = "type_name";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutID(), null);
        isInit = true;
        return mView;
    }

    /**
     * 视图是否已经对用户可见，系统的方法
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible = isVisibleToUser;
        baseLazyLoad();
    }
    /**
     * 懒加载条件判断
     */
    private void baseLazyLoad() {
        if (isPrepared) {
            if (isVisible) {

                lazyLoadShow();

            } else {
                lazyLoadHide();
            }

        }
    }

    /**
     * 出现懒加载
     */
    protected abstract void lazyLoadShow();

    /**
     * 隐藏懒加载
     */
    protected abstract void lazyLoadHide();

    protected abstract int getLayoutID();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mInflater = onGetLayoutInflater(savedInstanceState);
        initPresenter();
        initView();
        initData();
        isPrepared = true;
        baseLazyLoad();

    }

    protected void initView() {
    }

    ;

    protected void initData() {
    };


    @Override
    public void onDestroyView() {
        isPrepared = false;
        removePresenter();
        super.onDestroyView();
    }

    protected void initPresenter() {

    }

    protected void removePresenter() {
    }

}
