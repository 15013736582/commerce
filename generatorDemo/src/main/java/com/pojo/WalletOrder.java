package com.pojo;

import java.util.Date;

public class WalletOrder {
    private Integer id;

    private Double money;

    private String img;

    private String desp;

    private Integer type;

    private Integer status;

    private Date createDate;

    private Integer wId;

    public WalletOrder(Integer id, Double money, String img, String desp, Integer type, Integer status, Date createDate, Integer wId) {
        this.id = id;
        this.money = money;
        this.img = img;
        this.desp = desp;
        this.type = type;
        this.status = status;
        this.createDate = createDate;
        this.wId = wId;
    }

    public WalletOrder() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp == null ? null : desp.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
    }
}