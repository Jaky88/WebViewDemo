package com.jack.demo.webviewdemo.observerble;

import com.jack.demo.webviewdemo.cloud.bean.LoginRequestBean;
import com.jack.demo.webviewdemo.cloud.bean.UserLoginResultBean;
import com.jack.demo.webviewdemo.cloud.service.RetrofitManager;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by Jack on 2018/2/3.
 */

public class ObserverbleFactory {

    public static Observable getLoginObserverble(final LoginRequestBean requestBean){
        return Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter e) throws Exception {
                Response<UserLoginResultBean> response = RetrofitManager.getSunService().userLogin(requestBean).execute();
                if (response.isSuccessful()) {
                    UserLoginResultBean resultBean = response.body();
                    e.onNext(resultBean);
                } else {
                    String error = response.errorBody().string();
                    e.onError(new Exception(error));
                }
                e.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
