package com.pojo;

public class Dic {
    private Integer id;

    private String type;

    private String desp;

    private Integer code;

    private String value;

    public Dic(Integer id, String type, String desp, Integer code, String value) {
        this.id = id;
        this.type = type;
        this.desp = desp;
        this.code = code;
        this.value = value;
    }

    public Dic() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp == null ? null : desp.trim();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}