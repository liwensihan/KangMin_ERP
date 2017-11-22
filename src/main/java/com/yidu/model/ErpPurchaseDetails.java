package com.yidu.model;

public class ErpPurchaseDetails {
    private String purDetId;

    private String purcId;

    private String rowId;//原材料ID

    private String purDetSerial;
    
    private Double purcTotalPrice;//总价格
    
    private Integer purcTotalNumber;//总数量
    
    private String rawName;//原材料名字
    
  
    public String getRawName() {
		return rawName;
	}

	public void setRawName(String rawName) {
		this.rawName = rawName;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public Double getPurcTotalPrice() {
		return purcTotalPrice;
	}

	public void setPurcTotalPrice(Double purcTotalPrice) {
		this.purcTotalPrice = purcTotalPrice;
	}

	public Integer getPurcTotalNumber() {
		return purcTotalNumber;
	}

	public void setPurcTotalNumber(Integer purcTotalNumber) {
		this.purcTotalNumber = purcTotalNumber;
	}

	public String getPurDetId() {
        return purDetId;
    }

    public void setPurDetId(String purDetId) {
        this.purDetId = purDetId == null ? null : purDetId.trim();
    }

    public String getPurcId() {
        return purcId;
    }

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