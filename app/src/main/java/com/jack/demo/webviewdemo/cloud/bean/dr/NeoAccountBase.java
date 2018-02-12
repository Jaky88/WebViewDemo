package com.jack.demo.webviewdemo.cloud.bean.dr;

import com.alibaba.fastjson.annotation.JSONField;
import com.jack.demo.webviewdemo.cloud.bean.dr.AccountCommon;
import com.jaky.utils.CollectionUtils;
import com.jaky.utils.JsonUtil;
import com.jaky.utils.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by suicheng on 2017/5/18.
 */
public class NeoAccountBase {

    public static final String DELIMITER = ",";

    public String name;
    public String orgName;
    public List<String> groups;

    public String token;
    public long tokenExpiresIn; //unit s
    public String phone;

    public String info;
    public String library;

    @JSONField(serialize = false, deserialize = false)
    public String getFirstGroup() {
        if(CollectionUtils.isNullOrEmpty(groups)) {
            return "";
        }
        return groups.get(0).replaceAll(DELIMITER, "");
    }

    public String getPhone() {
        return StringUtils.getBlankStr(phone);
    }

    public String getName() {
        return StringUtils.getBlankStr(name);
    }

    @JSONField(serialize = false, deserialize = false)
    public static boolean isValid(NeoAccountBase account) {
        return account != null && StringUtils.isNotBlank(account.token);
    }

//    @JSONField(serialize = false, deserialize = false)
//    public boolean isTokenTimeExpired() {
//        if (getCreatedAt() == null) {
//            return true;
//        }
//        return getCreatedAt().getTime() + getTokenExpiresIn() < new Date().getTime();
//    }

    public long getTokenExpiresIn() {
        return tokenExpiresIn * 1000;
    }

    public static void parseName(NeoAccountBase account) {
        if (account != null) {
            AccountCommon common = JsonUtil.parseObject(account.info, AccountCommon.class);
            if (common != null) {
                account.name = common.name;
            }
        }
    }
}
