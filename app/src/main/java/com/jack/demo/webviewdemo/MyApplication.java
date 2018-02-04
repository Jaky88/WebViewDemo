package com.jack.demo.webviewdemo;

import android.app.Application;

import com.jaky.utils.PreferenceUtils;


/**
 * Created by hehai on 17-9-29.
 */

public class MyApplication extends Application {
    private static MyApplication instance;
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }


    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initContext();
        PreferenceUtils.init(getApplicationContext());

    }

    private void initContext() {
        instance = this;
    }
}
