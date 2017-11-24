package com.yidu.model;

import java.math.BigDecimal;

public class ErpBurden {
    private String burId;

    private String rawId;

    private String kinId;

    private String burSerial;

    private String burUnit;

    private BigDecimal burG;

    private String createtime;

    private String creater;

    private Integer isva;
    private String rawName;
    
    public String getRawName() {
		return rawName;
	}

	public void setRawName(String rawName) {
		this.rawName = rawName;
	}

	public String getBurId() {
        return burId;
    }

    public void setBurId(String burId) {
        this.burId = burId == null ? null : burId.trim();
    }

    public String getRawId() {
        return rawId;
    }

    public void setRawId(String rawId) {
        this.rawId = rawId == null ? null : rawId.trim();
    }

    public String getKinId() {
        return kinId;
    }

    public void setKinId(String kinId) {
        this.kinId = kinId == null ? null : kinId.trim();
    }

    public String getBurSerial() {
        return burSerial;
    }

    public void setBurSerial(String burSerial) {
        this.burSerial = burSerial == null ? null : burSerial.trim();
    }

    public String getBurUnit() {
        return burUnit;
    }

    public void setBurUnit(String burUnit) {
        this.burUnit = burUnit == null ? null : burUnit.trim();
    }

    public BigDecimal getBurG() {
        return burG;
    }

    public void setBurG(BigDecimal burG) {
        this.burG = burG;
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

    public Integer getIsva() {
        return isva;
    }

    public void setIsva(Integer isva) {
        this.isva = isva;
    }
}