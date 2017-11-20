package com.yidu.model;

import java.math.BigDecimal;

public class ErpApplyasset {
    private String appassId;//申请表id
    private String purcId;//采购订单id
    private String financeId;//财务单id
    private String appassSerial;//申请表编号

    private String appassApply;//申请人

    private String appassType;//申请类型

    private Integer state;//申请状态

    private String appassTime;//申请时间
    private Double appassNum;//申请金额
    private Integer isva;//是否有效

    private String remark;//备注
    
    
	public Double getAppassNum() {
		return appassNum;
	}

	public void setAppassNum(Double appassNum) {
		this.appassNum = appassNum;
	}

	public String getAppassId() {
		return appassId;
	}

	public void setAppassId(String appassId) {
		this.appassId = appassId;
	}

	public String getPurcId() {
		return purcId;
	}

	public void setPurcId(String purcId) {
		this.purcId = purcId;
	}

	public String getFinanceId() {
		return financeId;
	}

	public void setFinanceId(String financeId) {
		this.financeId = financeId;
	}

	public String getAppassSerial() {
		return appassSerial;
	}

	public void setAppassSerial(String appassSerial) {
		this.appassSerial = appassSerial;
	}

	public String getAppassApply() {
		return appassApply;
	}

	public void setAppassApply(String appassApply) {
		this.appassApply = appassApply;
	}

	public String getAppassType() {
		return appassType;
	}

	public void setAppassType(String appassType) {
		this.appassType = appassType;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getAppassTime() {
		return appassTime;
	}

	public void setAppassTime(String appassTime) {
		this.appassTime = appassTime;
	}

	public Integer getIsva() {
		return isva;
	}

	public void setIsva(Integer isva) {
		this.isva = isva;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

    
}