package com.winks.utils.base;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle3.components.support.RxFragmentActivity;
import com.winks.utils.R;
import com.winks.utils.event.Event;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.ButterKnife;

public abstract class BaseActivity extends RxFragmentActivity {
    protected Context mContext;
    public View mStatusBarTopView;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        FragmentManager fm = getSupportFragmentManager();
        int index = requestCode >> 16;
        if (index != 0) {
            index--;
            if (fm.getFragments() == null || index < 0
                    || index >= fm.getFragments().size()) {
                Log.w("tag", "Activity result fragment index out of range: 0x"
                        + Integer.toHexString(requestCode));
                return;
            }
            Fragment frag = fm.getFragments().get(index);
            if (frag == null) {
                Log.w("tag","Activity result no fragment exists for index: 0x"
                        + Integer.toHexString(requestCode));
            } else {
                handleResult(frag, requestCode, resultCode, data);
            }
            return;
        }
    }

    private void handleResult(Fragment frag, int requestCode, int resultCode,
                              Intent data) {
        frag.onActivityResult(requestCode & 0xffff, resultCode, data);
        List<Fragment> frags = frag.getChildFragmentManager().getFragments();
        if (frags != null) {
            for (Fragment f : frags) {
                if (f != null)
                    handleResult(f, requestCode, resultCode, data);
            }
        }
    }
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
        return true;
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
    public void initStatusBarTopView() {
        mStatusBarTopView = findViewById(R.id.status_bar_top_bar_view);
        if (mStatusBarTopView !=null){
            ViewGroup.LayoutParams lp = mStatusBarTopView.getLayoutParams();
            lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
            lp.height = QMUIStatusBarHelper.getStatusbarHeight(mContext);
            mStatusBarTopView.setLayoutParams(lp);

        }
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
