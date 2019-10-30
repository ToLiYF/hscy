package com.hscy.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: yongfa
 * Date: 2019/10/15 18:08
 * Desc: 返回数据
 */
public class ResultMap extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public ResultMap() {
        put("code", 0);
        put("msg", "success");
    }

    public static ResultMap error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static ResultMap error(String msg) {
        return error(500, msg);
    }

    public static ResultMap error(int code, String msg) {
        ResultMap r = new ResultMap();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static ResultMap ok(String msg) {
        ResultMap r = new ResultMap();
        r.put("msg", msg);
        return r;
    }

    public static ResultMap ok(Map<String, Object> map) {
        ResultMap r = new ResultMap();
        r.putAll(map);
        return r;
    }

    public static ResultMap ok() {
        return new ResultMap();
    }

    @Override
    public ResultMap put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
