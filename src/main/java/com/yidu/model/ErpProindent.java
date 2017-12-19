package com.yidu.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单
 * @author dong
 * 2017年12月14日
 */
public class ErpProindent {
	 private String indentId;


	    private String indentNumber;


	    private BigDecimal indentMoney;


	    private Integer indentCount;


	    private String indentUrgency;


	    private String indentEmetime;


	    private String indentWorktime;


	    private String indentEndtime;


	    private Integer state;


	    private String isva;


	    private String indentState;


	    private String remark;
	   
	    /**
	     * 订单状态
	     * @return
	     */
		public String getIndentState() {
			return indentState;
		}

		/**
	     * 订单状态
	     * @return
	     */
		public void setIndentState(String indentState) {
			this.indentState = indentState;
		}

		
		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		private String createtime;


	    private String creater;
    
    
    


    private List<ErpProindentDetail> det;
    
    public List<ErpProindentDetail> getDet() {
		return det;
	}

	public void setDet(List<ErpProindentDetail> det) {
		this.det = det;
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
	 * 生产订单编号
	 * @return
	 */
    public String getIndentNumber() {
        return indentNumber;
    }
    /**
	 * 生产订单编号
	 * @return
	 */
    public void setIndentNumber(String indentNumber) {
        this.indentNumber = indentNumber == null ? null : indentNumber.trim();
    }
    /**
     * 生产订单金额
     * @return
     */
    public BigDecimal getIndentMoney() {
        return indentMoney;
    }
    /**
     * 生产订单金额
     * @return
     */
    public void setIndentMoney(BigDecimal indentMoney) {
        this.indentMoney = indentMoney;
    }
    /**
     * 生产订单数量
     * @return
     */
    public Integer getIndentCount() {
        return indentCount;
    }
    /**
     * 生产订单数量
     * @return
     */
    public void setIndentCount(Integer indentCount) {
        this.indentCount = indentCount;
    }
    /**
     * 生产订单是否紧急
     * @return
     */
    public String getIndentUrgency() {
        return indentUrgency;
    }
    /**
     * 生产订单是否紧急
     * @return
     */
    public void setIndentUrgency(String indentUrgency) {
        this.indentUrgency = indentUrgency == null ? null : indentUrgency.trim();
    }

    /**
     * 生产订单生成时间
     * @return
     */
    public String getIndentEmetime() {
        return indentEmetime;
    }

    /**
     * 生产订单生成时间
     * @return
     */
    public void setIndentEmetime(String indentEmetime) {
        this.indentEmetime = indentEmetime == null ? null : indentEmetime.trim();
    }

    /**
     * 本次订单需要花费的时间
     * @return
     */
    public String getIndentWorktime() {
        return indentWorktime;
    }
    /**
     * 本次订单需要花费的时间
     * @return
     */
    public void setIndentWorktime(String indentWorktime) {
        this.indentWorktime = indentWorktime;
    }

    /**
     * 预计完成时间
     * @return
     */
    public String getIndentEndtime() {
        return indentEndtime;
    }
    /**
     * 预计完成时间
     * @return
     */
    public void setIndentEndtime(String indentEndtime) {
        this.indentEndtime = indentEndtime == null ? null : indentEndtime.trim();
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
     * @return
     */
    public void setState(Integer state) {
        this.state = state;
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
}