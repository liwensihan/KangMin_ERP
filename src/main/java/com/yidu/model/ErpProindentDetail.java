package com.yidu.model;

import java.math.BigDecimal;

/**
 * 订单明细
 * @author dong
 * 2017年12月14日
 */
public class ErpProindentDetail {
    private String entdeId;

    private String kinId;

    private String indentId;

    private Integer entdeNum;

    private Integer num;

    private BigDecimal entdePrice;

    private String creater;

    private String createtime;

    private String remark;

    private String isva;
    private String kindName;
    

    public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	/**
	 * 生产订单明细id
	 * @return
	 */
    public String getEntdeId() {
        return entdeId;
    }
    /**
	 * 生产订单明细id
	 * @return
	 */
    public void setEntdeId(String entdeId) {
        this.entdeId = entdeId == null ? null : entdeId.trim();
    }
    /**
     * ID(货品表)
     * @return
     */
    public String getKinId() {
        return kinId;
    }
    /**
     * ID(货品表)
     * @return
     */
    public void setKinId(String kinId) {
        this.kinId = kinId == null ? null : kinId.trim();
    }
    /**
     * 生产订单主键
     * @return
     */
    public String getIndentId() {
        return indentId;
    }
    /**
     * 生产订单主键
     * @return
     */
    public void setIndentId(String indentId) {
        this.indentId = indentId == null ? null : indentId.trim();
    }
	/**
	 * 总数量
	 * @return
	 */
    public Integer getEntdeNum() {
        return entdeNum;
    }
    /**
	 * 总数量
	 * @return
	 */
    public void setEntdeNum(Integer entdeNum) {
        this.entdeNum = entdeNum;
    }
    /**
     * 已生产的总数量
     * @return
     */
    public Integer getNum() {
        return num;
    }
    /**
     * 已生产的总数量
     * @return
     */
    public void setNum(Integer num) {
        this.num = num;
    }
    /**
     * 金额
     * @return
     */
    public BigDecimal getEntdePrice() {
        return entdePrice;
    }
    /**
     * 金额
     * @return
     */
    public void setEntdePrice(BigDecimal entdePrice) {
        this.entdePrice = entdePrice;
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
     * @return
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
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
     * 备注
     * @return
     */
    public String getRemark() {
        return remark;
    }
    /**
     * 备注
     * @return
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 是否有效
     * @return
     */
    public String getIsva() {
        return isva;
    }
    /**
     * 是否有效
     * @return
     */
    public void setIsva(String isva) {
        this.isva = isva == null ? null : isva.trim();
    }
}