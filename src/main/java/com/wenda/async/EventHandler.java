package com.wenda.async;

import java.util.List;

/**
 * @Discription:
 * 接口 ，用来处理 Event
 *
 * @Author: yanghao
 * @Date: 2018/4/20
 */
public interface EventHandler {
    void doHandle(EventModel model);

    // 注册 Event ，当集合中 Event 发生时调用 doHandler 处理
    List<EventType> getSupportEventTypes();
}
