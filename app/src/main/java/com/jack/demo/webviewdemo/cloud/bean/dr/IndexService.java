package com.jack.demo.webviewdemo.cloud.bean.dr;

import com.jaky.utils.StringUtils;

/**
 * Created by jaky on 2018/2/12 0012.
 */

public class IndexService {
    public String model;
    public String mac;
    public String username;
    public String installationId;
    public Server server;

    public static boolean hasValidServer(IndexService service) {
        return service != null && service.server != null &&
                (StringUtils.isNotBlank(service.server.ip) || StringUtils.isNotBlank(service.server.domain));
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj == null || !(obj instanceof IndexService)) {
            return false;
        }
        Server targetServer = ((IndexService) obj).server;
        if (targetServer == null) {
            return false;
        }
        return server.getApiBase().equals(targetServer.getApiBase());
    }
}
