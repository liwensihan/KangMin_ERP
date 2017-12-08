package com.yidu.model;

public class ErpPactType {
    private String patypeId;

    private String patypeSreial;

    private String patypeName;

    private String remark;

    private String cratenr;

    private String creater;

    private Integer isva;

    public String getPatypeId() {
        return patypeId;
    }

    public void setPatypeId(String patypeId) {
        this.patypeId = patypeId == null ? null : patypeId.trim();
    }

    public String getPatypeSreial() {
        return patypeSreial;
    }

    public void setPatypeSreial(String patypeSreial) {
        this.patypeSreial = patypeSreial == null ? null : patypeSreial.trim();
    }

    public String getPatypeName() {
        return patypeName;
    }

    public void setPatypeName(String patypeName) {
        this.patypeName = patypeName == null ? null : patypeName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCratenr() {
        return cratenr;
    }

    public void setCratenr(String cratenr) {
        this.cratenr = cratenr == null ? null : cratenr.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Integer getIsva() {
        return isva;
    }

    public void setIsva(Integer isva) {
        this.isva = isva;
    }
}