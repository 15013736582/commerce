package com.pojo;

public class Store {
    private Integer id;

    private Integer bId;

    private String name;

    private Integer platform;

    public Store(Integer id, Integer bId, String name, Integer platform) {
        this.id = id;
        this.bId = bId;
        this.name = name;
        this.platform = platform;
    }

    public Store() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }
}