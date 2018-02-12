package com.jack.demo.webviewdemo.activity.presenter;


import com.jack.demo.webviewdemo.activity.viewinterface.UserLoginView;
import com.jack.demo.webviewdemo.cloud.bean.LoginRequestBean;
import com.jack.demo.webviewdemo.cloud.bean.UserLoginResultBean;
import com.jack.demo.webviewdemo.cloud.service.RetrofitManager;
import com.jack.demo.webviewdemo.observerble.ObserverbleFactory;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by jackdeng on 2017/10/23.
 */

public class UserLoginPresenter {
    private UserLoginView loginView;

    public UserLoginPresenter(UserLoginView loginView) {
        this.loginView = loginView;
    }

    public void loginAccount(String account, String password) {
        LoginRequestBean requestBean = new LoginRequestBean();
        requestBean.username = account;
        requestBean.password = password;
        ObserverbleFactory.getLoginObserverble(requestBean).subscribe(new Observer<UserLoginResultBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(UserLoginResultBean resultBean) {
                if (resultBean == null) {
                    return;
                }
                if (resultBean.code == RetrofitManager.HttpReusltCode.RESULT_CODE_SUCCESS) {
                    loginView.onLoginSucceed(resultBean.data);
                } else {
                    loginView.onLoginFailed(resultBean.code, resultBean.msg);
                }
            }

            @Override
            public void onError(Throwable e) {
                if (e != null) {
                    loginView.onLoginException(e);
                }
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
