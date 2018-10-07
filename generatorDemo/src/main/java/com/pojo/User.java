package com.pojo;

import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private String password;

    private Integer role;

    private Date addDate;

    private Integer sex;

    private String token;

    private Integer walletId;

    public User(Integer id, String username, String password, Integer role, Date addDate, Integer sex, String token, Integer walletId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.addDate = addDate;
        this.sex = sex;
        this.token = token;
        this.walletId = walletId;
    }

    public User() {
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }
}