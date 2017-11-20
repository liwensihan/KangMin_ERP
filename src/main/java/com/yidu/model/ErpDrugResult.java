package com.yidu.model;

import java.util.List;

/**
 * 药品药效表
 * @author 大晶儿
 * @date 2017年10月19日
 */
public class ErpDrugResult {
	
    private String drugResId;//药品药效表id

    private String resId;//药效表id

    private String rawId;//原材料id

    private String kinId;//货品id
    
    private List<ErpResuit> res; //药效的集合
    
    public List<ErpResuit> getRes() {
		return res;
	}
	public void setRes(List<ErpResuit> res) {
		this.res = res;
	}
	/**
     * 药品药效表id
     * @return
     */
    public String getDrugResId() {
        return drugResId;
    }
    /**
     * 药品药效表id
     * @param drugResId
     */
    public void setDrugResId(String drugResId) {
        this.drugResId = drugResId == null ? null : drugResId.trim();
    }
    /**
     * 药效表id
     * @return
     */
    public String getResId() {
        return resId;
    }
    /**
     * 要效表id
     * @param resId
     */
    public void setResId(String resId) {
        this.resId = resId == null ? null : resId.trim();
    }
    /**
     * 原材料表
     * @return
     */
    public String getRawId() {
        return rawId;
    }
    /**
     * 原材料表
     * @param rawId
     */
    public void setRawId(String rawId) {
        this.rawId = rawId == null ? null : rawId.trim();
    }
    /**
     * 货品表
     * @return
     */
    public String getKinId() {
        return kinId;
    }
    /**
     * 货品表
     * @param kinId
     */
    public void setKinId(String kinId) {
        this.kinId = kinId == null ? null : kinId.trim();
    }
}