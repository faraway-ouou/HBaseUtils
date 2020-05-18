package com.winks.demo;

import android.app.Application;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        LogUtils.getConfig()
//                .setLogSwitch(false)
                .setLogHeadSwitch(false)
                .setGlobalTag(getResources().getString(R.string.app_name))
                .setBorderSwitch(false);
    }
}
