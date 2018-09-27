package com.pojo;

public class Bvo {
    private Integer id;

    private String email;

    private String phone;

    private String aName;

    private String aPassword;

    public Bvo(Integer id, String email, String phone, String aName, String aPassword) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.aName = aName;
        this.aPassword = aPassword;
    }

    public Bvo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName == null ? null : aName.trim();
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword == null ? null : aPassword.trim();
    }
}