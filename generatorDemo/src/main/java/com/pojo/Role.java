package com.pojo;

public class Role {
    private Integer id;

    private Integer userId;

    private Integer roleType;

    private Integer userInfoId;

    public Role(Integer id, Integer userId, Integer roleType, Integer userInfoId) {
        this.id = id;
        this.userId = userId;
        this.roleType = roleType;
        this.userInfoId = userInfoId;
    }

    public Role() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }
}