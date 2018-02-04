package com.jack.demo.webviewdemo.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.umeng.analytics.MobclickAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int viewId = getViewId();
        ViewDataBinding binding = DataBindingUtil.setContentView(this, viewId);
        EventBus.getDefault().register(this);
        initData();
        initView(binding);
        initListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void OnObjectEvent(Object event) {
    }

    protected abstract void initData();

    protected abstract void initView(ViewDataBinding binding);

    protected abstract void initListener();

    protected abstract int getViewId();
}
