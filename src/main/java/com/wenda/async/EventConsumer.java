package com.wenda.async;

import com.alibaba.fastjson.JSON;
import com.wenda.util.JedisAdapter;
import com.wenda.util.RedisKeyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Discription:
 * 处理队列中的 Event，与 EventHandler 连接起来
 *
 * @Author: yanghao
 * @Date: 2018/4/10
 */
@Service
public class EventConsumer implements InitializingBean, ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(EventConsumer.class);
    //从队列中取出 EventModel ，查看它的 EventType ，并根据类型，找到要处理的一批 EventHandler 的实现类。
    private Map<EventType, List<EventHandler>> config = new HashMap<EventType, List<EventHandler>>();
    private ApplicationContext applicationContext;

    @Autowired
    JedisAdapter jedisAdapter;

    //初始化 config
    @Override
    public void afterPropertiesSet() throws Exception {
        //从上下文中找到 实现 EventHandler 接口实现类
        Map<String, EventHandler> beans = applicationContext.getBeansOfType(EventHandler.class);
        if (beans != null) {
            for (Map.Entry<String, EventHandler> entry : beans.entrySet()) {
                //得到 实现 EventHandler 接口的类 对应处理事件的集合，比如：LikeHandler 处理 “赞踩” 事件
                List<EventType> eventTypes = entry.getValue().getSupportEventTypes();

                for (EventType type : eventTypes) {
                    //如果是第一次注册该事件
                    if (!config.containsKey(type)) {
                        //创建 EventHandler 集合 ，这样以后就可以方便的扩展
                        config.put(type, new ArrayList<EventHandler>());
                    }
                    //将事件添加到 EventHandler 集合中
                    config.get(type).add(entry.getValue());
                }
            }
        }

        //开启一个任务处理线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    String key = RedisKeyUtil.getEventQueueKey();
                    //从缓存队列尾部取出一个任务（这里是任务 EventModel 的序列化 JSON 串）
                    List<String> events = jedisAdapter.brpop(0, key);

                    for (String message : events) {
                        //events 中第一个值可能就是 key 所以要过滤掉它
                        if (message.equals(key)) {
                            continue;
                        }

                        EventModel eventModel = JSON.parseObject(message, EventModel.class);
                        if (!config.containsKey(eventModel.getType())) {
                            logger.error("不能识别的事件");
                            continue;
                        }

                        for (EventHandler handler : config.get(eventModel.getType())) {
                            //处理事件
                            handler.doHandle(eventModel);
                        }
                    }
                }
            }
        });
        thread.start();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
