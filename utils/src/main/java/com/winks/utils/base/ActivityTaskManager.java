package com.winks.utils.base;

import android.app.Activity;

import java.util.List;
import java.util.Stack;

/**
 * 创建时间: 2018/8/17
 * 作者: JinzhiHou
 * E-mail: 605322850@qq.com
 * Blog: www.xiaohoutongxue.cn
 * 描述: ActivityTaskManager  activity管理器
 **/
public class ActivityTaskManager {

    private static Stack<Activity> activityStack = new Stack<>();

    /**
     * 获取Activity栈数量
     */
    public static int getActivitySize() {
        return activityStack.size();
    }

    /**
     * 添加Activity到堆栈
     */
    public static void addActivity(Activity activity) {
        activityStack.push(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public static Activity currentActivity() {
        return activityStack.lastElement();
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public static void finishCurrentActivity() {
        Activity activity = activityStack.pop();
        activity.finish();
    }

    /**
     * 结束指定的Activity
     */
    public static void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    /**
     * 移除指定的Activity
     */
    public static void removeActivity(BaseActivity activity) {
        if (activity != null) {
            activityStack.remove(activity);
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public static void finishActivity(Class<?> cls) {
        finishActivity(getActivity(cls));
    }

    /**
     * 获取指定类名的Activity
     */
    public static Activity getActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                return activity;
            }
        }
        return null;
    }

    /**
     * 结束所有Activity
     */
    public static void finishAllActivity() {
        for (Activity activity : activityStack) {
            if (activity != null) {
                activity.finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 结束除指定Activity之外的所有Activity
     */
    public static void finishAllActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity != null) {
                if (!activity.getClass().equals(cls)) {
                    activity.finish();
                }
            }
        }
    }

    /**
     * 结束批量Activity
     *
     * @param activities
     */
    public static void finishActivitys(List<Class> activities) {
        if (activities == null) {
            return;
        }
        if (activities.size() == 0) {
            return;
        }
        for (Class c : activities) {
            if (getActivity(c) != null) {
                finishActivity(c);
            }
        }
    }
}
