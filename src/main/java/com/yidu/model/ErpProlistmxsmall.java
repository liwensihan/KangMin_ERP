package com.yidu.model;

import java.math.BigDecimal;
import java.util.Date;

public class ErpProlistmxsmall {
    private String fdprolistmxId;

    private String fdproId;

    private String kinId;

    private String fdprolistmxNumber;

    private BigDecimal fdprolistmxMoney;

    private Integer fdprolistmxCount;

    private Date fdprolistmxTime;

    private String remark;

    private String isva;

    public String getFdprolistmxId() {
        return fdprolistmxId;
    }

    public void setFdprolistmxId(String fdprolistmxId) {
        this.fdprolistmxId = fdprolistmxId == null ? null : fdprolistmxId.trim();
    }

    public String getFdproId() {
        return fdproId;
    }

    public void setFdproId(String fdproId) {
        this.fdproId = fdproId == null ? null : fdproId.trim();
    }

    public String getKinId() {
        return kinId;
    }

    public void setKinId(String kinId) {
        this.kinId = kinId == null ? null : kinId.trim();
    }

    public String getFdprolistmxNumber() {
        return fdprolistmxNumber;
    }

    public void setFdprolistmxNumber(String fdprolistmxNumber) {
        this.fdprolistmxNumber = fdprolistmxNumber == null ? null : fdprolistmxNumber.trim();
    }

    public BigDecimal getFdprolistmxMoney() {
        return fdprolistmxMoney;
    }

    public void setFdprolistmxMoney(BigDecimal fdprolistmxMoney) {
        this.fdprolistmxMoney = fdprolistmxMoney;
    }

    public Integer getFdprolistmxCount() {
        return fdprolistmxCount;
    }

    public void setFdprolistmxCount(Integer fdprolistmxCount) {
        this.fdprolistmxCount = fdprolistmxCount;
    }

    public Date getFdprolistmxTime() {
        return fdprolistmxTime;
    }

    public void setFdprolistmxTime(Date fdprolistmxTime) {
        this.fdprolistmxTime = fdprolistmxTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getIsva() {
        return isva;
    }

    public void setIsva(String isva) {
        this.isva = isva == null ? null : isva.trim();
    }
}