package com.yidu.model;

import java.math.BigDecimal;

public class ErpProlistmxsmall {
    private String fdprolistmxId;

    private String fdproId;

    private String kinId;

    private String fdprolistmxNumber;

    private double fdprolistmxMoney;

    private Integer fdprolistmxCount;

    private String fdprolistmxTime;

    private String remark;
    
    private String isva;
    
    private String kinName;
    
    private String kinPrice;
    
    
    
    
    

    public double getFdprolistmxMoney() {
		return fdprolistmxMoney;
	}

	public void setFdprolistmxMoney(double fdprolistmxMoney) {
		this.fdprolistmxMoney = fdprolistmxMoney;
	}

	public String getKinPrice() {
		return kinPrice;
	}

	public void setKinPrice(String kinPrice) {
		this.kinPrice = kinPrice;
	}

	public String getKinName() {
		return kinName;
	}

	public void setKinName(String kinName) {
		this.kinName = kinName;
	}

	public String getIsva() {
		return isva;
	}

	public void setIsva(String isva) {
		this.isva = isva;
	}

	public String getFdprolistmxId() {
        return fdprolistmxId;
    }

    public void setFdprolistmxId(String fdprolistmxId) {
        this.fdprolistmxId = fdprolistmxId == null ? null : fdprolistmxId.trim();
    }

    public String getFdproId() {
        return fdproId;
    }

    public void setFdproId(String fdproId) {
        this.fdproId = fdproId == null ? null : fdproId.trim();
    }

    public String getKinId() {
        return kinId;
    }

    public void setKinId(String kinId) {
        this.kinId = kinId == null ? null : kinId.trim();
    }

    public String getFdprolistmxNumber() {
        return fdprolistmxNumber;
    }

    public void setFdprolistmxNumber(String fdprolistmxNumber) {
        this.fdprolistmxNumber = fdprolistmxNumber == null ? null : fdprolistmxNumber.trim();
    }

    

    public Integer getFdprolistmxCount() {
        return fdprolistmxCount;
    }

    public void setFdprolistmxCount(Integer fdprolistmxCount) {
        this.fdprolistmxCount = fdprolistmxCount;
    }

    public String getFdprolistmxTime() {
        return fdprolistmxTime;
    }

    public void setFdprolistmxTime(String fdprolistmxTime) {
        this.fdprolistmxTime = fdprolistmxTime == null ? null : fdprolistmxTime.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}