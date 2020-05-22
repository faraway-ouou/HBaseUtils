package com.winks.base_utils.request.manager;

import com.bitewj.wjq.ui.base.mvp.BaseView;
import com.trello.rxlifecycle3.LifecycleTransformer;
import com.trello.rxlifecycle3.android.ActivityEvent;
import com.trello.rxlifecycle3.android.FragmentEvent;
import com.trello.rxlifecycle3.components.RxDialogFragment;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle3.components.support.RxAppCompatDialogFragment;
import com.trello.rxlifecycle3.components.support.RxFragment;
import com.trello.rxlifecycle3.components.support.RxFragmentActivity;

/**
 * RxLifeCycle 工具类
 */
public class RxLifeCycleUtils {
    /**
     * RxLifeCycle绑定RxJava的生命周期
     *
     * @param baseView activity 或fragment继承的接口view
     * @param <L>      RxJava数据泛型
     * @return
     */
    public static <L> LifecycleTransformer<L> bindToLifecycle(BaseView baseView) {
        if (baseView != null) {
            if (baseView instanceof RxAppCompatActivity) {
                return ((RxAppCompatActivity) baseView).bindToLifecycle();
            } else if (baseView instanceof RxFragmentActivity) {
                return ((RxFragmentActivity) baseView).bindToLifecycle();
            } else if (baseView instanceof RxFragment) {
                return ((RxFragment) baseView).bindToLifecycle();
            } else if (baseView instanceof RxDialogFragment) {
                return ((RxDialogFragment) baseView).bindToLifecycle();
            } else if (baseView instanceof RxAppCompatDialogFragment) {
                return ((RxAppCompatDialogFragment) baseView).bindToLifecycle();
            } else {
                throw new IllegalArgumentException("view isn't activity or fragment");
            }
        } else {
            throw new IllegalArgumentException("view is null");
        }
    }

    /**
     * RxLifeCycle绑定RxJava的生命周期 ，支持指定某个生命周期
     *
     * @param baseView activity 继承的接口view
     * @param event    activity的生命周期
     * @param <L>      RxJava数据泛型
     * @return
     */
    public static <L> LifecycleTransformer<L> bindUntilEvent(BaseView baseView, ActivityEvent event) {
        if (baseView != null) {
            if (baseView instanceof RxAppCompatActivity) {
                return ((RxAppCompatActivity) baseView).bindUntilEvent(event);
            } else if (baseView instanceof RxFragmentActivity) {
                return ((RxFragmentActivity) baseView).bindUntilEvent(event);
            } else {
                throw new IllegalArgumentException("view isn't activity");
            }
        } else {
            throw new IllegalArgumentException("view is null");
        }
    }

    /**
     * RxLifeCycle绑定RxJava的生命周期，支持指定某个生命周期
     *
     * @param baseView fragment继承的接口view
     * @param event    fragment的生命周期
     * @param <L>      RxJava数据泛型
     * @return
     */
    public static <L> LifecycleTransformer<L> bindUntilEvent(BaseView baseView, FragmentEvent event) {
        if (baseView != null) {
            if (baseView instanceof RxFragment) {
                return ((RxFragment) baseView).bindUntilEvent(event);
            } else if (baseView instanceof RxDialogFragment) {
                return ((RxDialogFragment) baseView).bindUntilEvent(event);
            } else if (baseView instanceof RxAppCompatDialogFragment) {
                return ((RxAppCompatDialogFragment) baseView).bindUntilEvent(event);
            } else {
                throw new IllegalArgumentException("view isn't  fragment");
            }
        } else {
            throw new IllegalArgumentException("view is null");
        }
    }
}
