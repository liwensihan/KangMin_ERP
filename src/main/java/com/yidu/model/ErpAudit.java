package com.yidu.model;

/**
 * 审核类
 * @author 胡鑫
 * @dete 2017年11月15日11:45:52
 *
 */
public class ErpAudit {
    private String audId;//审核主键id
    
    private String businessId;//业务id

	private String purcId;

    private String indentId;

    private String pactId;

    private String bankId;

    private String audSerial;//审核编号

    private String audName;//审核人

    private String audTime;//审核时间

    private Integer state;//审核状态

    private String feedBack;//反馈信息
    
    private String createtime;//创建时间

    private String creater;//创建人

    private Integer isva;//是否有效
    
    private String remark;//备注
    
    /**
     * 审核主键id
     * @return
     */
	public String getAudId() {
		return audId;
	}

	/**
	 * 审核主键id
	 * @param audId
	 */
	public void setAudId(String audId) {
		this.audId = audId;
	}
	/**
	 * //业务id
	 * @return
	 */
	public String getBusinessId() {
		return businessId;
	}
	/**
	 * //业务id
	 * @param businessId
	 */
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getPurcId() {
		return purcId;
	}

	public void setPurcId(String purcId) {
		this.purcId = purcId;
	}

	public String getIndentId() {
		return indentId;
	}

	public void setIndentId(String indentId) {
		this.indentId = indentId;
	}

	public String getPactId() {
		return pactId;
	}

	public void setPactId(String pactId) {
		this.pactId = pactId;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	/**
	 * //审核编号
	 * @return
	 */
	public String getAudSerial() {
		return audSerial;
	}
	/**
	 * //审核编号
	 * @param audSerial
	 */
	public void setAudSerial(String audSerial) {
		this.audSerial = audSerial;
	}
	/**
	 * 审核人
	 * @return
	 */
	public String getAudName() {
		return audName;
	}
	/**
	 * 审核人
	 * @param audName
	 */
	public void setAudName(String audName) {
		this.audName = audName;
	}
	/**
	 * 审核时间
	 * @return
	 */
	public String getAudTime() {
		return audTime;
	}
	/**
	 * 审核时间
	 * @param audTime
	 */
	public void setAudTime(String audTime) {
		this.audTime = audTime;
	}
	/**
	 * 审核状态
	 * @return
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * 审核状态
	 * @param state
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 反馈
	 * @return
	 */
	public String getFeedBack() {
		return feedBack;
	}
	/**
	 * 反馈
	 * @param feedBack
	 */
	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
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
	 * @param createtime
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	/**
	 * 创建人
	 * @return
	 */
	public String getCreater() {
		return creater;
	}
	/**
	 * 创建人
	 * @param creater
	 */
	public void setCreater(String creater) {
		this.creater = creater;
	}
	/**
	 * 是否有效
	 * @return
	 */
	public Integer getIsva() {
		return isva;
	}
	/**
	 * 是否有效
	 * @param isva
	 */
	public void setIsva(Integer isva) {
		this.isva = isva;
	}
	/**
	 * 备注
	 * @return
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 备注
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
    
	   
}