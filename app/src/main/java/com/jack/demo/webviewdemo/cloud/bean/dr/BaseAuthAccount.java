package com.jack.demo.webviewdemo.cloud.bean.dr;

/**
 * Created by jaky on 2018/2/12 0012.
 */

public class BaseAuthAccount {
    public String username;
    public String password;

    public static BaseAuthAccount create(String username, String password) {
        BaseAuthAccount account = new BaseAuthAccount();
        account.username = username;
        account.password = password;
        return account;
    }
}
