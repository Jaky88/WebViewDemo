package com.jack.demo.webviewdemo.cloud.bean.dr;

import com.jaky.utils.StringUtils;

/**
 * Created by jaky on 2018/2/12 0012.
 */

public class Server {
    public String name;
    public String ip;
    public String domain;
    public String port;
    public String address;
    public String organization;

    public String getServerHost() {
        String host = "http://";
        if (StringUtils.isNotBlank(ip)) {
            host += ip;
        } else {
            host += domain;
        }
        if (StringUtils.isNotBlank(port)) {
            host += ":" + port;
        }
        return host + "/";
    }

    public String getApiBase() {
        return getServerHost() + "api/";
    }

}
