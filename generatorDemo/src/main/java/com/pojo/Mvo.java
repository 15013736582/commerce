package com.pojo;

public class Mvo {
    private Integer id;

    private String cName;

    private String eName;

    private String introduce;

    private String reportType;

    private String reportUrl;

    private String email;

    public Mvo(Integer id, String cName, String eName, String introduce, String reportType, String reportUrl, String email) {
        this.id = id;
        this.cName = cName;
        this.eName = eName;
        this.introduce = introduce;
        this.reportType = reportType;
        this.reportUrl = reportUrl;
        this.email = email;
    }

    public Mvo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType == null ? null : reportType.trim();
    }

    public String getReportUrl() {
        return reportUrl;
    }

    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl == null ? null : reportUrl.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}