package com.pojo;

public class BroOrder {
    private Integer id;

    private String title;

    private Double price;

    private Integer qty;

    private String sku;

    private String total;

    private Integer wish;

    private Integer isPay;

    private Integer uId;

    public BroOrder(Integer id, String title, Double price, Integer qty, String sku, String total, Integer wish, Integer isPay, Integer uId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.qty = qty;
        this.sku = sku;
        this.total = total;
        this.wish = wish;
        this.isPay = isPay;
        this.uId = uId;
    }

    public BroOrder() {
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total == null ? null : total.trim();
    }

    public Integer getWish() {
        return wish;
    }

    public void setWish(Integer wish) {
        this.wish = wish;
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
}