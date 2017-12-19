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
    /**
     * 要材料名字
     * @return
     */
    public String getRawName() {
		return rawName;
	}
    /**
     * 原材料名字
     * @param rawName
     */
	public void setRawName(String rawName) {
		this.rawName = rawName;
	}
    /**
     * 配方id
     * @return
     */
	public String getBurId() {
        return burId;
    }
    /**
     * 配方id
     * @param burId
     */
    public void setBurId(String burId) {
        this.burId = burId == null ? null : burId.trim();
    }
    /**
     * 原材料id
     * @return
     */
    public String getRawId() {
        return rawId;
    }
    /**
     * 原材料id
     * @param rawId
     */
    public void setRawId(String rawId) {
        this.rawId = rawId == null ? null : rawId.trim();
    }
    /**
     * 药品id
     * @return
     */
    public String getKinId() {
        return kinId;
    }
    /**
     * 药品id
     * @param kinId
     */
    public void setKinId(String kinId) {
        this.kinId = kinId == null ? null : kinId.trim();
    }
    /**
     * 配方编号
     * @return
     */
    public String getBurSerial() {
        return burSerial;
    }
    /**
     * 配方编号
     * @param burSerial
     */
    public void setBurSerial(String burSerial) {
        this.burSerial = burSerial == null ? null : burSerial.trim();
    }
    /**
     * 配方编号
     * @return
     */
    public String getBurUnit() {
        return burUnit;
    }
    /**
     * 配方编号
     * @param burUnit
     */
    public void setBurUnit(String burUnit) {
        this.burUnit = burUnit == null ? null : burUnit.trim();
    }
    /**
     * 配方净含量
     * @return
     */
    public BigDecimal getBurG() {
        return burG;
    }
    /**
     * 配方净含量
     * @param burG
     */
    public void setBurG(BigDecimal burG) {
        this.burG = burG;
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
}