package com.jack.demo.webviewdemo.cloud.service;

import com.jack.demo.webviewdemo.cloud.bean.dr.AuthToken;
import com.jack.demo.webviewdemo.cloud.bean.dr.BaseAuthAccount;
import com.jack.demo.webviewdemo.cloud.bean.dr.IndexService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by jaky on 2018/2/12 0012.
 */

public interface IDrService {

    String CONTENT_AUTH_PREFIX = "Bearer ";

    @GET("devices/findByMac")
    Call<IndexService> getIndexService(@Query("mac") final String macAddress,
                                       @Query("installationId") final String installationId,
                                       @Query("model") final String model);

    @POST("auth/local")
    Call<AuthToken> getAccountToken(@Body final BaseAuthAccount account);

    @GET("users/me")
    Call<ResponseBody> getAccount();
}
