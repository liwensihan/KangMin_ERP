package com.yidu.model;

public class ErpInvedet {
    private String invedetId;

    private String bankId;

    private String wareId;

    private String obId;

    private String kinId;

    private Integer invedetNum;

    private String creater;

    private String createtime;

    private String remark;

    private Integer isva;

    public String getInvedetId() {
        return invedetId;
    }

    public void setInvedetId(String invedetId) {
        this.invedetId = invedetId == null ? null : invedetId.trim();
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId == null ? null : bankId.trim();
    }

    public String getWareId() {
        return wareId;
    }

    public void setWareId(String wareId) {
        this.wareId = wareId == null ? null : wareId.trim();
    }

    public String getObId() {
        return obId;
    }

    public void setObId(String obId) {
        this.obId = obId == null ? null : obId.trim();
    }

    public String getKinId() {
        return kinId;
    }

    public void setKinId(String kinId) {
        this.kinId = kinId == null ? null : kinId.trim();
    }

    public Integer getInvedetNum() {
        return invedetNum;
    }

    public void setInvedetNum(Integer invedetNum) {
        this.invedetNum = invedetNum;
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