package com.pineteree.twocheckboxdemo;

import android.app.Application;

import com.coder.zzq.smartshow.toast.SmartToast;

/**
 * Created by Administrator on 2018/1/17.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //使用默认布局的普通Toast
        SmartToast.plainToast(this);
    }
}
