package com.pojo;

import java.util.Date;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-10-11 11:51
 **/
public class WalletOrderDetail extends WalletOrder  {
    public WalletOrderDetail(Integer id, Double money, String img, String desp, Integer type, Integer status, Date createDate, Integer wId) {
        super(id, money, img, desp, type, status, createDate, wId);
    }

    public WalletOrderDetail() {
    }

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
