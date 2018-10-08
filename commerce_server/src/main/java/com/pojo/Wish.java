package com.pojo;

import java.util.Date;

public class Wish {
    private Integer id;

    private Integer userId;

    private Integer proId;

    private Date createDate;

    public Wish(Integer id, Integer userId, Integer proId, Date createDate) {
        this.id = id;
        this.userId = userId;
        this.proId = proId;
        this.createDate = createDate;
    }

    public Wish() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}