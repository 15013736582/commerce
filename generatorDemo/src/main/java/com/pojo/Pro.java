package com.pojo;

public class Pro {
    private Integer id;

    private String title;

    private Double price;

    private String reverse;

    private String sku;

    private String img;

    private String status;

    private Integer mId;

    private Integer shelf;

    public Pro(Integer id, String title, Double price, String reverse, String sku, String img, String status, Integer mId, Integer shelf) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.reverse = reverse;
        this.sku = sku;
        this.img = img;
        this.status = status;
        this.mId = mId;
        this.shelf = shelf;
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
}