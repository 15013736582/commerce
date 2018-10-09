package com.pojo;

import java.util.Date;

public class WishDetail extends Pro {

    public WishDetail(Integer id, String title, Double price, Integer type, String reverse, String sku, String img, String desp, Integer status, Integer mId, Integer shelf, Date addDate) {
        super(id, title, price, type, reverse, sku, img, desp, status, mId, shelf, addDate);
    }


    public WishDetail() {
    }
   private Wish wish;

    public Wish getWish() {
        return wish;
    }

    public void setWish(Wish wish) {
        this.wish = wish;
    }
}
