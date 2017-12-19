package com.yidu.model;

import java.util.List;

/**
 * 采购订单Model
 * @author Gjwen
 * 2017年10月19日-下午3:09:53
 */
public class ErpPurchase {
    private String purcId;//采购订单表ID

    private String purcSerial;//采购编号

    private String purcTitle;//采购标题

    private String purcName;//采购人

    private Integer state;//状态

    private String purcTime;//采购时间

    private String creater;//创建人

    private String createtime;//创建时间

    private Integer isva;//是否有效
    private String remark;//备注
    
    private Double purcTotalPrice;//总数价格
    private List<ErpPurchaseDetails> det;
    
    public List<ErpPurchaseDetails> getDet() {
		return det;
	}

	public void setDet(List<ErpPurchaseDetails> det) {
		this.det = det;
	}

	/**
     * 以下为查看详情所用数据
     */
    private String purcTotalPriceDetails;//采购详细表单价
    
    private String rawName;//原材料名
   

	public String getPurcTotalPriceDetails() {
		return purcTotalPriceDetails;
	}

	public void setPurcTotalPriceDetails(String purcTotalPriceDetails) {
		this.purcTotalPriceDetails = purcTotalPriceDetails;
	}

	public String getRawName() {
		return rawName;
	}

	public void setRawName(String rawName) {
		this.rawName = rawName;
	}

	public Double getPurcTotalPrice() {
		return purcTotalPrice;
	}
	/**
	 * 总价格
	 * @param purcTotalPrice
	 */
	public void setPurcTotalPrice(Double purcTotalPrice) {
		this.purcTotalPrice = purcTotalPrice;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 采购ID
	 * @return
	 */
	public String getPurcId() {
        return purcId;
    }
	/**
	 * 采购ID
	 * @param purcId
	 */
    public void setPurcId(String purcId) {
        this.purcId = purcId == null ? null : purcId.trim();
    }

    public String getPurcSerial() {
        return purcSerial;
    }
    /**
     * 采购编号
     * @param purcSerial
     */
    public void setPurcSerial(String purcSerial) {
        this.purcSerial = purcSerial == null ? null : purcSerial.trim();
    }

    public String getPurcTitle() {
        return purcTitle;
    }

    public void setPurcTitle(String purcTitle) {
        this.purcTitle = purcTitle == null ? null : purcTitle.trim();
    }

    public String getPurcName() {
        return purcName;
    }
    /**
     * 采购人员
     * @param purcName
     */
    public void setPurcName(String purcName) {
        this.purcName = purcName == null ? null : purcName.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPurcTime() {
        return purcTime;
    }
    /**
     * 采购时间
     * @param purcTime
     */
    public void setPurcTime(String purcTime) {
        this.purcTime = purcTime == null ? null : purcTime.trim();
    }

    public String getCreater() {
        return creater;
    }
    /**
     * 设置采购原材料为1
     * @param creater
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getCreatetime() {
        return createtime;
    }
    /**
     * 创建时间
     * @param createtime
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public Integer getIsva() {
        return isva;
    }
    /**
     * 状态
     * @param isva
     */
    public void setIsva(Integer isva) {
        this.isva = isva;
    }
}