package com.yidu.model;

import java.math.BigDecimal;

public class ErpKinordDetail {
    private String ordDetId;

    private String kinordId;

    private String kinId;

    private Integer ordNum;

    private BigDecimal ordPrice;

    private String remark;

    private String ceracer;

    private String ceracertime;

    public String getOrdDetId() {
        return ordDetId;
    }

    public void setOrdDetId(String ordDetId) {
        this.ordDetId = ordDetId == null ? null : ordDetId.trim();
    }

    public String getKinordId() {
        return kinordId;
    }

    public void setKinordId(String kinordId) {
        this.kinordId = kinordId == null ? null : kinordId.trim();
    }

    public String getKinId() {
        return kinId;
    }

    public void setKinId(String kinId) {
        this.kinId = kinId == null ? null : kinId.trim();
    }

    public Integer getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(Integer ordNum) {
        this.ordNum = ordNum;
    }

    public BigDecimal getOrdPrice() {
        return ordPrice;
    }

    public void setOrdPrice(BigDecimal ordPrice) {
        this.ordPrice = ordPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCeracer() {
        return ceracer;
    }

    public void setCeracer(String ceracer) {
        this.ceracer = ceracer == null ? null : ceracer.trim();
    }

    public String getCeracertime() {
        return ceracertime;
    }

    public void setCeracertime(String ceracertime) {
        this.ceracertime = ceracertime == null ? null : ceracertime.trim();
    }
}