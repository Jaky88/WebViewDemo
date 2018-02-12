package com.jack.demo.webviewdemo.cloud.service;

import com.jack.demo.webviewdemo.cloud.bean.LoginRequestBean;
import com.jack.demo.webviewdemo.cloud.bean.TaskBean;
import com.jack.demo.webviewdemo.cloud.bean.UserLoginResultBean;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by li on 2017/10/10.
 */

public interface ContentApi {


    @GET("/api/practice/{id}")
    Call<TaskBean> getTaskDetail(@Path(RetrofitManager.Practices.ID) int id);

    @POST("api/auth/login")
    Call<UserLoginResultBean> userLogin(@Body LoginRequestBean bean);
}
