package com.yidu.model;

public class ErpIncome {
    private String incomeId;

    private String incomeSerial;

    private String financeId;

    private String payId;

    private String createtime;

    private String creater;

    private String remark;

    private Integer isva;

    public String getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(String incomeId) {
        this.incomeId = incomeId == null ? null : incomeId.trim();
    }

    public String getIncomeSerial() {
        return incomeSerial;
    }

    public void setIncomeSerial(String incomeSerial) {
        this.incomeSerial = incomeSerial == null ? null : incomeSerial.trim();
    }

    public String getFinanceId() {
        return financeId;
    }

    public void setFinanceId(String financeId) {
        this.financeId = financeId == null ? null : financeId.trim();
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId == null ? null : payId.trim();
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