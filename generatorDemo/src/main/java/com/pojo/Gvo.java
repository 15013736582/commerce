package com.pojo;

public class Gvo {
    private Integer id;

    private String nickname;

    public Gvo(Integer id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public Gvo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }
}