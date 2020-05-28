package com.winks.utils.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.trello.rxlifecycle3.components.support.RxFragment;
import com.winks.utils.R;
import com.winks.utils.event.Event;
import com.winks.utils.event.EventBusUtlis;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends RxFragment {
    private View mView;
    private Activity mActivity;
    public Context mContext;
    private Unbinder mUnBinder;
    private LayoutInflater mInflater;
    protected boolean isInit = false;
    public boolean isVisible;
    public boolean isPrepared;
    public static final String TYPE_NAME = "type_name";
    private View mStatusBarTopView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutID(), null);
        isInit = true;
        initStatusBarTopView(mView);
        return mView;
    }

    /**
     * 初始化顶部View
     * @param mView
     */
    private void initStatusBarTopView(View mView) {
        mStatusBarTopView = mView.findViewById(R.id.status_bar_top_bar_view);
        if (mStatusBarTopView !=null){
            ViewGroup.LayoutParams lp = mStatusBarTopView.getLayoutParams();
            lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
            lp.height = QMUIStatusBarHelper.getStatusbarHeight(mContext);
            mStatusBarTopView.setLayoutParams(lp);
        }
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
        mUnBinder = ButterKnife.bind(this, view);
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

    /**
     * 是否注册事件分发
     *
     * @return true绑定EventBus事件分发，默认不绑定，子类需要绑定的话复写此方法返回true.
     */
    protected boolean isRegisterEventBus() {
        return false;
    }
    @Override
    public void onStart() {
        super.onStart();
        if (isRegisterEventBus()) {
            EventBusUtlis.register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (isRegisterEventBus()) {
            EventBusUtlis.unregister(this);
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBusCome(Event event) {
        if (event != null) {
            receiveEvent(event);
        }
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

    @Override
    public void onDestroyView() {
        isPrepared = false;
        removePresenter();
        mUnBinder.unbind();
        super.onDestroyView();
    }

    protected void initPresenter() {

    }

    protected void removePresenter() {
    }

}
