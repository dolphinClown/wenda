package com.wenda.async;

import com.alibaba.fastjson.JSONObject;
import com.wenda.util.JedisAdapter;
import com.wenda.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by CLAY on 2017/3/20.
 */
@Service
public class EventProducer {
    @Autowired
    JedisAdapter jedisAdapter;

    //将事件放入队列（使用 redis 的 list 数据类型）
    public boolean fireEvent(EventModel eventModel) {
        try {
            String json = JSONObject.toJSONString(eventModel);
            String key = RedisKeyUtil.getEventQueueKey();
            jedisAdapter.lpush(key, json);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
