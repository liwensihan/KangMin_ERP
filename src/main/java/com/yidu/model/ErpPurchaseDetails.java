package com.yidu.model;
/**
 * 采购详细Model
 * @author Gjwen
 * 上午8:46:05
 */
public class ErpPurchaseDetails {
    private String purDetId;

    private String purcId;

    private String rowId;//原材料ID

    private String purDetSerial;
    
    private Double purcTotalPrice;//总价格
    
    private Integer purcTotalNumber;//总数量
    
    private String rawName;
    
    private String kinName;
    
    private String kinId;
    
    public String getKinId() {
		return kinId;
	}

	public void setKinId(String kinId) {
		this.kinId = kinId;
	}

	public String getKinName() {
		return kinName;
	}

	public void setKinName(String kinName) {
		this.kinName = kinName;
	}

	public String getRawName() {
		return rawName;
	}

	public void setRawName(String rawName) {
		this.rawName = rawName;
	}

	public String getRowId() {
		return rowId;
	}
	/**
	 * 原材料ID
	 * @param rowId
	 */
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	public Double getPurcTotalPrice() {
		return purcTotalPrice;
	}
	/**
	 * 总价格
	 * @return
	 */
	public void setPurcTotalPrice(Double purcTotalPrice) {
		this.purcTotalPrice = purcTotalPrice;
	}

	public Integer getPurcTotalNumber() {
		return purcTotalNumber;
	}
	/**
	 * 总数量
	 * @param purcTotalNumber
	 */
	public void setPurcTotalNumber(Integer purcTotalNumber) {
		this.purcTotalNumber = purcTotalNumber;
	}
	
	public String getPurDetId() {
        return purDetId;
    }
	/**
	 * 订单详细ID
	 * @return
	 */
    public void setPurDetId(String purDetId) {
        this.purDetId = purDetId == null ? null : purDetId.trim();
    }

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

    public String getPurDetSerial() {
        return purDetSerial;
    }

    public void setPurDetSerial(String purDetSerial) {
        this.purDetSerial = purDetSerial == null ? null : purDetSerial.trim();
    }
}