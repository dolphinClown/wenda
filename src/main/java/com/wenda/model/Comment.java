package com.wenda.model;

import java.util.Date;

/**
 * @Discription:
 * @Author: yanghao
 * @Date: 2018/3/27
 */
public class Comment {
    private int id;
    private int userId;
    private int entityId;   //评论或评论回复的 ID
    private int entityType; //类型:评论回复或评论
    private String content;
    private Date createdDate;
    private int status;     //评论状态，0表示有效，1表示评论无效，删除评论时将状态设置为1

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

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public int getEntityType() {
        return entityType;
    }

    public void setEntityType(int entityType) {
        this.entityType = entityType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
