package com.pojo;

public class Bvo {
    private Integer id;

    private String email;

    private String phone;

    public Bvo(Integer id, String email, String phone) {
        this.id = id;
        this.email = email;
        this.phone = phone;
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
}