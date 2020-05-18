package com.winks.utils.event;

import org.greenrobot.eventbus.EventBus;

/**
 * 创建时间: 2018/7/16
 * 作者: JinzhiHou
 * E-mail: 605322850@qq.com
 * Blog: www.xiaohoutongxue.cn
 * 描述: EventBusUtlis
 **/
public class EventBusUtlis {
    /**
     * 注册
     * @param subscriber
     */
    public static void register(Object subscriber) {
        EventBus.getDefault().register(subscriber);
    }

    /**
     * 反注册
     * @param subscriber
     */
    public static void unregister(Object subscriber) {

        EventBus.getDefault().unregister(subscriber);
    }

    /**
     * 发送普通事件
     * @param event
     */
    public static void sendEvent(Event event) {
        EventBus.getDefault().post(event);
    }

    /**
     * 发送粘性事件
     * @param event
     */
    public static void sendStickyEvent(Event event) {
        EventBus.getDefault().postSticky(event);
    }

    /**
     * 移除粘性事件
     * @param event
     */
    public static void removeStickyEvent(Event event) {
        EventBus.getDefault().removeStickyEvent(event);
    }
}
