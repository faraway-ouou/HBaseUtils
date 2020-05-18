package com.winks.utils.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;
import com.winks.utils.R;
import com.winks.utils.event.Event;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;

public abstract class BaseActivity extends RxAppCompatActivity {
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initStatusBar();
        setContentView(getLayoutID());
        ActivityTaskManager.addActivity(this);
        ButterKnife.bind(this);
        mContext = this;
        initStatusBarTopView();
        initPresenter();
        initView();
    }

    /**
     * 初始化状态栏
     */
    private void initStatusBar() {
        if (isTranslucentStatusBar()) {
            QMUIStatusBarHelper.translucent(this);
        }
        if (isStatusBarLightMode()){
            QMUIStatusBarHelper.setStatusBarLightMode(this);
        }else {
            QMUIStatusBarHelper.setStatusBarDarkMode(this);
        }
    }

    /**
     * 设置状态栏黑色字体图标 默认白色文字
     * @return
     */
    protected  boolean isStatusBarLightMode(){
        return false;
    };

    /**
     * 是否开启透明状态栏 默认开启
     * @return
     */
    protected  boolean isTranslucentStatusBar(){
        return true;
    };

    /**
     * 初始化顶部View 适配透明状态栏状态栏高度
     */
    private void initStatusBarTopView() {
        View mStatusBarTopView = findViewById(R.id.status_bar_top_bar_view);
        if (mStatusBarTopView !=null){
            ViewGroup.LayoutParams lp = mStatusBarTopView.getLayoutParams();
            lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
            lp.height = QMUIStatusBarHelper.getStatusbarHeight(mContext);
            mStatusBarTopView.setLayoutParams(lp);
            if (getStatusBarBackgroundColor() == -1){
                return;
            }
            mStatusBarTopView.setBackgroundColor(getStatusBarBackgroundColor());
        }
    }

    /**
     * 状态栏背景色
     * @return
     */
    protected int getStatusBarBackgroundColor() {
        return Color.WHITE;
    }

    protected abstract void initView();

    @Override
    public void onStart() {
        super.onStart();
        if (isRegisterEvenetBus()) {
            EventBus.getDefault().register(this);
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        if (isRegisterEvenetBus()) {
            EventBus.getDefault().unregister(this);
        }


    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBusCome(Event event) {
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEventBusCome(Event event) {
        if (event != null) {
            receiveStickyEvent(event);
        }
    }

    /**
     * 接收到分发到事件
     *
     * @param event 事件
     */
    protected void receiveEvent(Event event) {
    }

    /**
     * 接受到分发的粘性事件
     *
     * @param event 粘性事件
     */
    protected void receiveStickyEvent(Event event) {

    }

    protected abstract int getLayoutID();//布局ID

    /**
     * 是否注册EventBus
     *
     * @return
     */
    protected boolean isRegisterEvenetBus() {
        return false;
    }

    protected void initPresenter() {
    }

    protected void removePresenter() {
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        removePresenter();
        ActivityTaskManager.removeActivity(this);
    }
}
