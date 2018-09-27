package com.pojo;

public class MOrderiItem {
    private Integer id;

    private Integer oId;

    private Integer pId;

    private Integer count;

    public MOrderiItem(Integer id, Integer oId, Integer pId, Integer count) {
        this.id = id;
        this.oId = oId;
        this.pId = pId;
        this.count = count;
    }

    public MOrderiItem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}