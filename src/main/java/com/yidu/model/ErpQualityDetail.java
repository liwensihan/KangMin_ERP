package com.yidu.model;

public class ErpQualityDetail {
    private String qdetId;

    private String quaId;

    private String rawId;

    private String kinId;

    private Integer qdetGood;

    private Integer qdetBab;

    private String remark;

    private String createtime;

    public String getQdetId() {
        return qdetId;
    }

    public void setQdetId(String qdetId) {
        this.qdetId = qdetId == null ? null : qdetId.trim();
    }

    public String getQuaId() {
        return quaId;
    }

    public void setQuaId(String quaId) {
        this.quaId = quaId == null ? null : quaId.trim();
    }

    public String getRawId() {
        return rawId;
    }

    public void setRawId(String rawId) {
        this.rawId = rawId == null ? null : rawId.trim();
    }

    public String getKinId() {
        return kinId;
    }

    public void setKinId(String kinId) {
        this.kinId = kinId == null ? null : kinId.trim();
    }

    public Integer getQdetGood() {
        return qdetGood;
    }

    public void setQdetGood(Integer qdetGood) {
        this.qdetGood = qdetGood;
    }

    public Integer getQdetBab() {
        return qdetBab;
    }

    public void setQdetBab(Integer qdetBab) {
        this.qdetBab = qdetBab;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}