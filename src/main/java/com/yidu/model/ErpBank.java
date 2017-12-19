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
    /**
     * 创建人名字
     * @return
     */
    public String getStaName() {
		return staName;
	}
    /**
     * 创建人名字
     * @param staName
     */
	public void setStaName(String staName) {
		this.staName = staName;
	}
    /**
     * 库存明细 集合
     */
	private List<ErpInvedet> det;
    /**
     * 库存明细集合
     * @return
     */
    public List<ErpInvedet> getDet() {
		return det;
	}
    /**
     * 库存明细集合
     * @param det
     */
	public void setDet(List<ErpInvedet> det) {
		this.det = det;
	}
    /**
     *入库状态
     * @return
     */
	public Integer getBankIsva() {
		return bankIsva;
	}
    /**
     * 入库状态
     * @param bankIsva
     */
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
    
    /**
     * 总金额
     * @return
     */
	public Double getPurcTotalPrice() {
		return purcTotalPrice;
	}
    /**
     * 总金额
     * @param purcTotalPrice
     */
	public void setPurcTotalPrice(Double purcTotalPrice) {
		this.purcTotalPrice = purcTotalPrice;
	}
    /**
     * 入库数量
     * @return
     */
	public String getBankNum() {
		return bankNum;
	}
    /**
     * 入库数量
     * @param bankNum
     */
	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}
    /**
     * 入库价格
     * @return
     */
	public Double getBankPrice() {
		return bankPrice;
	}
    /**
     * 入库价格
     * @param bankPrice
     */
	public void setBankPrice(Double bankPrice) {
		this.bankPrice = bankPrice;
	}
    /**
     *药品
     * @return
     */
	public String getYaoPing() {
		return yaoPing;
	}
    /**
     * 药品
     * @param yaoPing
     */
	public void setYaoPing(String yaoPing) {
		this.yaoPing = yaoPing;
	}
    /**
     * 采购标题
     * @return
     */
	public String getPurcTitle() {
		return purcTitle;
	}
    /**
     * 采购标题
     * @param purcTitle
     */
	public void setPurcTitle(String purcTitle) {
		this.purcTitle = purcTitle;
	}
    /**
     * 采购名字
     * @return
     */
	public String getPurcName() {
		return purcName;
	}
    /**
     * 采购名字
     * @param purcName
     */
	public void setPurcName(String purcName) {
		this.purcName = purcName;
	}
    /**
     * 采购编号
     * @return
     */
	public String getPurcSerial() {
		return purcSerial;
	}
    /**
     * 采购编号
     * @param purcSerial
     */
	public void setPurcSerial(String purcSerial) {
		this.purcSerial = purcSerial;
	}
    /**
     * 生产数量
     * @return
     */
	public String getIndentNumber() {
		return indentNumber;
	}
    /**
     * 生产数量
     * @param indentNumber
     */
	public void setIndentNumber(String indentNumber) {
		this.indentNumber = indentNumber;
	}
    /**
     * 生产金额
     * @return
     */
	public String getIndentMoney() {
		return indentMoney;
	}
    /**
     * 生产金额
     * @param indentMoney
     */
	public void setIndentMoney(String indentMoney) {
		this.indentMoney = indentMoney;
	}
    /**
     * 入库id
     * @return
     */
	public String getBankId() {
        return bankId;
    }
    /**
     * 入库id
     * @param bankId
     */
    public void setBankId(String bankId) {
        this.bankId = bankId == null ? null : bankId.trim();
    }
    /**
     * 入库数量
     * @return
     */
    public String getBankNumber() {
        return bankNumber;
    }
    /**
     * 入库数量
     * @param bankNumber
     */
    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber == null ? null : bankNumber.trim();
    }
    /**
     * 入库时间
     * @return
     */
    public String getBankTime() {
        return bankTime;
    }
    /**
     * 入库时间
     * @param bankTime
     */
    public void setBankTime(String bankTime) {
        this.bankTime = bankTime == null ? null : bankTime.trim();
    }
    /**
     * 入库数量
     * @return
     */
    public Integer getBankCount() {
        return bankCount;
    }
    /**
     * 入库数量
     * @param bankCount
     */
    public void setBankCount(Integer bankCount) {
        this.bankCount = bankCount;
    }
    /**
     * 入库人
     * @return
     */
    public String getBankStaffid() {
        return bankStaffid;
    }
    /**
     * 入库人
     * @param bankStaffid
     */
    public void setBankStaffid(String bankStaffid) {
        this.bankStaffid = bankStaffid == null ? null : bankStaffid.trim();
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
     * @param creater
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }
    /**
     * 备注
     * @return
     */
    public String getReaark() {
        return reaark;
    }
    /**
     * 备注
     * @param reaark
     */

    public void setReaark(String reaark) {
        this.reaark = reaark == null ? null : reaark.trim();
    }
}