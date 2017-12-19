package com.yidu.model;

import java.math.BigDecimal;

public class ErpFinance {
    private String financeId;//财务id

    private String financeSerial;//财务表编号

    private BigDecimal financeNum;//总金额

    private String creatae;//创建人

    private String createtime;//创建时间

    private Integer isva;//是否有效

    private String remark;//备注

    /**
     * 财务id
     * @return
     */
    public String getFinanceId() {
        return financeId;
    }

    /**
     * 财务id
     * @return
     */
    public void setFinanceId(String financeId) {
        this.financeId = financeId == null ? null : financeId.trim();
    }

    /**
     * 财务编号
     * @return
     */
    public String getFinanceSerial() {
        return financeSerial;
    }
    
    
    /**
     * 财务编号
     * @return
     */
    public void setFinanceSerial(String financeSerial) {
        this.financeSerial = financeSerial == null ? null : financeSerial.trim();
    }

    /**
     * 财务金钱
     * @return
     */
    public BigDecimal getFinanceNum() {
        return financeNum;
    }

    /**
     * 财务金钱
     * @return
     */
    public void setFinanceNum(BigDecimal financeNum) {
        this.financeNum = financeNum;
    }

    /**
     * 创建人
     * @return
     */
    public String getCreatae() {
        return creatae;
    }

    /**
     * 创建人
     * @return
     */
    public void setCreatae(String creatae) {
        this.creatae = creatae == null ? null : creatae.trim();
    }

    /**
     * 创建时间
     * @return
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * 创建时间
     * @return
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    /**
     * 是否存在
     * @return
     */
    public Integer getIsva() {
        return isva;
    }

    /**
     * 是否存在
     * @return
     */
    public void setIsva(Integer isva) {
        this.isva = isva;
    }

    /**
     * 备注信息
     * @return
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注信息
     * @return
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}