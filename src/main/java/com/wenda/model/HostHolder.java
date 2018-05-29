package com.wenda.model;

import org.springframework.stereotype.Component;

/**
 * @Discription:
 * @Author: yanghao
 * @Date: 2018/3/13
 */
@Component
public class HostHolder {
    private static ThreadLocal<User> users = new ThreadLocal<User>();

    public User getUser() {
        return users.get();
    }

    public void setUser(User user) {
        users.set(user);
    }

    public void clear() {
        users.remove();
    }
}
