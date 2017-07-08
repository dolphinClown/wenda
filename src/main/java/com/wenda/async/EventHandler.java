package com.wenda.async;

import java.util.List;

/**
 * Created by CLAY on 2017/3/20.
 * 接口 ，用来处理 Event
 */
public interface EventHandler {
    void doHandle(EventModel model);

    // 注册 Event ，当集合中 Event 发生时调用 doHandler 处理
    List<EventType> getSupportEventTypes();
}
