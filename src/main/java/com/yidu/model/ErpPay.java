package com.yidu.model;

import java.math.BigDecimal;

public class ErpPay {
    private String payId;//支付单id

    private String kinordId;//货品订单表id

    private String financeId;//财务id

    private String paySerial;//支付单编号

    private String payAdd;//支付生产时间

    private String payName;//支付人

    private BigDecimal payNum;//支付金额

    private String createtime;//创建时间

    private String creater;//创建人
    
    private Integer isva;
    
    
    
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
     * 支付单id
     * @return
     */
	public String getPayId() {
		return payId;
	}

	/**
     * 支付单id
     * @return
     */
	public void setPayId(String payId) {
		this.payId = payId;
	}

	/**
	 * 货品订单表id
	 * @return
	 */
	public String getKinordId() {
		return kinordId;
	}
	
	/**
	 * 货品订单表id
	 * @return
	 */
	public void setKinordId(String kinordId) {
		this.kinordId = kinordId;
	}
	
	/**
	 * 财务id
	 * @return
	 */
	public String getFinanceId() {
		return financeId;
	}

	/**
	 * 财务id
	 * @param financeId
	 */
	public void setFinanceId(String financeId) {
		this.financeId = financeId;
	}

	/**
	 * 支付表编号
	 * @param financeId
	 */
	public String getPaySerial() {
		return paySerial;
	}

	/**
	 * 支付表编号
	 * @param financeId
	 */
	public void setPaySerial(String paySerial) {
		this.paySerial = paySerial;
	}

	/**
	 * 增加时间
	 * @param financeId
	 */
	public String getPayAdd() {
		return payAdd;
	}

	/**
	 * 增加时间
	 * @param financeId
	 */
	public void setPayAdd(String payAdd) {
		this.payAdd = payAdd;
	}

	/**
	 * 增加人
	 * @param financeId
	 */
	public String getPayName() {
		return payName;
	}

	/**
	 * 增加人
	 * @param financeId
	 */
	public void setPayName(String payName) {
		this.payName = payName;
	}

	/**
	 * 支付价格
	 * @param financeId
	 */
	public BigDecimal getPayNum() {
		return payNum;
	}

	/**
	 * 支付价格
	 * @param financeId
	 */
	public void setPayNum(BigDecimal payNum) {
		this.payNum = payNum;
	}

	/**
	 * 创建时间
	 * @param financeId
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * 创建时间
	 * @param financeId
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
	/**
	 * 创建人
	 * @param financeId
	 */
	public String getCreater() {
		return creater;
	}

	/**
	 * 创建人
	 * @param financeId
	 */
	public void setCreater(String creater) {
		this.creater = creater;
	}

   
}