package com.wenda.model;

import java.util.Date;

/**
 * @Discription:
 * @Author: yanghao
 * @Date: 2018/3/13
 */
public class LoginTicket {
    private int id;
    private int userId;
    private Date expired;   //过期时间
    private int status;     // 0有效，1无效
    private String ticket;  //用户登录唯一身份凭证

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
