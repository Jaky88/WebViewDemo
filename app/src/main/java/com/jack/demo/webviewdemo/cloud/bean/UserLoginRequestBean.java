package com.jack.demo.webviewdemo.cloud.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by jackdeng on 2017/10/21.
 */

public class UserLoginRequestBean extends BaseObservable{
    public String account = "1701000030";
    public String password = "123456";
    public boolean isKeepPassword;
    public boolean isShowPassword;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
        notifyChange();
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyChange();
    }

    @Bindable
    public boolean getIsKeepPassword() {
        return isKeepPassword;
    }

    public void setIsKeepPassword(boolean isKeepPassword) {
        this.isKeepPassword = isKeepPassword;
        notifyChange();
    }

    public boolean isShowPassword() {
        return isShowPassword;
    }

    public void setShowPassword(boolean showPassword) {
        isShowPassword = showPassword;
        notifyChange();
    }
}
