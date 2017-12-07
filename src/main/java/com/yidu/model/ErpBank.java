package com.yidu.model;

import java.util.List;

/**
 * 入库单表
 * @author Gjwen
 * 2017年11月13日-上午8:58:05
 */
public class ErpBank {
    private Integer bankIsva;
    private String bankId;

    private String bankNumber;

    private String bankTime;

    private Integer bankCount;

    private String bankStaffid;

    private Integer isva;

    private String createtime;

    private String creater;

    private String reaark;
    
    private String bankNum;//数量
    
    private Double bankPrice;//价格
    private String staName;
    
    public String getStaName() {
		return staName;
	}

	public void setStaName(String staName) {
		this.staName = staName;
	}

	private List<ErpInvedet> det;
    
    public List<ErpInvedet> getDet() {
		return det;
	}

	public void setDet(List<ErpInvedet> det) {
		this.det = det;
	}

	public Integer getBankIsva() {
		return bankIsva;
	}

	public void setBankIsva(Integer bankIsva) {
		this.bankIsva = bankIsva;
	}

	/**
     * 采购表信息
     */
    private String purcTitle;//采购标题
    private String purcName;//采购人
    private String purcSerial;
    private Double purcTotalPrice;//总金额
    /**
     * 生产表
     */
    private String indentNumber;//生产数量
    private String indentMoney;//生产金额
    
    private String yaoPing;
    
    
	public Double getPurcTotalPrice() {
		return purcTotalPrice;
	}

	public void setPurcTotalPrice(Double purcTotalPrice) {
		this.purcTotalPrice = purcTotalPrice;
	}

	public String getBankNum() {
		return bankNum;
	}

	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}

	public Double getBankPrice() {
		return bankPrice;
	}

	public void setBankPrice(Double bankPrice) {
		this.bankPrice = bankPrice;
	}

	public String getYaoPing() {
		return yaoPing;
	}

	public void setYaoPing(String yaoPing) {
		this.yaoPing = yaoPing;
	}

	public String getPurcTitle() {
		return purcTitle;
	}

	public void setPurcTitle(String purcTitle) {
		this.purcTitle = purcTitle;
	}

	public String getPurcName() {
		return purcName;
	}

	public void setPurcName(String purcName) {
		this.purcName = purcName;
	}

	public String getPurcSerial() {
		return purcSerial;
	}

	public void setPurcSerial(String purcSerial) {
		this.purcSerial = purcSerial;
	}

	public String getIndentNumber() {
		return indentNumber;
	}

	public void setIndentNumber(String indentNumber) {
		this.indentNumber = indentNumber;
	}

	public String getIndentMoney() {
		return indentMoney;
	}

	public void setIndentMoney(String indentMoney) {
		this.indentMoney = indentMoney;
	}

	public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId == null ? null : bankId.trim();
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber == null ? null : bankNumber.trim();
    }

    public String getBankTime() {
        return bankTime;
    }

    public void setBankTime(String bankTime) {
        this.bankTime = bankTime == null ? null : bankTime.trim();
    }

    public Integer getBankCount() {
        return bankCount;
    }

    public void setBankCount(Integer bankCount) {
        this.bankCount = bankCount;
    }

    public String getBankStaffid() {
        return bankStaffid;
    }

    public void setBankStaffid(String bankStaffid) {
        this.bankStaffid = bankStaffid == null ? null : bankStaffid.trim();
    }

    public Integer getIsva() {
        return isva;
    }

    public void setIsva(Integer isva) {
        this.isva = isva;
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

    public String getReaark() {
        return reaark;
    }

    public void setReaark(String reaark) {
        this.reaark = reaark == null ? null : reaark.trim();
    }
}