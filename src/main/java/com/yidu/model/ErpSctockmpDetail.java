package com.yidu.model;

import java.math.BigDecimal;

public class ErpSctockmpDetail {
    private String kmpId;

    private String saleId;

    private String kinId;

    private Integer kmpNum;

    private BigDecimal kmpPrice;

    private String remake;

    private String isva;

    public String getKmpId() {
        return kmpId;
    }

    public void setKmpId(String kmpId) {
        this.kmpId = kmpId == null ? null : kmpId.trim();
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId == null ? null : saleId.trim();
    }

    public String getKinId() {
        return kinId;
    }

    public void setKinId(String kinId) {
        this.kinId = kinId == null ? null : kinId.trim();
    }

    public Integer getKmpNum() {
        return kmpNum;
    }

    public void setKmpNum(Integer kmpNum) {
        this.kmpNum = kmpNum;
    }

    public BigDecimal getKmpPrice() {
        return kmpPrice;
    }

    public void setKmpPrice(BigDecimal kmpPrice) {
        this.kmpPrice = kmpPrice;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake == null ? null : remake.trim();
    }

    public String getIsva() {
        return isva;
    }

    public void setIsva(String isva) {
        this.isva = isva == null ? null : isva.trim();
    }
}