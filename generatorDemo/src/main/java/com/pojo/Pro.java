package com.pojo;

import java.util.Date;

public class Pro {
    private Integer id;

    private String title;

    private Double price;

    private Integer type;

    private String reverse;

    private String sku;

    private String img;

    private String desp;

    private String status;

    private Integer mId;

    private Integer shelf;

    private Date addDate;

    public Pro(Integer id, String title, Double price, Integer type, String reverse, String sku, String img, String desp, String status, Integer mId, Integer shelf, Date addDate) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.type = type;
        this.reverse = reverse;
        this.sku = sku;
        this.img = img;
        this.desp = desp;
        this.status = status;
        this.mId = mId;
        this.shelf = shelf;
        this.addDate = addDate;
    }

    public Pro() {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getReverse() {
        return reverse;
    }

    public void setReverse(String reverse) {
        this.reverse = reverse == null ? null : reverse.trim();
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getShelf() {
        return shelf;
    }

    public void setShelf(Integer shelf) {
        this.shelf = shelf;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
}