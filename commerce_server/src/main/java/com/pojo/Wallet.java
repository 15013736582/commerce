package com.pojo;

import java.util.Date;

public class Wallet {
    private Integer id;

    private String username;

    private String password;

    private Double money;

    private Date createDate;

    public Wallet(Integer id, String username, String password, Double money, Date createDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.money = money;
        this.createDate = createDate;
    }

    public Wallet() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}