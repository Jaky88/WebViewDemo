package com.jack.demo.webviewdemo.utils;

import android.widget.Toast;

import com.jack.demo.webviewdemo.MyApplication;

/**
 * Created by li on 2017/9/30.
 */

public class CommonNotices {
    public static void show(String message) {
        Toast.makeText(MyApplication.getInstance(), message, Toast.LENGTH_LONG).show();
    }
}
