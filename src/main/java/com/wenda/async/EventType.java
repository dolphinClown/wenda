package com.wenda.async;

/**
 /**
 * @Discription:
 *
 * 处理事件的类型
 * @Author: yanghao
 * @Date: 2018/4/10
 */
public enum EventType {
    LIKE(0),            //点赞
    COMMENT(1),         //评论
    LOGIN(2),           //登录
    MAIL(3),            //发邮件
    FOLLOW(4),          //关注
    UNFOLLOW(5),        //取消关注
    ADD_QUESTION(6);    //提问

    private int value;
    EventType(int value) { this.value = value; }
    public int getValue() { return value; }
}
