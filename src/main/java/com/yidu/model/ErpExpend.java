package com.yidu.model;

public class ErpExpend {
    private String expendId;

    private String financeId;

    private String appassId;

    private String expendSerial;

    private String createtime;

    private String creater;

    private String remark;

    private Integer isva;

    public String getExpendId() {
        return expendId;
    }

    public void setExpendId(String expendId) {
        this.expendId = expendId == null ? null : expendId.trim();
    }

    public String getFinanceId() {
        return financeId;
    }

    public void setFinanceId(String financeId) {
        this.financeId = financeId == null ? null : financeId.trim();
    }

    public String getAppassId() {
        return appassId;
    }

    public void setAppassId(String appassId) {
        this.appassId = appassId == null ? null : appassId.trim();
    }

    public String getExpendSerial() {
        return expendSerial;
    }

    public void setExpendSerial(String expendSerial) {
        this.expendSerial = expendSerial == null ? null : expendSerial.trim();
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