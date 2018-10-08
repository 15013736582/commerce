package com.pojo;

import java.util.Date;

public class MvoOrder {
    private Integer id;

    private String title;

    private Double price;

    private String number;

    private Integer uId;

    private Date createDate;

    public MvoOrder(Integer id, String title, Double price, String number, Integer uId, Date createDate) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.number = number;
        this.uId = uId;
        this.createDate = createDate;
    }

    public MvoOrder() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}