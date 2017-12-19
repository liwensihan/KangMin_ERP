package com.yidu.model;

public class ErpSumstock {
    private String stockId;

    private String annexId;

    private String stockSreial;

    private String kinId;

    private String staId;

    private Integer stockSuount;

    private String createtime;

    private String creater;

    private String remark;

    private Integer isva;

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId == null ? null : stockId.trim();
    }

    public String getAnnexId() {
        return annexId;
    }

    public void setAnnexId(String annexId) {
        this.annexId = annexId == null ? null : annexId.trim();
    }

    public String getStockSreial() {
        return stockSreial;
    }

    public void setStockSreial(String stockSreial) {
        this.stockSreial = stockSreial == null ? null : stockSreial.trim();
    }

    public String getKinId() {
        return kinId;
    }

    public void setKinId(String kinId) {
        this.kinId = kinId == null ? null : kinId.trim();
    }

    public String getStaId() {
        return staId;
    }

    public void setStaId(String staId) {
        this.staId = staId == null ? null : staId.trim();
    }

    public Integer getStockSuount() {
        return stockSuount;
    }

    public void setStockSuount(Integer stockSuount) {
        this.stockSuount = stockSuount;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getIsva() {
        return isva;
    }

    public void setIsva(Integer isva) {
        this.isva = isva;
    }
}