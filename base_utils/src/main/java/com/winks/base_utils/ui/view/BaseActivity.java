package com.winks.base_utils.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;


public abstract class BaseActivity extends RxAppCompatActivity {
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        ActivityTaskManager.addActivity(this);
        mContext = this;
        initPresenter();
        initView();
    }
    protected abstract void initView();


    protected abstract int getLayoutID();//布局ID

    protected void initPresenter() {
    }

    protected void removePresenter() {
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removePresenter();
        ActivityTaskManager.removeActivity(this);
    }
}
