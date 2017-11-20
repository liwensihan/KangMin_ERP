package com.yidu.model;

import java.math.BigDecimal;
import java.util.Date;

public class ErpFdproform {
    private String fdproId;

    private String fdproSerial;

    private String annexId;

    private String staId;

    private Integer fdproNumber;

    private BigDecimal fdproWarecount;

    private Date fdproSumprice;

    private String fdproTime;

    private Integer fdproIsvo;

    private String createtime;

    private String creater;

    private String remark;

    private Integer isva;

    public String getFdproId() {
        return fdproId;
    }

    public void setFdproId(String fdproId) {
        this.fdproId = fdproId == null ? null : fdproId.trim();
    }

    public String getFdproSerial() {
        return fdproSerial;
    }

    public void setFdproSerial(String fdproSerial) {
        this.fdproSerial = fdproSerial == null ? null : fdproSerial.trim();
    }

    public String getAnnexId() {
        return annexId;
    }

    public void setAnnexId(String annexId) {
        this.annexId = annexId == null ? null : annexId.trim();
    }

    public String getStaId() {
        return staId;
    }

    public void setStaId(String staId) {
        this.staId = staId == null ? null : staId.trim();
    }

    public Integer getFdproNumber() {
        return fdproNumber;
    }

    public void setFdproNumber(Integer fdproNumber) {
        this.fdproNumber = fdproNumber;
    }

    public BigDecimal getFdproWarecount() {
        return fdproWarecount;
    }

    public void setFdproWarecount(BigDecimal fdproWarecount) {
        this.fdproWarecount = fdproWarecount;
    }

    public Date getFdproSumprice() {
        return fdproSumprice;
    }

    public void setFdproSumprice(Date fdproSumprice) {
        this.fdproSumprice = fdproSumprice;
    }

    public String getFdproTime() {
        return fdproTime;
    }

    public void setFdproTime(String fdproTime) {
        this.fdproTime = fdproTime == null ? null : fdproTime.trim();
    }

    public Integer getFdproIsvo() {
        return fdproIsvo;
    }

    public void setFdproIsvo(Integer fdproIsvo) {
        this.fdproIsvo = fdproIsvo;
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