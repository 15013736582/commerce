package com.pojo;

import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String nickname;

    private Integer sex;

    private Integer walletId;

    private String token;

    private Date addDate;

    public User(Integer id, String username, String password, String nickname, Integer sex, Integer walletId, String token, Date addDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.sex = sex;
        this.walletId = walletId;
        this.token = token;
        this.addDate = addDate;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
}