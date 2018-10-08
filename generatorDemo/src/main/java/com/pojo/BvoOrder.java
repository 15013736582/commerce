package com.pojo;

import java.util.Date;

public class BvoOrder {
    private Integer id;

    private String title;

    private Double price;

    private Integer qty;

    private Integer isPay;

    private Integer uId;

    private Date createDate;

    public BvoOrder(Integer id, String title, Double price, Integer qty, Integer isPay, Integer uId, Date createDate) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.qty = qty;
        this.isPay = isPay;
        this.uId = uId;
        this.createDate = createDate;
    }

    public BvoOrder() {
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

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
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