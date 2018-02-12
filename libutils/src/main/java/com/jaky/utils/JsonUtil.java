package com.jaky.utils;

import android.text.TextUtils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.alibaba.fastjson.JSON.parseObject;


/**
 * Created by jaky on 2017/9/8 0008.
 */

public class JsonUtil {

    public static String objectToJson(Object object) {
        if (object == null) {
            return "";
        }
        try {
            return JSON.toJSONString(object);
        } catch (JSONException e) {
        } catch (Exception e) {
        }
        return "";
    }

    public static <T> T jsonToObject(String jsonData, Class<T> clazz) {
        if (TextUtils.isEmpty(jsonData)) {
            return null;
        }
        try {
            return parseObject(jsonData, clazz);
        } catch (Exception e) {
        }
        return null;
    }

    public static List jsonToList(String jsonData) {
        if (TextUtils.isEmpty(jsonData)) {
            return null;
        }
        List arrayList = null;
        try {
            arrayList = parseObject(jsonData, new TypeReference<ArrayList>() {
            });
        } catch (Exception e) {
        }
        return arrayList;

    }

    public static Map jsonToMap(String jsonData) {
        if (TextUtils.isEmpty(jsonData)) {
            return null;
        }
        Map map = null;
        try {
            map = parseObject(jsonData, new TypeReference<Map>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static <T> T parseObject(String json, Class<T> cls, Feature... features) {
        try {
            return JSON.parseObject(json, cls, features);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static public <T> T parseObject(String json, TypeReference<T> typeReference, Feature... features) {
        try {
            return JSON.parseObject(json, typeReference, features);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T toBean(byte[] json, Class<T> type) {
        T obj = null;
        try {
            String info = new String(json, "UTF-8");
            obj = JSON.parseObject(info, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static <T> T toBean(byte[] json, Type type) {
        T obj = null;
        try {
            String info = new String(json, "UTF-8");
            obj = JSON.parseObject(info, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static <T> T toBean(String json, Type type) {
        T obj;
        obj = JSON.parseObject(json, type);
        return obj;
    }

    public static String toJson(Object object) {
        String result = JSON.toJSONString(object);
        return result;
    }

    public static <T> List<T> toList(String json, Type type){
        List<T> list = JSON.parseObject(json, type);
        return list;
    }
}
