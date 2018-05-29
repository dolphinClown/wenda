package com.wenda.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @Discription:
 * ViewObject 包装 POJO 方便传输数据到 Velocity
 *
 * @Author: yanghao
 * @Date: 2018/3/12
 */
public class ViewObject {
    private Map<String, Object> objs = new HashMap<String, Object>();
    public void set(String key, Object value) {
        objs.put(key, value);
    }

    public Object get(String key) {
        return objs.get(key);
    }
}
