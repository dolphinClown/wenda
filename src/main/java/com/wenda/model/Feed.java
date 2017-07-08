package com.wenda.model;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * Created by CLAY on 2017/3/10.
 */
public class Feed {
    private int id;
    private int type;   //类型
    private int userId; //来自某人
    private Date createdDate;   //发布时间
    private String data;        //JSON格式存储，新鲜事数据
    private JSONObject dataJSON = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        dataJSON = JSONObject.parseObject(data);
    }
    public String get(String key) {
        return dataJSON == null ? null : dataJSON.getString(key);
    }
}
