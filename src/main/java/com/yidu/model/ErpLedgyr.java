package com.yidu.model;

import java.math.BigDecimal;

public class ErpLedgyr {
    private String gyrId;

    private String fdproId;

    private String saleId;

    private String annexId;

    private String gyrSreial;

    private BigDecimal gyrPrice;

    private String remark;

    private String creater;

    private String createtime;

    private Integer isva;

    public String getGyrId() {
        return gyrId;
    }

    public void setGyrId(String gyrId) {
        this.gyrId = gyrId == null ? null : gyrId.trim();
    }

    public String getFdproId() {
        return fdproId;
    }

    public void setFdproId(String fdproId) {
        this.fdproId = fdproId == null ? null : fdproId.trim();
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId == null ? null : saleId.trim();
    }

    public String getAnnexId() {
        return annexId;
    }

    public void setAnnexId(String annexId) {
        this.annexId = annexId == null ? null : annexId.trim();
    }

    public String getGyrSreial() {
        return gyrSreial;
    }

    public void setGyrSreial(String gyrSreial) {
        this.gyrSreial = gyrSreial == null ? null : gyrSreial.trim();
    }

    public BigDecimal getGyrPrice() {
        return gyrPrice;
    }

    public void setGyrPrice(BigDecimal gyrPrice) {
        this.gyrPrice = gyrPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public Integer getIsva() {
        return isva;
    }

    public void setIsva(Integer isva) {
        this.isva = isva;
    }
}